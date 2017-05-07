package com.wjs.schedule.dao.exec;

import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobDetailCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooJobDetailMapper {
    /**
     * cuckoo_job_detail数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_job_detail数据表的操作方法: insert  
     * 
     */
    int insert(CuckooJobDetail record);

    /**
     * cuckoo_job_detail数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooJobDetail record);

    /**
     * cuckoo_job_detail数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooJobDetail> selectByExample(CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooJobDetail selectByPrimaryKey(Long id);

    /**
     * cuckoo_job_detail数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooJobDetail lockByPrimaryKey(Long id);

    /**
     * cuckoo_job_detail数据表的操作方法: lockByExample  
     * 
     */
    CuckooJobDetail lockByExample(CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooJobDetail> pageByExample(CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_job_detail数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooJobDetail record, @Param("example") CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooJobDetail record, @Param("example") CuckooJobDetailCriteria example);

    /**
     * cuckoo_job_detail数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooJobDetail record);

    /**
     * cuckoo_job_detail数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooJobDetail record);
}