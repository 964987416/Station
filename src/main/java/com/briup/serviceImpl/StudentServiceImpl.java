package com.briup.serviceImpl; 

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Baseinfo;
import com.briup.bean.Station;
import com.briup.dao.Dao;
import com.briup.service.StudentService;


/** 
 * @author yyj 
 * 
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService{
	@Resource
	private Dao dao;
	
	@Override
	public void updatePwd(String name, String newpwd) {
		dao.updatePwd(name,newpwd);
	}
	@Override
	public void addStation(Station s) {
		dao.addStation(s);
	}
	@Override
	public List<Station> searchStation(Date restarttime1, Date offlinetime1) {
		// TODO Auto-generated method stub
		return dao.searchStation(restarttime1,offlinetime1);
	}
	@Override
	public void deleteStation(Integer sid) {
		dao.deleteStation(sid);
		
	}
	@Override
	public List<Station> searchAllStation() {
		// TODO Auto-generated method stub
		return dao.searchAllStation();
	}
	@Override
	public List<Object> selectTest(Integer id, String username) {
		return dao.selectTest();
		
	}
	@Override
	public List<Baseinfo> searchAllBaseinfo() {
		// TODO Auto-generated method stub
		return dao.searchAllBaseinfo();
	}
	@Override
	public void addBaseinfo(Baseinfo s) {
		// TODO Auto-generated method stub
		dao.addBaseinfo(s);
		
	}
	@Override
	public void deleteBaseinfo(Integer id) {
		dao.deleteBaseinfo(id);
		
	}
	@Override
	public void updateBaseinfo(Baseinfo s) {
		dao.updateBaseinfo(s);
	}
	

}
 