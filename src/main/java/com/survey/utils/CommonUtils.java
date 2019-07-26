/**
 * 常用工具类
 */
package com.survey.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {

	/**
	 * 返回一个随机的32长的大写字符串
	 * @return string:32位长的大写随机字符串
	 */
	public static String uuid()
	{
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	/**
	 * 基于阿帕奇的BeanUtils
	 * 得到一个T类型的Bean
	 * 常用与将request.getParameterMap()
	 * 方法得到的表单数据封装到bean中
	 * @param map : name-value 键值对，符合bean规范
	 * @param clazz : T 的 class实例
	 * @return  T  : 含有map数据的bean实例
	 */
	public static <T> T toBean(Map map, Class<T> clazz)
	{
		T bean = null;
		try {
			bean = clazz.newInstance();
			BeanUtils.populate(bean, map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return bean;
	}

}
