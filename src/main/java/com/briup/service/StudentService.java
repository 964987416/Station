package com.briup.service; 

import java.util.Date;
import java.util.List;

import com.briup.bean.Baseinfo;
import com.briup.bean.Station;

/** 
 * @author yyj 
 * 
 */
public interface StudentService {


	void updatePwd(String name, String newpwd);

	void addStation(Station s);

	List<Station> searchStation(Date restarttime1, Date offlinetime1);

	void deleteStation(Integer sid);

	List<Station> searchAllStation();

	List<Object> selectTest(Integer id, String username);

	List<Baseinfo> searchAllBaseinfo();

	void addBaseinfo(Baseinfo s);

	void deleteBaseinfo(Integer id);

	void updateBaseinfo(Baseinfo s);

}
 