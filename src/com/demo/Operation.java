/**
 * @created time:2017年7月31日,上午10:44:00
 * @author:chixh
 * @file:FileUpload.java
 */
package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;
import org.json.JSONArray;

public class Operation {
	/**
	 * 保存文件
	 * 
	 * @param file
	 * @param dataHandler
	 * @return
	 */
	public static boolean saveFile(File file, DataHandler dataHandler) {
		FileOutputStream fos = null;
		InputStream fis = null;
		try {
			file.createNewFile();
			fis = dataHandler.getInputStream();
			fos = new FileOutputStream(file);
			byte[] bytes = new byte[8096];
			int len = 0;
			while ((len = fis.read(bytes)) > 0) {
				fos.write(bytes, 0, len);
			}
			return true;
		} catch (FileNotFoundException e) {
			Logger.getRootLogger().error(e.getMessage());
			return false;
		} catch (IOException e) {
			Logger.getRootLogger().error(e.getMessage());
			return false;
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 上传文件到upload_files目录
	 * 
	 * @param fileName
	 * @param dataHandler
	 * @return
	 */
	public static String uploadFile(String fileName, DataHandler dataHandler) {
		String info = "";
		if (fileName != null && dataHandler != null) {
			File dir = new File("./upload_files");
			dir.mkdirs();
			File f = new File("./upload_files/" + fileName);
			// Logger.getRootLogger().info("文件路径:"+f.getAbsolutePath());
			if (saveFile(f, dataHandler)) {
				info = "The file upload successful.The directory is in " + f.getAbsolutePath() + ".";
			} else {
				info = "The file saved failed. Because the directory cannot write or have no limited.";
			}
		} else {
			info = "The file name or file is not exist.";
		}
		Logger.getRootLogger().info(info);
		return info;
	}

	/**
	 * 下载文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static byte[] downloadFile(String fileName) {
		byte[] bytes = null;
		InputStream fis = null;
		if (fileName != null && fileName != "") {
			File dir = new File("./upload_files");
			dir.mkdirs();
			File f = new File("./upload_files/" + fileName);
			if (f.exists()) {
				try {
					fis = new FileInputStream(f);
					bytes = new byte[fis.available()];
					fis.read(bytes);
				} catch (IOException e) {
					Logger.getRootLogger().info(e.getMessage());
				} finally {
					if (fis != null)
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
			Logger.getRootLogger().info("The file:" + f.getAbsolutePath() + " is not existed.");
		}
		Logger.getRootLogger().info("The file name:" + fileName + " is null.");
		return bytes;
	}

	/**
	 * 字段toJson
	 * 
	 * @param field
	 * @return
	 */
	public static String fieldToJson(String field) {
		if (field.equals("json1")) {
			JSONArray jsonArray = new JSONArray();
			jsonArray.put("jsonFromServer");
			jsonArray.put(1, 1127);
			jsonArray.put(2, 2017);
			jsonArray.put(3, 1730);
			jsonArray.put(4, 2000);
			return jsonArray.toString();
		}
		if (field.equals("json2")) {
			JSONArray jsonArray = new JSONArray();
			jsonArray.put("jsonFromServer");
			jsonArray.put(5, 1127);
			jsonArray.put(6, 2017);
			jsonArray.put(7, 1730);
			jsonArray.put(8, 2000);
			return jsonArray.toString();
		} else {
			return null;
		}
	}
}
