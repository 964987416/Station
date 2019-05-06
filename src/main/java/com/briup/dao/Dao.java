package com.briup.dao;

import java.util.Date;
import java.util.List;

import com.briup.bean.Baseinfo;
import com.briup.bean.Person;
import com.briup.bean.Station;




/**
 * 
 */
public interface Dao {
	
	Person searchPerson(String userName);
	
	void updatePwd(String name, String newpwd);

	void addStation(Station s);

	List<Station> searchStation(Date restarttime1, Date offlinetime1);

	void deleteStation(Integer sid);

	List<Station> searchAllStation();

	List<Object> selectTest();

	List<Baseinfo> searchAllBaseinfo();

	void addBaseinfo(Baseinfo s);

	void deleteBaseinfo(Integer id);

	void updateBaseinfo(Baseinfo s);
}
