package com.jvzeller.templateapp.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.facade.IFacade;

@Component
public abstract class AbstractCommand < T extends DomainEntity > implements ICommand < T > {

    @Autowired
    protected IFacade < T > applicationFacade;
}
