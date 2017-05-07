package com.wjs.schedule.dao.net;

import com.wjs.schedule.domain.net.CuckooNetServerInfo;
import com.wjs.schedule.domain.net.CuckooNetServerInfoCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooNetServerInfoMapper {
    /**
     * cuckoo_net_server_info数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_net_server_info数据表的操作方法: insert  
     * 
     */
    int insert(CuckooNetServerInfo record);

    /**
     * cuckoo_net_server_info数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooNetServerInfo record);

    /**
     * cuckoo_net_server_info数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooNetServerInfo> selectByExample(CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooNetServerInfo selectByPrimaryKey(Long id);

    /**
     * cuckoo_net_server_info数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooNetServerInfo lockByPrimaryKey(Long id);

    /**
     * cuckoo_net_server_info数据表的操作方法: lockByExample  
     * 
     */
    CuckooNetServerInfo lockByExample(CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooNetServerInfo> pageByExample(CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_net_server_info数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooNetServerInfo record, @Param("example") CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooNetServerInfo record, @Param("example") CuckooNetServerInfoCriteria example);

    /**
     * cuckoo_net_server_info数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooNetServerInfo record);

    /**
     * cuckoo_net_server_info数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooNetServerInfo record);
}