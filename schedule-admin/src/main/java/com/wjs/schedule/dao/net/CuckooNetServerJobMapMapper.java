package com.wjs.schedule.dao.net;

import com.wjs.schedule.domain.net.CuckooNetServerJobMap;
import com.wjs.schedule.domain.net.CuckooNetServerJobMapCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooNetServerJobMapMapper {
    /**
     * cuckoo_net_server_job_map数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: insert  
     * 
     */
    int insert(CuckooNetServerJobMap record);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooNetServerJobMap record);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooNetServerJobMap> selectByExample(CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooNetServerJobMap selectByPrimaryKey(Long id);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooNetServerJobMap lockByPrimaryKey(Long id);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: lockByExample  
     * 
     */
    CuckooNetServerJobMap lockByExample(CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooNetServerJobMap> pageByExample(CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_net_server_job_map数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooNetServerJobMap record, @Param("example") CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooNetServerJobMap record, @Param("example") CuckooNetServerJobMapCriteria example);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooNetServerJobMap record);

    /**
     * cuckoo_net_server_job_map数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooNetServerJobMap record);
}