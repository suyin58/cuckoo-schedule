package com.wjs.schedule.dao.auth;

import com.wjs.schedule.domain.auth.CuckooAuthUser;
import com.wjs.schedule.domain.auth.CuckooAuthUserCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooAuthUserMapper {
    /**
     * cuckoo_auth_user数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_auth_user数据表的操作方法: insert  
     * 
     */
    int insert(CuckooAuthUser record);

    /**
     * cuckoo_auth_user数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooAuthUser record);

    /**
     * cuckoo_auth_user数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooAuthUser> selectByExample(CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooAuthUser selectByPrimaryKey(Long id);

    /**
     * cuckoo_auth_user数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooAuthUser lockByPrimaryKey(Long id);

    /**
     * cuckoo_auth_user数据表的操作方法: lockByExample  
     * 
     */
    CuckooAuthUser lockByExample(CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooAuthUser> pageByExample(CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_auth_user数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooAuthUser record, @Param("example") CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooAuthUser record, @Param("example") CuckooAuthUserCriteria example);

    /**
     * cuckoo_auth_user数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooAuthUser record);

    /**
     * cuckoo_auth_user数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooAuthUser record);
}