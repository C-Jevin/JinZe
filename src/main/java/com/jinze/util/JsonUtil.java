package com.jinze.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	//将对象转换成json字符串
	public static String toJson(Object bean){
		//Object -->  JSONObject
		JSONObject jo = JSONObject.fromObject(bean);
		//JSONObject --> String
		return jo.toString();
	}
	//将json字符串转换成对象
	public static Object toObject(String json,Class beanClass){
		//json字符串-->jsonObject
		JSONObject jo = JSONObject.fromObject(json);
		//jsonObject-->Object
		return JSONObject.toBean(jo, beanClass);
	}
	
	//集合转换成json字符串
	public static String toJson(List list){
		JSONArray ja = JSONArray.fromObject(list);
		return ja.toString();
	}
	//json字符串转换成集合
	public static Object toArray(String json,Class beanClass){
		JSONArray ja = JSONArray.fromObject(json);
		return JSONArray.toArray(ja,beanClass);
	}
	
	
	
	
	public static void main(String[] args) {
//		User user = new User();
//		user.setName("abd");
//		user.setAddress("fdsafsad");
//		System.out.println(JsonUtil.toJson(user));
//		{"id":0,"phone":"","address":"fdsafsad","name":"abd","password":""}
		
//		String jsonstr = "{\"id\":0,\"phone\":\"\",\"address\":\"fdsafsad\",\"name\":\"abd\",\"password\":\"\"}";
//		User user = (User) JsonUtil.toObject(jsonstr, User.class);
//		System.out.println(user.getAddress());
	}
	
	
}
