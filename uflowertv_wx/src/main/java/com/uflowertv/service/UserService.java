package com.uflowertv.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.dao.UserMapper;
import com.uflowertv.model.ValidationData;
import com.uflowertv.model.po.User;
import com.uflowertv.service.support.BaseServiceImpl;
import com.uflowertv.util.CipherUtil;
import com.uflowertv.util.GUIDUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Log("注册")
    public Map<String,Object> register(User user,String passwd){
        Map<String,Object> map = new HashMap<String,Object>();
        ValidationData data = new ValidationData();
        User u = findByEmail(user.getEmail());
        if(u != null){
            data.setEmialMsg("该邮箱已被注册");
            map.put("data", data);
            return map;
        }
        //将密码加密保存
        user.setId(GUIDUtil.get());
        user.setPwd(CipherUtil.generator(passwd));
        user.setCreated(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        user.setLogintime(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        boolean insert = insert(user);
        if(insert){
            map.put("code", 200);
            map.put("message", "注册成功");
            return map;
        }
       throw new RuntimeException("未知错误");
    }
}
