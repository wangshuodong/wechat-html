package com.wangsd.web.service;

import com.wangsd.common.base.BaseService;
import com.wangsd.common.base.Page;
import com.wangsd.web.model.Housinginfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IHousinginfoService extends BaseService<Housinginfo> {

    public List<Housinginfo> queryHousinginfoList(Page<Housinginfo> page);
}
