package us.dontcareabout.GwtJacksonTest.client.util.gf;

import java.util.ArrayList;
import java.util.List;

public class PageParameter {
	private int page = 0;
	private int size = 20;
	private List<Sort> sortList = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public PageParameter setPage(int page) {
		this.page = page;
		return this;
	}

	public int getSize() {
		return size;
	}

	public PageParameter setSize(int size) {
		this.size = size;
		return this;
	}

	public List<Sort> getSortList() {
		return sortList;
	}

	public PageParameter sortByAsc(String name) {
		sortList.add(new Sort(name, true));
		return this;
	}

	public PageParameter sortByDesc(String name) {
		sortList.add(new Sort(name, false));
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("?");
		result.append("page=" + page);
		result.append("&size=" + size);

		for (Sort sort : sortList) {
			result.append(sort);
		}

		return result.toString();
	}

	private class Sort {
		final String name;
		final boolean asc;

		Sort(String name, boolean asc) {
			this.name = name;
			this.asc = asc;
		}

		@Override
		public String toString() {
			return "&sort=" + name + "," + (asc ? "asc" : "desc");
		}
	}
}
