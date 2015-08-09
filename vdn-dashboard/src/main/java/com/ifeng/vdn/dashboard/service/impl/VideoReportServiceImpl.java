/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.ifeng.vdn.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.vdn.dashboard.orm.mybatis.mapper.VideoReportMapper;
import com.ifeng.vdn.dashboard.service.VideoReportService;
import com.ifeng.vdn.dashboard.web.model.AvlbDailyModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyGridModel;
import com.ifeng.vdn.dashboard.web.model.AvlbMinutelyModel;
import com.ifeng.vdn.dashboard.web.model.FluentMinutelyModel;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 22, 2015
 */
@Service("videoReportService")
public class VideoReportServiceImpl implements VideoReportService {

	@Override
	public List<AvlbDailyModel> getAvlb(AvlbMinutelyModel model) {
		
		return videoReportMapper.getAvlb(model);
	}
	
	@Override
	public List<AvlbDailyModel> getAvlbDaily(AvlbDailyModel model) {
		
		return videoReportMapper.getAvlbDaily(model);
	}
	
	@Override
	public long getAvlbMinutelyTotal(AvlbMinutelyModel model) {
		return videoReportMapper.getAvlbMinutelyTotal(model);
	}
	
	@Override
	public List<AvlbMinutelyModel> getAvlbMinutely(AvlbMinutelyModel model) {
		
		return videoReportMapper.getAvlbMinutely(model);
	}
	
	@Override
	public int getAvlbMinutelyForGridTotal(AvlbMinutelyGridModel model) {
		return videoReportMapper.getAvlbMinutelyForGridTotal(model);
	}
	
	@Override
	public List<AvlbMinutelyGridModel> getAvlbMinutelyForGrid(
			AvlbMinutelyGridModel model) {
		
		List<AvlbMinutelyGridModel> list = videoReportMapper.getAvlbMinutelyForGrid(model);
		
		if(list != null){
			for(AvlbMinutelyGridModel item : list){
				double ka;		//per of 303000 / 208000 * 100%                       
				double kb;		// 1- kc                                              
				double kc;		//per of 304001 / 303000 * 100%                       
				double kc2;		//per of 304002 / 303000 * 100%                       
				double kc3;		//per of 304003 / 303000 * 100%                       
				double kc4;		//per of 304004 / 303000 * 100%                       
				double kd;		//per of 301010 / 303000 * 100%	                      
				double kd2;		//per of 301020 / 303000 * 100%                       
				double kd3;		//per of 301040 / 100000 * 100%                       
				double ke;		//per of 301030_X / 303000 * 100%                     
				double kf;		//1 - 303000/100000                                   
				double kf2;		//per of 110000	/ 100000 * 100%-                      
				double kf3;  	//(100000 - 303000 - 110000 - 301040) / 100000 * 100% 

				ka = new Double(item.getB()) / new Double(item.getA());
				kc = new Double(item.getC()) / new Double(item.getB());
				kb = 1 - kc;
				kc2 = new Double(item.getC2()) / new Double(item.getB());
				kc3 = new Double(item.getC3()) / new Double(item.getB());
				kc4 = new Double(item.getC4()) / new Double(item.getB());
				
				kd = new Double(item.getD()) / new Double(item.getB());
				kd2 = new Double(item.getD2()) / new Double(item.getB());
				kd3 = new Double(item.getD3()) / new Double(item.getB());
				
				ke = new Double(item.getB()) / new Double(item.getF());
				
				kf = 1- new Double(item.getE()) / new Double(item.getB());;
				kf2 = new Double(item.getF2()) / new Double(item.getF());
				kf3 = (new Double(item.getF() - item.getB() - item.getF2() - item.getD3()) )/ new Double(item.getB());
				
				
				item.setKa(ka);
				item.setKb(kb);
				item.setKc(kc);
				item.setKc2(kc2);
				item.setKc3(kc3);
				item.setKc4(kc4);
				item.setKd(kd);
				item.setKd2(kd2);
				item.setKd3(kd3);
				item.setKe(ke);
				item.setKf(kf);
				item.setKf2(kf2);
				item.setKf3(kf3);
			}
			
		}else {
			list = new ArrayList<AvlbMinutelyGridModel>();
		}
		
		return list;
	}
	
	@Override
	public List<FluentMinutelyModel> getFluentMinutely(FluentMinutelyModel model) {
		return videoReportMapper.getFluentMinutely(model);
	}
	
	@Autowired
	private VideoReportMapper videoReportMapper;

	
}
