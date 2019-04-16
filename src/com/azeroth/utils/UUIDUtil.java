package com.azeroth.utils;

import java.util.UUID;

public class UUIDUtil {
	public  static String getId(){
		String uuid = java.util.UUID.randomUUID().toString()  
                .replaceAll("-", "").toUpperCase();  
        return uuid.substring(0, 6); 
	}
}