/**
 * @created time:2017年7月25日,下午1:59:14
 * @author:chixh
 * @file:HelloWorldImpl.java
 */
package com.demo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
/**
 * 服务实现类
 * @author chixh
 *
 */
@WebService(endpointInterface="com.demo.HelloWorld",serviceName="HelloWorld")
public class HelloWorldImpl implements HelloWorld{
	//map容器
	Map<Integer, User> users = new LinkedHashMap<>();
	
	/**
	 * 调用Hello+text
	 */
	@Override
	public String sayHi(String text) {
		return "Hello "+text;
	}
	/**
	 * 将客户端发来的数据user放入map中，并返回放入的值。
	 */
	@Override
	public String sayHiToUser(User user) {
		users.put(users.size()+1, user);
		return "Hello "+user.getName();
	}
	/**
	 * 返回多个user数据
	 */
	@Override
	public String[] SayHiToUserList(List<User> userList) {
		String [] result =new String[userList.size()];
		int i =0;
		for (User u : userList) {
			result[i] ="Hello "+u.getName();
			i++;
		}
		return result;
	}
	
}
