package com.wjs.schedule.dao.exec;

import com.wjs.schedule.domain.exec.CuckooJobDependency;
import com.wjs.schedule.domain.exec.CuckooJobDependencyCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooJobDependencyMapper {
    /**
     * cuckoo_job_dependency数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_job_dependency数据表的操作方法: insert  
     * 
     */
    int insert(CuckooJobDependency record);

    /**
     * cuckoo_job_dependency数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooJobDependency record);

    /**
     * cuckoo_job_dependency数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooJobDependency> selectByExample(CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooJobDependency selectByPrimaryKey(Long id);

    /**
     * cuckoo_job_dependency数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooJobDependency lockByPrimaryKey(Long id);

    /**
     * cuckoo_job_dependency数据表的操作方法: lockByExample  
     * 
     */
    CuckooJobDependency lockByExample(CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooJobDependency> pageByExample(CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_job_dependency数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooJobDependency record, @Param("example") CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooJobDependency record, @Param("example") CuckooJobDependencyCriteria example);

    /**
     * cuckoo_job_dependency数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooJobDependency record);

    /**
     * cuckoo_job_dependency数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooJobDependency record);
}