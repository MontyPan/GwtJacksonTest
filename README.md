Client Side
===========

gwt-jackson 把日期轉 json 的時候會轉成 getTime() 的整數而不是常見日期格式... ＝＝"


Server Side
===========

據說 GSON 吐的日期會依平台不同而改變，在 M$ 上也無法直接 parse 成功，
得強制指定 format pattern：

```Java
Gson gson = new GsonBuilder().setDateFormat(datePattern).create();
```

* yyyy-MM-dd HH:mm:ss：失敗
* ISO-8601 系（[ref](https://stackoverflow.com/questions/10286204/the-right-json-date-format)）
	* yyyy-MM-dd'T'HH:mm:ss.SSSZ（可以多到兩個 Z，但沒啥差別）
	* yyyy-MM-dd'T'HH:mm:ss.SSSX（可以多到三個 X）
	* yyyy-MM-dd'T'HH:mm:ss.SSS：有時區問題
	* yyyy-MM-dd'T'HH:mm:ss.SSS'Z'：有時區問題

綜合來看，選擇 `yyyy-MM-dd'T'HH:mm:ss.SSSX` 是比較好的選擇，因為時區的字數最少 XD。
