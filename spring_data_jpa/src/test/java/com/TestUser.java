package com;

import com.springdata.entity.Tb_user;
import com.springdata.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class TestUser {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void test(){
        Tb_user user  = new Tb_user();
        user.setAddress("山西朔州");
        user.setUsername("王二小");
        user.setGmt_created(new Date());
        user.setGmt_modified(new Date());
        userRepository.save(user);
    }

    @Test
    public void test1(){
        Tb_user user = userRepository.findById(1L);
        System.out.println(user);
    }
}
