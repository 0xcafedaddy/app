package com.uflowertv.wechat.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.wechat.mapper.UserMapper;
import com.uflowertv.wechat.model.User;
import com.uflowertv.wechat.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：
 * 类名称：com.uflowertv.user.service.UserService     
 * 创建人：liguoliang 
 * 创建时间：2016年8月16日 上午9:04:32   
 * 修改人：
 * 修改时间：2016年8月16日 上午9:04:32   
 * 修改备注：   
 * @version   V1.0
 */
@Service
public class UserService extends BaseServiceImpl<UserMapper,User> {

    @Log("通过邮件查找用户")
    public User findByEmail(String email){return selectOne(new EntityWrapper<User>().where("email={0}",email));}

}
