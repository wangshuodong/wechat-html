package com.wangsd.web.service.impl;

import com.wangsd.common.base.BaseServiceImpl;
import com.wangsd.web.model.Ticket;
import com.wangsd.web.service.ITicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket> implements ITicketService {


    @Transactional
    public void saveAll() {
        Ticket ticket = new Ticket();
        ticket.setEmail("aaa");
        this.mapper.insert(ticket);

        Ticket ticket2 = new Ticket();
        ticket2.setId(1);
        ticket2.setEmail("abbb");
        this.mapper.insert(ticket);
    }
}
