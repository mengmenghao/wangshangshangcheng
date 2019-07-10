package com.cn.vo;

public class Goods {
	private  int goods_id;
	private  int type_id;
	private  String goods_name;
	private  float goods_price;
	private  float goods_discount;
	private  String goods_desc;
	private  String supplier;
	private  int qty;
	private  int ispreferred;
	private  String type_name;
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getIspreferred() {
		return ispreferred;
	}
	public void setIspreferred(int ispreferred) {
		this.ispreferred = ispreferred;
	}
	private  String goods_pic;
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}
	public float getGoods_discount() {
		return goods_discount;
	}
	public void setGoods_discount(float goods_discount) {
		this.goods_discount = goods_discount;
	}
	public String getGoods_desc() {
		return goods_desc;
	}
	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getGoods_pic() {
		return goods_pic;
	}
	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}

}
