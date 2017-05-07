package com.wjs.schedule.dao.auth;

import com.wjs.schedule.qry.job.GroupAuthQry;
import com.wjs.schedule.vo.auth.CuckooGroupAuthVo;
import com.wjs.util.dao.PageDataList;

public interface CuckooAuthJobgrpSubMapper {
    

   /**
    * CuckooAuthJobgrp分页查询
    * 
    */
   PageDataList<CuckooGroupAuthVo> pageByExample(GroupAuthQry qry);

  
}