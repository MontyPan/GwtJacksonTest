package us.dontcareabout.GwtJacksonTest.shared;

import java.util.ArrayList;
import java.util.List;

public class Fail {
	private String string = "string";
	private ArrayList<String> list = new ArrayList<>();

	public String getString() {
		return string;
	}

//	炸 JsonDeserializationException
//	一定要有 public setter
//	public
	void setString(String string) {
		this.string = string;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(List<String> foo) {
		list.clear();
		list.addAll(foo);
	}

//	GWT compile error
//	getter 的 return type 必須是 setter 參數 type（或 child class）
//	public List<String> getList() { return list; }
//	public void setList(ArrayList<String> foo) {
//		list.clear();
//		list.addAll(foo);
//	}
}
