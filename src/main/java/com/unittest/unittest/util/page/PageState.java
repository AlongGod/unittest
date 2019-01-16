package com.unittest.unittest.util.page;

import org.apache.commons.lang3.StringUtils;

/**
 * @author https://www.ixushu.com
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