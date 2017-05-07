package com.wjs.schedule.dao.exec;

import com.wjs.schedule.domain.exec.CuckooJobGroup;
import com.wjs.schedule.domain.exec.CuckooJobGroupCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooJobGroupMapper {
    /**
     * cuckoo_job_group数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_job_group数据表的操作方法: insert  
     * 
     */
    int insert(CuckooJobGroup record);

    /**
     * cuckoo_job_group数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooJobGroup record);

    /**
     * cuckoo_job_group数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooJobGroup> selectByExample(CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooJobGroup selectByPrimaryKey(Long id);

    /**
     * cuckoo_job_group数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooJobGroup lockByPrimaryKey(Long id);

    /**
     * cuckoo_job_group数据表的操作方法: lockByExample  
     * 
     */
    CuckooJobGroup lockByExample(CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooJobGroup> pageByExample(CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_job_group数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooJobGroup record, @Param("example") CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooJobGroup record, @Param("example") CuckooJobGroupCriteria example);

    /**
     * cuckoo_job_group数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooJobGroup record);

    /**
     * cuckoo_job_group数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooJobGroup record);
}