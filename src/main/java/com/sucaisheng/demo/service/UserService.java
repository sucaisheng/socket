package com.sucaisheng.demo.service;


import com.sucaisheng.demo.enty.ResultBase;
import com.sucaisheng.demo.enty.User;
import com.sucaisheng.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	/**
	 * 注入服务
	 */
	@Autowired
	private UserMapper userMapper;

	/**
	 * 获取用户信息
	 * @return
	 */
	public User getUser(String user_id, String pwd) {
		User bean = null;
		bean = userMapper.getUser(user_id);
		if (bean != null) {
			if(bean.getPwd()!=null&&bean.getPwd().equals(pwd)) {
				return bean;
			}
			return null;
		}
		return null;
	}

	/**
	 * 存入用户
	 * @return
	 */
	public ResultBase insertUser(User user) {
		User bean = null;
		bean = userMapper.getUser(user.getUserId());
		if(bean!=null) {
			return new ResultBase("0","账号已存在");
		}
		try {
			userMapper.insertUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResultBase("0","注册失败");
		}
		return new ResultBase();
	}

}
