package com.adamsimon.bosch.feladat1.paging;

import com.adamsimon.bosch.feladat1.enums.PageItemTypeEnum;

public class PageItem {

	private PageItemTypeEnum pageItemType;
    private int index;
    private boolean active;

    public PageItem() {}

    public PageItem(PageItemTypeEnum pageItemType, boolean active) {
		super();
		this.pageItemType = pageItemType;
		this.active = active;
	}
    
	public PageItem(PageItemTypeEnum pageItemType, int index, boolean active) {
		super();
		this.pageItemType = pageItemType;
		this.index = index;
		this.active = active;
	}

	public PageItemTypeEnum getPageItemType() {
		return pageItemType;
	}

	public void setPageItemType(PageItemTypeEnum pageItemType) {
		this.pageItemType = pageItemType;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
    
    
}
