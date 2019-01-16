package com.unittest.unittest.util;

import java.util.UUID;

/*
 Java UUID Generator (JUG)：开源UUID生成器，LGPL协议，支持MAC地址。
 UUID：特殊的License，有源码。
 Java 5以上版本中自带的UUID生成器：好像只能生成Version 3/4的UUID。*/
public class UUIDUtils {
	public static String generateUUID(){
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		uuidStr = uuidStr.replaceAll("-", "");
		return uuidStr;
	}
	
	public static String generateCurrentTimestamp(){
		return String.valueOf(System.currentTimeMillis());
	}
	
	public static String generateCurrentTimestampUUID(){
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		uuidStr = uuidStr.replaceAll("-", "");
		return String.valueOf(System.currentTimeMillis()) + uuidStr.substring(0,19);
	}

}
