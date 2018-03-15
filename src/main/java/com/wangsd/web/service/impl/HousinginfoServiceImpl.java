package com.wangsd.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangsd.common.base.BaseServiceImpl;
import com.wangsd.common.base.Page;
import com.wangsd.common.dao.HousinginfoMapper;
import com.wangsd.common.model.Housinginfo;
import com.wangsd.web.service.IHousinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousinginfoServiceImpl extends BaseServiceImpl implements IHousinginfoService {

    @Autowired
    private HousinginfoMapper housinginfoMapper;

    @Override
    public List<Housinginfo> queryHousinginfoList(Page<Housinginfo> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        housinginfoMapper.queryHousinginfoList(page.getCondition());
        return null;
    }
}
