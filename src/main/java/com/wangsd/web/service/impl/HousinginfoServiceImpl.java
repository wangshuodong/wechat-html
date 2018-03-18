package com.wangsd.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangsd.common.base.ServiceImpl;
import com.wangsd.common.base.Page;
import com.wangsd.web.dao.HousinginfoMapper;
import com.wangsd.web.model.Housinginfo;
import com.wangsd.web.service.IHousinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousinginfoServiceImpl extends ServiceImpl<Housinginfo> implements IHousinginfoService {

    @Autowired
    private HousinginfoMapper housinginfoMapper;

    @Override
    public List<Housinginfo> queryHousinginfoList(Page<Housinginfo> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Housinginfo> list = housinginfoMapper.queryHousinginfoList(page.getCondition());
        return list;
    }
}
