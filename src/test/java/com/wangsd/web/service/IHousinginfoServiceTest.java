package com.wangsd.web.service;

import com.wangsd.common.model.Housinginfo;
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

        List<Housinginfo> list = housinginfoService.queryHousinginfoList(null);
        System.out.println(list.size());
    }
}