package com.cyx.spring._04_bean_instantiation;

import org.springframework.beans.factory.FactoryBean;

public class CBean4Factory implements FactoryBean<CBean4> {

    @Override
    public CBean4 getObject() {
        CBean4 cBean4 = new CBean4();
        // TODO:做操作
        return cBean4;
    }

    @Override
    public Class<?> getObjectType() {
        return CBean4.class;
    }

}
