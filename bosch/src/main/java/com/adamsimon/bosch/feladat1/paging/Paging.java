package com.adamsimon.bosch.feladat1.paging;

import java.util.ArrayList;
import java.util.List;

import com.adamsimon.bosch.feladat1.enums.PageItemTypeEnum;

public class Paging {
	
    private boolean nextEnabled;
    private boolean prevEnabled;
    private int pageSize;
    private int pageNumber;
    private List<PageItem> items = new ArrayList<>();
    
    private static final int PAGINATION_STEP = 3;
    
    public Paging() {}

	public Paging(boolean nextEnabled, boolean prevEnabled, int pageSize, int pageNumber) {
		super();
		this.nextEnabled = nextEnabled;
		this.prevEnabled = prevEnabled;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public Paging(boolean nextEnabled, boolean prevEnabled, int pageSize, int pageNumber, List<PageItem> items) {
		super();
		this.nextEnabled = nextEnabled;
		this.prevEnabled = prevEnabled;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.items = items;
	}
	
	public boolean isNextEnabled() {
		return nextEnabled;
	}

	public void setNextEnabled(boolean nextEnabled) {
		this.nextEnabled = nextEnabled;
	}

	public boolean isPrevEnabled() {
		return prevEnabled;
	}

	public void setPrevEnabled(boolean prevEnabled) {
		this.prevEnabled = prevEnabled;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<PageItem> getItems() {
		return items;
	}

	public void setItems(List<PageItem> items) {
		this.items = items;
	}
    
    public void addPageItems(int from, int to, int pageNumber) {
        for (int i = from; i < to; i++) {
        	PageItem item = new PageItem(PageItemTypeEnum.PAGE, i, pageNumber != i);
            items.add(item);
        }
    }

    public void last(int pageSize) {
    	PageItem itemF = new PageItem(PageItemTypeEnum.DOTS, false);
        items.add(itemF);

        PageItem itemS = new PageItem(PageItemTypeEnum.PAGE, pageSize, true);
        items.add(itemS);
    }

    public void first(int pageNumber) {
    	PageItem itemF = new PageItem(PageItemTypeEnum.PAGE, 1, pageNumber != 1);
        items.add(itemF);

        PageItem itemS = new PageItem(PageItemTypeEnum.DOTS, false);
        items.add(itemS);
    }

    public static Paging of(int totalPages, int pageNumber, int pageSize) {
        Paging paging = new Paging();
        paging.setPageSize(pageSize);
        paging.setNextEnabled(pageNumber < totalPages);
        paging.setPrevEnabled(pageNumber > 1);
        paging.setPageNumber(pageNumber);

        if (totalPages < PAGINATION_STEP * 2 + 6) {
            paging.addPageItems(1, totalPages + 1, pageNumber);

        } else if (pageNumber < PAGINATION_STEP * 2 + 1) {
            paging.addPageItems(1, PAGINATION_STEP * 2 + 4, pageNumber);
            paging.last(totalPages);

        } else if (pageNumber > totalPages - PAGINATION_STEP * 2) {
            paging.first(pageNumber);
            paging.addPageItems(totalPages - PAGINATION_STEP * 2 - 2, totalPages + 1, pageNumber);

        } else {
            paging.first(pageNumber);
            paging.addPageItems(pageNumber - PAGINATION_STEP, pageNumber + PAGINATION_STEP + 1, pageNumber);
            paging.last(totalPages);
        }

        return paging;
    }
    
}
