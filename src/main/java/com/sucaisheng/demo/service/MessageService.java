package com.sucaisheng.demo.service;

import java.util.List;

import com.sucaisheng.demo.enty.Friend;
import com.sucaisheng.demo.enty.Message;
import com.sucaisheng.demo.enty.ResultBase;
import com.sucaisheng.demo.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	/**
	 * 注入服务
	 */
	@Autowired
	private MessageMapper messageMapper;

	/**
	 * 获取消息视图的好友列表
	 * @return
	 */
	public List<Friend> getFriendList(String user_id) {
		List<Friend> bean = null;
		bean = messageMapper.getFriendList(user_id);
		if (bean != null && bean.size() > 0) {
			return bean;
		}
		return null;
	}

	/**
	 * 获取单个好友的消息列表
	 * @return
	 */
	public List<Message> getMessageList(String user_id, String friend_id) {
		List<Message> bean = null;
		bean = messageMapper.geMessageList(user_id,friend_id);
		if (bean != null && bean.size() > 0) {
			return bean;
		}
		return null;
	}

	/**
	 * 存入消息
	 * @return
	 */
	public ResultBase saveMessage(Message message) {
		messageMapper.saveMessage(message);
		return null;
	}

}
