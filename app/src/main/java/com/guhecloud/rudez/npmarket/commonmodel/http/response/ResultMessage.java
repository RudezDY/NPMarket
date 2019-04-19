package com.guhecloud.rudez.npmarket.commonmodel.http.response;


import com.google.gson.Gson;

public class ResultMessage<T> {
	
	public static final int SUCCESS = 200;
	public static final int FAIL = 2000;
	public static final int AUTH_FAIL = 3000;

	private int code;//结果代码
	private String msg;//结果描述
	private Long serverTime;//服务器时间
	private int spendTime;//花费时间 

	private T data;//数据




	public ResultMessage() {

	}

	public ResultMessage(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResultMessage(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getServerTime() {
		return serverTime;
	}

	public void setServerTime(Long serverTime) {
		this.serverTime = serverTime;
	}

	public int getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(int spendTime) {
		this.spendTime = spendTime;
	}


	@Override
	public String toString() {
		Gson gson = new Gson();

		return "ResultMessage{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", serverTime=" + serverTime +
				", spendTime=" + spendTime +
				", data=" + gson.toJson(data) +
				'}';
	}
}
