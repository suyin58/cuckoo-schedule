package com.wjs.schedule.dao.net;

import com.wjs.schedule.domain.net.CuckooNetRegistJob;
import com.wjs.schedule.domain.net.CuckooNetRegistJobCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooNetRegistJobMapper {
    /**
     * cuckoo_net_regist_job数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_net_regist_job数据表的操作方法: insert  
     * 
     */
    int insert(CuckooNetRegistJob record);

    /**
     * cuckoo_net_regist_job数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooNetRegistJob record);

    /**
     * cuckoo_net_regist_job数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooNetRegistJob> selectByExample(CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooNetRegistJob selectByPrimaryKey(Long id);

    /**
     * cuckoo_net_regist_job数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooNetRegistJob lockByPrimaryKey(Long id);

    /**
     * cuckoo_net_regist_job数据表的操作方法: lockByExample  
     * 
     */
    CuckooNetRegistJob lockByExample(CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooNetRegistJob> pageByExample(CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_net_regist_job数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooNetRegistJob record, @Param("example") CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooNetRegistJob record, @Param("example") CuckooNetRegistJobCriteria example);

    /**
     * cuckoo_net_regist_job数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooNetRegistJob record);

    /**
     * cuckoo_net_regist_job数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooNetRegistJob record);
}