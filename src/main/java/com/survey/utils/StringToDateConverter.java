package com.survey.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
//类型转换器
public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (source==null) {
			throw new RuntimeException("输入数据");
		}
		DateFormat df= new SimpleDateFormat("yy-MM-dd");
		try {
			return df.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException("数据转换出错");
		}
	}

}
