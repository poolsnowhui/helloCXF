/**
 * @created time:2017年7月25日,下午2:03:19
 * @author:chixh
 * @file:webServiceApp.java
 */
package com.demo;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

/**
 * 暴露web服务,采用spring时，不需要此服务
 * @author chixh
 *
 */
public class webServiceApp {
	public static void main(String[] args) {
//		System.out.println("web service start");
		HelloWorld implementor = new HelloWorldImpl();
//		String address="http://localhost:8080/helloCXF";
//		Endpoint.publish(address, implementor);
//		System.out.println("web service started");
		System.out.println(new String(implementor.fieldToJson("json1")));
		DataHandler dataHandler = new DataHandler(new FileDataSource("./input.txt"));
		System.out.println(implementor.uploadFile("已上传.txt", dataHandler));
	}
	public void test(){
		System.out.println("test");
	}
}
	