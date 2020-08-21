package com.sucaisheng.demo.mapper;


import com.sucaisheng.demo.enty.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FriendMapper {
	/**
	 * 好友列表
	 * @return
	 */
	List<Friend> getFriendList(@Param("user_id")String user_id);
}
