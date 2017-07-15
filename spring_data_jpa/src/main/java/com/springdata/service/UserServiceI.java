package com.springdata.service;

import com.springdata.entity.Tb_user;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface UserServiceI {

    Tb_user getById(long id);
}
