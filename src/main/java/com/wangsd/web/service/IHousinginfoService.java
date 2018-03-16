package com.wangsd.web.service;

import com.wangsd.common.base.IService;
import com.wangsd.common.base.Page;
import com.wangsd.web.model.Housinginfo;

import java.util.List;

public interface IHousinginfoService extends IService<Housinginfo> {

    public List<Housinginfo> queryHousinginfoList(Page<Housinginfo> page);
}
