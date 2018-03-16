package com.wangsd.web.service;

import com.wangsd.common.base.Page;
import com.wangsd.web.model.Housinginfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IHousinginfoServiceTest {

    @Autowired
    IHousinginfoService housinginfoService;

    @Test
    public void queryHousinginfoList() {
        Page<Housinginfo> page = new Page<>();
        page.setPage(1);
        page.setRows(10);
        List<Housinginfo> list = housinginfoService.queryHousinginfoList(page);
        System.out.println(list.size());
    }
}