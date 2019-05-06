package com.briup.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.Baseinfo;
import com.briup.bean.Station;
import com.briup.service.StudentService;
import com.xuxueli.poi.excel.ExcelExportUtil;
import com.xuxueli.poi.excel.ExcelImportUtil;
import com.xuxueli.poi.excel.test.model.ShopDTO;

/**
 * @author yyj
 * 
 */
@Controller
public class UserController {
	@Autowired
	private StudentService studentService;
	// 日志
	Logger log = LoggerFactory.getLogger(UserController.class);

	// 添加服务器信息
	@RequestMapping(value = "/addStation", method = { RequestMethod.POST })
	public String addStu(HttpServletRequest request,
			@RequestParam("UserName") String name,
			@RequestParam("XueHao") String code,
			@RequestParam("Age") String age,
			@RequestParam("Province") String province,
			@RequestParam("City") String city,
			@RequestParam("Town") String town,
			@RequestParam("Classes") String classes,
			@RequestParam("offlinetime") String offlinetime,
			@RequestParam("restarttime") String restarttime,
			@RequestParam("yys") String yys,
			@RequestParam("telephone") String telephone) {

		String address = province + "-" + city + "-" + town;
		Station s = new Station();
		s.setMachinecode(name);
		s.setLatitude(age);
		s.setLongitude(code);
		s.setCity(address);
		s.setMachineuser(classes);
		s.setYys(yys);
		s.setTelephone(telephone);
		//将前端String类型日期转换为date类型日期
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
			//将多余的字符剔除
			offlinetime = offlinetime.replace("T"," ");
			restarttime = restarttime.replace("T"," ");
			Date offlinetimedate = sdf.parse(offlinetime);
			Date restarttimedate = sdf.parse(restarttime);
			s.setOfflinetime(offlinetimedate);
			s.setRestarttime(restarttimedate);
			//计算停服时长
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//这里想要只保留分秒可以写成"mm:ss"
			formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
			//将恢复时间的date类型转换为毫秒数类型减去停服的时间 得到停服时长
			//再将停服时长格式化存入Station对象中
	        String outoflinedate = formatter.format(restarttimedate.getTime()-offlinetimedate.getTime());
	        
			s.setOutoflinedate(outoflinedate);
			s.setUpdatetime(new Date());
			studentService.addStation(s);
			
			return "adminindex";
		} catch (Exception e) {
			 
		}
	
