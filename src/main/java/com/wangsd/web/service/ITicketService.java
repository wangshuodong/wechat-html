package com.wangsd.web.service;

import com.wangsd.common.base.BaseService;
import com.wangsd.web.model.Ticket;

public interface ITicketService extends BaseService<Ticket> {
    public void saveAll();
}
