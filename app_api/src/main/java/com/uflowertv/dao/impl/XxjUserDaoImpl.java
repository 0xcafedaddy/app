package com.uflowertv.dao.impl;

import org.springframework.stereotype.Repository;

import com.uflowertv.dao.XxjUserDaoI;
import com.uflowertv.model.po.XxjUser;

@Repository("xxjUserDao")
public class XxjUserDaoImpl extends XxjBaseDaoImpl<XxjUser> implements XxjUserDaoI{
}
