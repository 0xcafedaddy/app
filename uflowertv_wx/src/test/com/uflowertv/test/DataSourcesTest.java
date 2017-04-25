package com.uflowertv.test;

import com.uflowertv.statistics.mapper.StartMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/4/24.
 */
public class DataSourcesTest {
    @Test
    public void  test(){
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        StartMapper startMapper = (StartMapper) cxt.getBean("startMapper");
        System.out.println(startMapper);
    }
}
