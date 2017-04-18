package com.uflowertv.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.dao.UserMapper;
import com.uflowertv.model.User;
import com.uflowertv.service.support.BaseServiceImpl;
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
public class UserService extends BaseServiceImpl<UserMapper,User>{

	@Log("用户登录")
	public User findLogin(User user ){
		return super.selectOne(new EntityWrapper<User>(user));
	}

	@Log("通过邮件查找用户")
	public User findByEmail(String email){return baseMapper.findByEmail(email);}

	/*public int saveReg(User user) {
		log.info("用户注册");
		return userMapper.insert(user);
	}

	public User findById(String id) {
		log.info("通过ID查找用户");
		return userMapper.selectByPrimaryKey(id);
	}

	public User findByEmail(String email) {
		log.info("通过邮件查找用户");
		return userMapper.findByEmail(email);
	}

	public int update(User user) {
		log.info("更新用户");
		return userMapper.updateByPrimaryKeySelective(user);
		
	}*/
}
