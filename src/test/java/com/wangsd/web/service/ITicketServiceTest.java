package com.wangsd.web.service;

import com.wangsd.web.model.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ITicketServiceTest {

    @Autowired
    ITicketService ticketService;
    @Autowired
    IWeixinconfigService weixinconfigService;

    @Test
    public void test() throws Exception {

        //ticketService.saveAll();
//        Ticket ticket = ticketService.selectByKey(1);
//        Ticket ticket2 = ticketService.selectOne(ticket);
        weixinconfigService.selectAll();
    }

}