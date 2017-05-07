package com.wjs.schedule.dao.exec;

import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.domain.exec.CuckooJobExecLogCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooJobExecLogMapper {
    /**
     * cuckoo_job_exec_log数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_job_exec_log数据表的操作方法: insert  
     * 
     */
    int insert(CuckooJobExecLog record);

    /**
     * cuckoo_job_exec_log数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooJobExecLog record);

    /**
     * cuckoo_job_exec_log数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooJobExecLog> selectByExample(CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooJobExecLog selectByPrimaryKey(Long id);

    /**
     * cuckoo_job_exec_log数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooJobExecLog lockByPrimaryKey(Long id);

    /**
     * cuckoo_job_exec_log数据表的操作方法: lockByExample  
     * 
     */
    CuckooJobExecLog lockByExample(CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooJobExecLog> pageByExample(CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_job_exec_log数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooJobExecLog record, @Param("example") CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooJobExecLog record, @Param("example") CuckooJobExecLogCriteria example);

    /**
     * cuckoo_job_exec_log数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooJobExecLog record);

    /**
     * cuckoo_job_exec_log数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooJobExecLog record);
}