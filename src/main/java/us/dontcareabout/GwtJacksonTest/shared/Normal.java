package us.dontcareabout.GwtJacksonTest.shared;

import java.util.Date;

public class Normal {
	public int intPublic;

	private String string;
	private Double doubleD;
	private long longV;
	private Date date;

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Double getDoubleD() {
		return doubleD;
	}
	public void setDoubleD(Double doubleD) {
		this.doubleD = doubleD;
	}
	public long getLongV() {
		return longV;
	}
	public void setLongV(long longV) {
		this.longV = longV;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
