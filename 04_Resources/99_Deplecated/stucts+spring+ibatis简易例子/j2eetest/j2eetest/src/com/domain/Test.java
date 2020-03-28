package com.domain;
import java.io.Serializable;
public class Test implements Serializable{
	private String id;
	private String name;
	private String remark;

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return this.remark;
	}
}