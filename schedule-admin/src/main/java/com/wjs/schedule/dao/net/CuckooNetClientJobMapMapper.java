package com.wjs.schedule.dao.net;

import com.wjs.schedule.domain.net.CuckooNetClientJobMap;
import com.wjs.schedule.domain.net.CuckooNetClientJobMapCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooNetClientJobMapMapper {
    /**
     * cuckoo_net_client_job_map数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: insert  
     * 
     */
    int insert(CuckooNetClientJobMap record);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooNetClientJobMap record);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooNetClientJobMap> selectByExample(CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooNetClientJobMap selectByPrimaryKey(Long id);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooNetClientJobMap lockByPrimaryKey(Long id);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: lockByExample  
     * 
     */
    CuckooNetClientJobMap lockByExample(CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooNetClientJobMap> pageByExample(CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_net_client_job_map数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooNetClientJobMap record, @Param("example") CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooNetClientJobMap record, @Param("example") CuckooNetClientJobMapCriteria example);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooNetClientJobMap record);

    /**
     * cuckoo_net_client_job_map数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooNetClientJobMap record);
}