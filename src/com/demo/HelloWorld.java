/**
 * @created time:2017年7月25日,下午1:52:06
 * @author:chixh
 * @file:HelloWorld.java
 */
package com.demo;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 服务点接口，三个方法对应HelloWorldImpl
 * @author chixh
 *
 */
@WebService
public interface HelloWorld {
	String sayHi(@WebParam(name="text")String text);
	String sayHiToUser(User user);
	String[] SayHiToUserList(List<User> userList);
}
