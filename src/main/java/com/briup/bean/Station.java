package com.briup.bean; 

import java.util.Date;

import com.xuxueli.poi.excel.annotation.ExcelField;

/** 
 * @author yyj 
 * @version CreateTime：2019年4月26日 上午9:51:45 
 * 服务器信息
 */
public class Station {
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
	@ExcelField(name = "停服时间")
	private Date offlinetime;//停服时间
	@ExcelField(name = "重启时间")
	private Date restarttime;//重启时间
	@ExcelField(name = "停服时长")
	private String outoflinedate;//停服时长
	@ExcelField(name = "记录时间")
	private Date updatetime;//更新时间
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
	public Date getOfflinetime() {
		return offlinetime;
	}
	public void setOfflinetime(Date offlinetime) {
		this.offlinetime = offlinetime;
	}
	public Date getRestarttime() {
		return restarttime;
	}
	public void setRestarttime(Date restarttime) {
		this.restarttime = restarttime;
	}
	public String getOutoflinedate() {
		return outoflinedate;
	}
	public void setOutoflinedate(String outoflinedate) {
		this.outoflinedate = outoflinedate;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
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
		return "Station [sid=" + sid + ", machinecode=" + machinecode
				+ ", city=" + city + ", latitude=" + latitude + ", longitude="
				+ longitude + ", machineuser=" + machineuser + ", offlinetime="
				+ offlinetime + ", restarttime=" + restarttime
				+ ", outoflinedate=" + outoflinedate + ", updatetime="
				+ updatetime + ", yys=" + yys + ", telephone=" + telephone
				+ "]";
	}
	public Station() {}
	
}
 