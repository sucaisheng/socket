package com.sucaisheng.demo.mapper;


import com.sucaisheng.demo.enty.Friend;
import com.sucaisheng.demo.enty.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MessageMapper {
	
	/**
	 * 获取消息好友列表
	 * @return
	 */
	List<Friend> getFriendList(@Param("user_id")String user_id);
	/**
	 * 获取消息(单个好友)
	 * @return
	 */
	List<Message> geMessageList(@Param("user_id")String user_id, @Param("friend_id")String friend_id);
	
	/**
	 * 存储消息
	 * @return
	 */
	void saveMessage(Message message);
}
