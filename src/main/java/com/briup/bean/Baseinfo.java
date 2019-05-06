package com.briup.bean; 


import com.xuxueli.poi.excel.annotation.ExcelField;

/** 
 * @author yyj 
 * @version CreateTime：2019年4月26日 上午9:44:16 
 * 基础服务器列表
 * 
 */
public class Baseinfo {
	@ExcelField(name = "服务器id")
	private Integer sid;//主键
	@ExcelField(name = "服务器编号")
	private String machinecode;//服务器编号
	@ExcelField(name = "城市")
	private String city;//城市
	@ExcelField(name = "纬度")
	private String latitude;//纬度
	@ExcelField(name = "经度")
	private String longitude;//经度
	@ExcelField(name = "服务器负责人")
	private String machineuser;//服务器负责人
	@ExcelField(name = "运营商")
	private String yys;//运营商
	@ExcelField(name = "联系电话")
	private String telephone;//联系电话
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getMachinecode() {
		return machinecode;
	}
	public void setMachinecode(String machinecode) {
		this.machinecode = machinecode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getMachineuser() {
		return machineuser;
	}
	public void setMachineuser(String machineuser) {
		this.machineuser = machineuser;
	}
	public String getYys() {
		return yys;
	}
	public void setYys(String yys) {
		this.yys = yys;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Baseinfo [sid=" + sid + ", machinecode=" + machinecode
				+ ", city=" + city + ", latitude=" + latitude + ", longitude="
				+ longitude + ", machineuser=" + machineuser + ", yys=" + yys
				+ ", telephone=" + telephone + "]";
	}
	public Baseinfo(Integer sid, String machinecode, String city,
			String latitude, String longitude, String machineuser, String yys,
			String telephone) {
		super();
		this.sid = sid;
		this.machinecode = machinecode;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.machineuser = machineuser;
		this.yys = yys;
		this.telephone = telephone;
	}
	public Baseinfo() {}
	
	
	
}
 