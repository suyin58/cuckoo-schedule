package com.wjs.util.mybatis;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import com.wjs.util.dao.PageDataList;

@Intercepts(@Signature(method = "handleResultSets", type = ResultSetHandler.class, args = { Statement.class }))
public class PagePlugin implements Interceptor {

	private Properties properties;

	private String pageMethod;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		DefaultResultSetHandler resultSetHandler = (DefaultResultSetHandler) invocation.getTarget();
		MetaObject metaResultSetHandler = MetaObject.forObject(resultSetHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory());

		MappedStatement stmt = (MappedStatement) metaResultSetHandler.getValue("mappedStatement");
		String id = stmt.getId();
		if (id.substring(id.lastIndexOf(".") + 1, id.length()).equals(pageMethod)) {
			
			Object obj = invocation.proceed();
			List list = (List) obj;
			Integer count = list.size();

			Connection connection = (Connection) metaResultSetHandler.getValue("executor.delegate.transaction.connection"); 
			ParameterHandler parameterHandler = (ParameterHandler) metaResultSetHandler.getValue("parameterHandler");  
			BoundSql boundSql = (BoundSql) metaResultSetHandler.getValue("parameterHandler.boundSql");
			
			int start = 0;
			int limit = 10;
			// 获取起始行和结束行
			Object parameterObject = parameterHandler.getParameterObject();
			Class parameterClaz = (Class) parameterObject.getClass();
			start = getField(parameterObject, parameterClaz, "start");
			
			limit = getField(parameterObject, parameterClaz, "limit");
			  
			String countSql = getCountSql(boundSql.getSql());
			count = getTotalRecord(connection, countSql, parameterHandler);
			
			
			PageDataList page = new PageDataList();
			page.setPageSize(limit);
			int curPage = start / limit + 1;
			page.setPage(curPage);
			page.setTotal(count);
			page.setRows(list);

			List<PageDataList> result = new ArrayList<PageDataList>();
			result.add(page);
			return result;
		}

		return invocation.proceed();
	}

	@SuppressWarnings("rawtypes")
	private int getField(Object parameterObject, Class clazz, String fieldName)
			throws NoSuchFieldException, IllegalAccessException {
		Field startField = null;
		for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
	            try {  
	            	startField = clazz.getDeclaredField(fieldName) ;  
	            	break;
	            } catch (Exception e) {  
	                // ingnore              
	            }   
	        }  
		
		if(null != startField){
			startField.setAccessible(true);
			return (Integer)startField.get(parameterObject);
		}else{
			throw new RuntimeException("please set field-start in a pageQry");
		}
	}

	private Integer getTotalRecord(Connection connection, String countSql, ParameterHandler parameterHandler) {

		PreparedStatement preparedStatement = null;  
        ResultSet resultSet = null;  
        try {  
  
            preparedStatement = connection.prepareStatement(countSql);  
            parameterHandler.setParameters(preparedStatement);  
            resultSet = preparedStatement.executeQuery();  
            resultSet.next();  
  
            return resultSet.getInt(1);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally {  
        	if(resultSet != null){
        		try {
					resultSet.close();
				} catch (SQLException e) {
					// ignore
				}
        	}
            if(preparedStatement != null){
            	try {
					preparedStatement.close();
				} catch (SQLException e) {
					// ignore
				}
            }
        }  
        return 0;  
	}

	private String getCountSql(String sql) {
		StringBuffer countSql = new StringBuffer(64);
		countSql.append("select count(1) from ");
		try {
			countSql.append(sql.substring(sql.indexOf("from")+4 , sql.lastIndexOf("limit")));
		} catch (RuntimeException e) {
			System.err.println(sql);
			e.printStackTrace();
		}
		return countSql.toString();
	}

	@Override
	public Object plugin(Object target) {

		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

		this.properties = properties;

	}

	public String getPageMethod() {

		return pageMethod;
	}

	public void setPageMethod(String pageMethod) {

		this.pageMethod = pageMethod;
	}

	public Properties getProperties() {

		return properties;
	}

}
