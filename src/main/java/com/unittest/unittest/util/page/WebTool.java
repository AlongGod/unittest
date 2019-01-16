package com.unittest.unittest.util.page;

public class WebTool {

	public static PageIndex getPageIndex(long pagecode, int pageNow,
			long pageCount) {
		long startpage = pageNow
				- (pagecode % 2 == 0 ? pagecode / 2 - 1 : pagecode / 2);
		long endpage = pageNow + pagecode / 2;
		if (startpage < 1) {
			startpage = 1;
			if (pageCount >= pagecode)
				endpage = pagecode;
			else
				endpage = pageCount;
		}
		if (endpage > pageCount) {
			endpage = pageCount;
			if ((endpage - pagecode) > 0)
				startpage = endpage - pagecode + 1;
			else
				startpage = 1;
		}
		return new PageIndex(startpage, endpage);
	}

	public static PageIndex getClientPageIndex(long pageNow, long pageCount,
			long pageSize, long rowCount) {
		long startindex = (pageNow - 1) * pageSize + 1;
		long endindex = pageNow == pageCount ? rowCount : (pageNow) * pageSize;
		return new PageIndex(startindex, endindex);
	}
}
