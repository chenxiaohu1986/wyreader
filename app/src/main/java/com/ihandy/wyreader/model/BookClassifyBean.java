package com.ihandy.wyreader.model;

import java.io.Serializable;
import java.util.List;


/**
 * Created by cxh on 18/5/23.
 */

public class BookClassifyBean implements Serializable {

	private List<ClassifyBean> press;  //出版社
	private List<ClassifyBean> female;  //女性
	private List<ClassifyBean> male;	//男性


	public List<ClassifyBean> getPress() {
		return press;
	}

	public void setPress(List<ClassifyBean> press) {
		this.press = press;
	}

	public List<ClassifyBean> getFemale() {
		return female;
	}

	public void setFemale(List<ClassifyBean> female) {
		this.female = female;
	}

	public List<ClassifyBean> getMale() {
		return male;
	}

	public void setMale(List<ClassifyBean> male) {
		this.male = male;
	}

	public static class ClassifyBean implements Serializable {
		/**
		 * name : 传记名著
		 * bookCount : 2801
		 * monthlyCount : 0
		 * icon : /icon/传记名著_.png
		 */

		private String name;
		private String bookCount;
		private String monthlyCount;
		private String icon;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBookCount() {
			return bookCount;
		}

		public void setBookCount(String bookCount) {
			this.bookCount = bookCount;
		}

		public String getMonthlyCount() {
			return monthlyCount;
		}

		public void setMonthlyCount(String monthlyCount) {
			this.monthlyCount = monthlyCount;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

	}
}
