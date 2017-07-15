package com.springdata.service.impl;

import com.springdata.entity.Tb_user;
import com.springdata.repository.UserRepository;
import com.springdata.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
public class UserSeriveImpl implements UserServiceI{
    @Autowired
    private UserRepository repository;
    @Override
    public Tb_user getById(long id) {
        return repository.findById(id);
    }
}
