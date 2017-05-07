package com.wjs.schedule.dao.net;

import com.wjs.schedule.domain.net.CuckooNetClientInfo;
import com.wjs.schedule.domain.net.CuckooNetClientInfoCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooNetClientInfoMapper {
    /**
     * cuckoo_net_client_info数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_net_client_info数据表的操作方法: insert  
     * 
     */
    int insert(CuckooNetClientInfo record);

    /**
     * cuckoo_net_client_info数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooNetClientInfo record);

    /**
     * cuckoo_net_client_info数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooNetClientInfo> selectByExample(CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooNetClientInfo selectByPrimaryKey(Long id);

    /**
     * cuckoo_net_client_info数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooNetClientInfo lockByPrimaryKey(Long id);

    /**
     * cuckoo_net_client_info数据表的操作方法: lockByExample  
     * 
     */
    CuckooNetClientInfo lockByExample(CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooNetClientInfo> pageByExample(CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_net_client_info数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooNetClientInfo record, @Param("example") CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooNetClientInfo record, @Param("example") CuckooNetClientInfoCriteria example);

    /**
     * cuckoo_net_client_info数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooNetClientInfo record);

    /**
     * cuckoo_net_client_info数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooNetClientInfo record);
}