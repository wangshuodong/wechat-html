package com.wangsd.common.dao;


import java.util.List;
import java.util.Map;

public interface HousinginfoMapper extends MyBaseMapper<Housinginfo> {

    List<Housinginfo> queryHousinginfoList(Map<String, Object> map);
}