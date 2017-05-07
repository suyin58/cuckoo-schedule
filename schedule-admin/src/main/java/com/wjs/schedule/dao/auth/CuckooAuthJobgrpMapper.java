package com.wjs.schedule.dao.auth;

import com.wjs.schedule.domain.auth.CuckooAuthJobgrp;
import com.wjs.schedule.domain.auth.CuckooAuthJobgrpCriteria;
import com.wjs.util.dao.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuckooAuthJobgrpMapper {
    /**
     * cuckoo_auth_jobgrp数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: insert  
     * 
     */
    int insert(CuckooAuthJobgrp record);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CuckooAuthJobgrp record);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: selectByExample  
     * 
     */
    List<CuckooAuthJobgrp> selectByExample(CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CuckooAuthJobgrp selectByPrimaryKey(Long id);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CuckooAuthJobgrp lockByPrimaryKey(Long id);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: lockByExample  
     * 
     */
    CuckooAuthJobgrp lockByExample(CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CuckooAuthJobgrp> pageByExample(CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CuckooAuthJobgrp record, @Param("example") CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CuckooAuthJobgrp record, @Param("example") CuckooAuthJobgrpCriteria example);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CuckooAuthJobgrp record);

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CuckooAuthJobgrp record);
}