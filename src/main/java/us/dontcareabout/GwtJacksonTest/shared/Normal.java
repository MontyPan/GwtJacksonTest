package us.dontcareabout.GwtJacksonTest.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Normal {
	public static final Normal sample = new Normal();
	static {
		sample.intPublic = 5487;
		sample.setDate(new Date(1643384631785L));
		sample.setDoubleD(5566.7788);
		sample.setLongV(2147483649L);
		sample.setString("Normal String");
		sample.setList(new ArrayList<>(Arrays.asList("1", "2", "3")));
	}

	public int intPublic;

	private String string;
	private Double doubleD;
	private long longV;
	private Date date;
	private ArrayList<String> list;

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
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, doubleD, intPublic, list, longV, string);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Normal)) {
			return false;
		}
		Normal other = (Normal)obj;
		return Objects.equals(date, other.date) && Objects.equals(doubleD, other.doubleD) && intPublic == other.intPublic && Objects.equals(list, other.list)
			&& longV == other.longV && Objects.equals(string, other.string);
	}
}
