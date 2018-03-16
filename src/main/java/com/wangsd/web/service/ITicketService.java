package com.wangsd.web.service;

import com.wangsd.common.base.IService;
import com.wangsd.web.model.Ticket;

public interface ITicketService extends IService<Ticket> {
    public void saveAll();
}
