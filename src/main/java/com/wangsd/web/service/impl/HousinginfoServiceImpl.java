package com.wangsd.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangsd.common.base.ServiceImpl;
import com.wangsd.common.base.Page;
import com.wangsd.web.dao.HousinginfoMapper;
import com.wangsd.web.dao.PropertyinfoMapper;
import com.wangsd.web.model.Housinginfo;
import com.wangsd.web.model.Propertyinfo;
import com.wangsd.web.service.IHousinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class HousinginfoServiceImpl extends ServiceImpl<Housinginfo> implements IHousinginfoService {

    @Autowired
    private HousinginfoMapper housinginfoMapper;

    @Autowired
    private PropertyinfoMapper propertyinfoMapper;

    @Override
    public List<Housinginfo> queryHousinginfoList(Page<Housinginfo> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Housinginfo> list = housinginfoMapper.queryHousinginfoList(page.getCondition());
        return list;
    }

    @Override
    public List<Housinginfo> queryHousingByAppId(String appId) {
        List<Housinginfo> list;
        if ("wxcfab4f09fe94c406".equals(appId)) {
            //查询所有小区
            list = housinginfoMapper.selectAll();
        }else {
            //查询对应物业下的所有小区
            Propertyinfo query2 = new Propertyinfo();
            query2.setWeixin_debit_num(appId);
            Propertyinfo propertyinfo = propertyinfoMapper.selectOne(query2);
            Example example = new Example(Housinginfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("parentId", propertyinfo.getId());
            list = housinginfoMapper.selectByExample(example);
        }
        return list;
    }
}
