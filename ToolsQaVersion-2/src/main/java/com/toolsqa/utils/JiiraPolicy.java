package com.toolsqa.utils;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JiiraPolicy {
	boolean logTicketReady();
	

}
