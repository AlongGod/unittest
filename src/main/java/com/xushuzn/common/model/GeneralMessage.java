package com.xushuzn.common.model;

public class GeneralMessage {
	private int code;
	private String msg;
	private String res;
	private StringBuffer str = new StringBuffer();
	public GeneralMessage(){
		
	}
	public GeneralMessage(int code,String msg){
		this.code = code;
		this.msg = msg;
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
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
	public String jsonres(){
		if(msg==null){
			msg="";
		}
		if(res==null){
			res="[]";
		}
		str.append("{");
		str.append("\"code\":"+code);
		str.append(",");
		str.append("\"msg\":\""+msg+"\"");
		str.append(",");
		str.append("\"res\":"+res);
		str.append("}");
		return str.toString();
	}
}
