package com.adamsimon.bosch.feladat1.paging;

import java.util.List;

public class Page<T> {
 
	private List<T> content;
    private int totalPages;
    
     public Page() {}

	public Page(List<T> content, int totalPages) {
		super();
		this.content = content;
		this.totalPages = totalPages;
	}


	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
     
     
}
