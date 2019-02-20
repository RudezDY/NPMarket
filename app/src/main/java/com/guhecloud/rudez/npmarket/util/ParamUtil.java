/**
 * 
 */
package com.guhecloud.rudez.npmarket.util;

import android.text.TextUtils;

import java.lang.reflect.Field;


/**
 * @author Chanin
 *
 */
public class ParamUtil {

	public static boolean isEmpty(String... args) {
		for (String str : args) {
			if (TextUtils.isEmpty(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param object
	 *            使用了NotEmpty 的bean
	 * @throws Exception
	 */

	public static void volidateBean(Object object) throws Exception {

		Class<? extends Object> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (null != field.getAnnotation(NotEmpty.class) && field.getType() == String.class) {
				field.setAccessible(true);
				if (null == field.get(object) || isEmpty((String) field.get(object))) {
					NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
					throw new Exception(notEmpty.message());
				}
			}
		}

	}

}
