package com.wjs.schedule.dao.exec;

import com.wjs.schedule.domain.exec.CuckooJobExtend;
import com.wjs.schedule.domain.exec.CuckooJobExtendCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooJobExtendMapper {
    /**
     * cuckoo_job_extend数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long jobId);

    /**
     * cuckoo_job_extend数据表的操作方法: insert  
     * 
     */
    int insert(CuckooJobExtend record);

    /**
     * cuckoo_job_extend数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooJobExtend record);

    /**
     * cuckoo_job_extend数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooJobExtend> selectByExample(CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooJobExtend selectByPrimaryKey(Long jobId);

    /**
     * cuckoo_job_extend数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooJobExtend lockByPrimaryKey(Long jobId);

    /**
     * cuckoo_job_extend数据表的操作方法: lockByExample  
     * 
     */
    CuckooJobExtend lockByExample(CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooJobExtend> pageByExample(CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_job_extend数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooJobExtend record, @Param("example") CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooJobExtend record, @Param("example") CuckooJobExtendCriteria example);

    /**
     * cuckoo_job_extend数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooJobExtend record);

    /**
     * cuckoo_job_extend数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooJobExtend record);
}