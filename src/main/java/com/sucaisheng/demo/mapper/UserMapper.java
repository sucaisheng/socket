package com.sucaisheng.demo.mapper;


import com.sucaisheng.demo.enty.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	/**
	 * 获得用户信息
	 * 
	 * @return
	 */
	User getUser(@Param("user_id")String user_id);

	/**
	 * 录入新用户
	 * 
	 * @param entity
	 */
	void insertUser(User user);
}
