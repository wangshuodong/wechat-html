package com.wangsd.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ITicketServiceTest {

    private static Logger log = LoggerFactory.getLogger(ITicketServiceTest.class);

    @Autowired
    ITicketService ticketService;
    @Autowired
    IWeixinconfigService weixinconfigService;

    @Test
    public void test() throws Exception {
        log.debug("aaaaaaaaaa");

        //ticketService.saveAll();
//        Ticket ticket = ticketService.selectByKey(1);
//        Ticket ticket2 = ticketService.selectOne(ticket);
        weixinconfigService.selectAll();
    }

}