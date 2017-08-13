package com.uflowertv.dao.impl;

import org.springframework.stereotype.Repository;

import com.uflowertv.dao.XxjXuedDaoI;
import com.uflowertv.model.po.XxjXued;

import java.util.List;

@Repository("xxjXuedDao")
public class XxjXuedDaoImpl extends XxjBaseDaoImpl<XxjXued> implements XxjXuedDaoI{

    public List<XxjXued> list(){
        /*String hql = "from XxjXued";
        return this.getCurrentSession()
                .createQuery(hql)
                .setCacheable(true)
                .setCacheRegion("cacheRegion")
                .list();*/
        return null;
    }
}
