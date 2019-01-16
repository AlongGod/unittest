package com.xushuzn.common.page;

public class PageIndex {

	private long startIndex;
	private long endIndex;

	public PageIndex(long startindex, long endindex) {
		this.startIndex = startindex;
		this.endIndex = endindex;
	}

	public long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}

}
