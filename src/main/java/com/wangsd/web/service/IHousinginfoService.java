package com.wangsd.web.service;

import com.wangsd.common.base.BaseService;
import com.wangsd.common.base.Page;
import com.wangsd.common.model.Housinginfo;

import java.util.List;

public interface IHousinginfoService extends BaseService {

    public List<Housinginfo> queryHousinginfoList(Page<Housinginfo> page);
}
