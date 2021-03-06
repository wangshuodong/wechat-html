package com.wangsd.web.dao;


import com.wangsd.common.base.MyMapper;
import com.wangsd.web.model.Housinginfo;

import java.util.List;
import java.util.Map;

public interface HousinginfoMapper extends MyMapper<Housinginfo> {

    List<Housinginfo> queryHousinginfoList(Map<String, Object> map);
}