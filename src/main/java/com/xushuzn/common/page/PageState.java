package com.xushuzn.common.page;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuzd
 * @version 1.0 2011-05-12
 * @since JDK1.5
 * */
public enum PageState {

	/**
	 * */
	SETPAGE,
	/**
	 * */
	FIRST,
	/**
	 * */
	PREVIOUS,
	/**
	 * */
	NEXT,
	/**
	 * */
	LAST,
	/**
	 * */
	SORT,
	/**
	 * */
	GOPAGE;

	/**
	 */
	public static int getOrdinal(String value) {
		int index = -1;
		if (StringUtils.isEmpty(value)) {
			return index;
		}
		String newValue = StringUtils.trim(value).toUpperCase();
		try {
			index = valueOf(newValue).ordinal();
		} catch (IllegalArgumentException e) {
		}
		return index;
	}
}