package com.railway.labor.score.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author zhuanglinxiang
 * 
 */
public class DateUtil {
	protected static final Logger logger = LoggerFactory
			.getLogger(DateUtil.class);

	public static long compare(Date date1, Date date2) {
		return date1.getTime() - date2.getTime();
	}

	public static Date StringToDate(String dateStrig, String parsePattern) {
		try {
			return DateUtils.parseDate(dateStrig, parsePattern);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static String DateToString(Date date, String parsePattern) {
		try {
			return DateFormatUtils.format(date, parsePattern);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
