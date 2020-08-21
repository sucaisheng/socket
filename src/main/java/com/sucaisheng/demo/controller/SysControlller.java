package com.sucaisheng.demo.controller;


import com.sucaisheng.demo.enty.Friend;
import com.sucaisheng.demo.enty.Message;
import com.sucaisheng.demo.enty.ResultBase;
import com.sucaisheng.demo.enty.User;
import com.sucaisheng.demo.service.FriendService;
import com.sucaisheng.demo.service.MessageService;
import com.sucaisheng.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/sys")
public class SysControlller {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private FriendService friendService;
	
	/**
	 * 登录
	 * @param user_id
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultBase getUser(String user_id, String	pwd)throws Exception{
		User user=null;
		user=userService.getUser(user_id,pwd);
		if(user==null) {
			return new ResultBase("0","失败");
		}
		return new ResultBase(user);
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResultBase register(User user)throws Exception{
		ResultBase bean=null;
		bean=userService.insertUser(user);
		if(bean==null) {
			return new ResultBase("0","失败");
		}
		return bean;
	}
	
	/**
	 * 指定好友的消息列表
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/messageList", method = RequestMethod.POST)
	public ResultBase messageList(String user_id,String friend_id)throws Exception{
		List<Message> messageList=null;
		messageList=messageService.getMessageList(user_id, friend_id);
		if(messageList!=null&&messageList.size()>0) {
			return new ResultBase(messageList);
		}else {
			return new ResultBase();
		}
	}
	/**
	 * 获取好友列表
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getFriendList", method = RequestMethod.POST)
	public ResultBase getFriendList(String user_id)throws Exception{
		List<Friend> friendList=null;
		friendList=messageService.getFriendList(user_id);
		if(friendList!=null&&friendList.size()>0) {
			return new ResultBase(friendList);
		}else {
			return new ResultBase();
		}
	}
	/**
	 * 保存消息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
	public ResultBase saveMessage(Message message)throws Exception{
		ResultBase bean=null;
		bean=messageService.saveMessage(message);
		if(bean!=null) {
			return new ResultBase();
		}else {
			return new ResultBase();
		}
	}
}