		return "adminindex";

	}
	
	// 查询服务器列表
		@RequestMapping(value = "/searchStation", method = { RequestMethod.GET })
		public String searchStation(HttpServletRequest request,
				@RequestParam("offlinetime") String offlinetime,
				@RequestParam("restarttime") String restarttime) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (offlinetime != null && offlinetime != "" && restarttime != null
					&& restarttime != "") {
				Date offlinetime1 = sdf.parse(offlinetime);
				Date restarttime1 = sdf.parse(restarttime);
				List<Station> list = new ArrayList<Station>();
				list = studentService.searchStation(restarttime1, offlinetime1);
				for (Station station : list) {
					System.out.println(station);
				}
				request.setAttribute("list", list);
				request.setAttribute("offlinetime", offlinetime);
				request.setAttribute("restarttime", restarttime);
			}
			} catch (Exception e) {
				 
			}
			
			return "SelectcourseT";
		}
		
		
		// 查询所有服务器列表
				@RequestMapping(value = "/viewAll", method = { RequestMethod.GET })
				public String viewAll(HttpServletRequest request
						) {
					try {
						List<Station> list = new ArrayList<Station>();
						list = studentService.searchAllStation();
						for (Station station : list) {
							System.out.println(station);
						}
						request.setAttribute("list", list);
					} catch (Exception e) {
						 
					}
					
					return "adminindex";
				}
		
	
		// 导出服务器列表
				@RequestMapping(value = "/exportStation", method = { RequestMethod.GET })
				public String exportStation(HttpServletRequest request,
						@RequestParam("offlinetime") String offlinetime,
						@RequestParam("restarttime") String restarttime) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date restarttime1 = sdf.parse(restarttime);
						Date offlinetime1 = sdf.parse(offlinetime);
						List<Station> list = new ArrayList<Station>();
						list = studentService.searchStation(restarttime1,offlinetime1);
						
						for (Station station : list) {
							System.out.println(station);
						}
						
						String filePath = "E:\\demo-sheet.xls";
						
						ExcelExportUtil.exportToFile(filePath, list);
						
						request.setAttribute("list", list);
						request.setAttribute("offlinetime", offlinetime);
						request.setAttribute("restarttime", restarttime);

					} catch (Exception e) {
						 
					}
					
					return "SelectcourseT";
				}
	
				// 从excel导入服务器列表
				@RequestMapping(value = "/importStation", method = { RequestMethod.GET })
				public String importStation(HttpServletRequest request) {
					try {
						String path = "E:\\demo-sheet.xls";
						@SuppressWarnings("unchecked")
						List<Station> Stations =  (List<Station>) ExcelImportUtil.importExcel(path, Station.class);

						for (Station station : Stations) {
							studentService.addStation(station);
						}
					} catch (Exception e) {
						e.printStackTrace(); 
					}
					return "SelectcourseT";
				}

	// 删除服务器功能
	@RequestMapping(value = "/deleteStation", method = { RequestMethod.GET })
	public String deleteStu(HttpServletRequest request,
			@RequestParam("sid") String sid) {
		try {
			if (sid != null && sid != "") {
				Integer id = Integer.parseInt(sid);
				studentService.deleteStation(id);
			}

		} catch (Exception e) {

		}

		return "adminindex";
	}
		// 查询所有服务器基础列表
		@RequestMapping(value = "/viewAllBaseinfo", method = { RequestMethod.GET })
		public String viewAllBaseinfo(HttpServletRequest request
				) {
			try {
				List<Baseinfo> list = new ArrayList<Baseinfo>();
				list = studentService.searchAllBaseinfo();
				
				request.setAttribute("list", list);
			} catch (Exception e) {
				 
			}
			
			return "adminindex";
		}
		
		// 查询所有服务器基础列表到修改页面
				@RequestMapping(value = "/viewAllBaseinfoupdate", method = { RequestMethod.GET })
				public String viewAllBaseinfoupdate(HttpServletRequest request
						) {
					try {
						List<Baseinfo> list = new ArrayList<Baseinfo>();
						list = studentService.searchAllBaseinfo();
						
						request.setAttribute("list", list);
					} catch (Exception e) {
						 
					}
					
					return "SelectstudentT";
				}
		//addBaseinfo
		// 添加服务器信息
		@RequestMapping(value = "/addBaseinfo", method = { RequestMethod.POST })
		public String addBaseinfo(HttpServletRequest request,
				@RequestParam("UserName") String name,
				@RequestParam("XueHao") String code,
				@RequestParam("Age") String age,
				@RequestParam("Province") String province,
				@RequestParam("City") String city,
				@RequestParam("Town") String town,
				@RequestParam("Classes") String classes,
				@RequestParam("yys") String yys,
				@RequestParam("telephone") String telephone) {

			String address = province + "-" + city + "-" + town;
			Baseinfo s = new Baseinfo();
			s.setMachinecode(name);
			s.setLatitude(age);
			s.setLongitude(code);
			s.setCity(address);
			s.setMachineuser(classes);
			s.setYys(yys);
			s.setTelephone(telephone);
			try {
				studentService.addBaseinfo(s);
				
				return "adminindex";
			} catch (Exception e) {
				 e.printStackTrace();
			}
		
			return "adminindex";
		}
		// 删除基础服务器功能
		@RequestMapping(value = "/deleteBaseinfo", method = { RequestMethod.GET })
		public String deleteBaseinfo(HttpServletRequest request,
				@RequestParam("sid") String sid) {
			try {
				if (sid != null && sid != "") {
					Integer id = Integer.parseInt(sid);
					studentService.deleteBaseinfo(id);
				}

			} catch (Exception e) {

			}

			return "adminindex";
		}
		// 修改服务器信息
				@RequestMapping(value = "/updateBaseinfo", method = { RequestMethod.GET })
				public String updateBaseinfo(HttpServletRequest request,
						@RequestParam("sid") String sid,
						@RequestParam("machinecode") String machinecode,
						@RequestParam("latitude") String latitude,
						@RequestParam("longitude") String longitude,
						@RequestParam("City") String city,
						@RequestParam("machineuser") String machineuser,
						@RequestParam("yys") String yys,
						@RequestParam("telephone") String telephone) {

					Baseinfo s = new Baseinfo();
					s.setSid(Integer.parseInt(sid));
					s.setMachinecode(machinecode);
					s.setLatitude(latitude);
					s.setLongitude(longitude);
					s.setCity(city);
					s.setMachineuser(machineuser);
					s.setYys(yys);
					s.setTelephone(telephone);
					try {
						studentService.updateBaseinfo(s);
						
						return "adminindex";
					} catch (Exception e) {
						 e.printStackTrace();
					}
				
					return "adminindex";
				}
				
}
