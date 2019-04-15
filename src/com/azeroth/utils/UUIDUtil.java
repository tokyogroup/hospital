package com.azeroth.util;

import java.util.UUID;

public class UUIDUtil {
	public String getId(){
		String uuid = java.util.UUID.randomUUID().toString()  
                .replaceAll("-", "").toUpperCase();  
        return uuid.substring(0, 6); 
	}
}
