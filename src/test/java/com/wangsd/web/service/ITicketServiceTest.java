package com.wangsd.web.service;

import com.wangsd.web.model.Billaccount;
import com.wangsd.web.model.Weixinconfig;
import com.wangsd.web.model.Weixinuser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ITicketServiceTest {

    private static Logger log = LoggerFactory.getLogger(ITicketServiceTest.class);

    @Autowired
    ITicketService ticketService;
    @Autowired
    IWeixinconfigService weixinconfigService;
    @Autowired
    IBillaccountService billaccountService;

    @Test
    public void test() throws Exception {
        log.debug("aaaaaaaaaa");

        //ticketService.saveAll();
//        Ticket ticket = ticketService.selectByKey(1);
//        Ticket ticket2 = ticketService.selectOne(ticket);
//        weixinconfigService.selectAll();

//        Example example = new Example(Weixinconfig.class);
//        example.selectProperties("appId");
//        example.setDistinct(true);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("appSecret", "adeb7e6a2142933188dc905e098af149");
//        weixinconfigService.selectByExample(example);
        List<Integer> list = new ArrayList<>();
        list.add(1151);
        list.add(1152);
        Example example = new Example(Billaccount.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("create_time", "2018-03-20%").andIn("id", list);
        billaccountService.selectByExample(example);
    }

}