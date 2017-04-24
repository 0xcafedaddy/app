package com.uflowertv.test;

import com.uflowertv.dao.StartMapper;
import com.uflowertv.datasources.DBTypeEnum;
import com.uflowertv.datasources.DynamicDataSourceHolder;
import com.uflowertv.model.dto.DayActiveCount;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class DataSourcesTest {
    @Autowired
    private StartMapper startMapper;
    @Test
    public void  test(){
       DynamicDataSourceHolder.setRouteKey(DBTypeEnum.dataSource_tj.getValue());
        DateTime start = new DateTime();
        DateTime end = start.plusMonths(1);
        List<DayActiveCount> timeUserActiveList = startMapper.getTimeUserActiveList(1, 10, start.toDate(), end.toDate());

        System.out.println(timeUserActiveList.size());
    }
}
