package com.jvzeller.templateapp.navigator;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.util.Result;

public interface INavigationCase < E extends DomainEntity > {

    public static final String DEFAULT_CONTEXT_NAME = "DEFAULT_CONTEXT";

    public String getName();

    public Result < E > getResult();

    public void suspendExecution();

    public void suspendExecution( String message );

    public Boolean isSuspendExecution();

    public void setContext( INavigatorContext context );

    public INavigatorContext getContext();
}