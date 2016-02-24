package com.zcf.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JSONDateFormat implements JsonValueProcessor {
	private String datePattern = "yyyy-MM-dd HH:mm:ss";
	
	public String getDatePattern() {
		return datePattern;
	}
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	public JSONDateFormat() {
		super();
	}
	public JSONDateFormat(String datePattern) {
		super();
		this.datePattern = datePattern;
	}
	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		// TODO Auto-generated method stub
		return process(value);
	}
	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		// TODO Auto-generated method stub
		return process(value);
	}
	private Object process(Object value) {
		try {
		if (value instanceof Date) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern,
		Locale.CHINA);
		return sdf.format((Date) value);
		}
		return value == null ? "" : value.toString();
		} catch (Exception e) {
		return "";
		}
		}
	
}
