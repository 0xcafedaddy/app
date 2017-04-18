package com.uflowertv.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.uflowertv.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：
 * 类名称：com.uflowertv.user.dao.UserMapper     
 * 创建人：liguoliang 
 * 创建时间：2016年8月18日 上午9:30:06   
 * 修改人：
 * 修改时间：2016年8月18日 上午9:30:06   
 * 修改备注：   
 * @version   V1.0
 */
public interface UserMapper extends BaseMapper<User> {
    User login(User user);
    User findByEmail(@Param("email") String email);
	/*//登录
	User login(User user);
	//通过邮件查询用户
	User findByEmail(String email);
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/
}