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
package com.ifeng.vdn.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifeng.vdn.dashboard.orm.domain.GlobalVariables;
import com.ifeng.vdn.dashboard.orm.mybatis.mapper.DashboardApplicationConfigurationMapper;


/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 1, 2015
 */
public class DashboardApplicationContext extends AbstractApplicationContext<DashboardConfiguration> {

	protected DashboardApplicationContext() {
		super(DashboardConfiguration.class);
	}
	
	
	public void refresh(GlobalConstant.GlobalCoreCategoryKey key) {
		configurationMapper.loadVariablesByRefkey(key.getKey());
	}
	
	public void refreshAll() {
		dashboardVars = configurationMapper.loadVariablesByRefkey(GlobalConstant.GlobalCoreCategoryKey.DASHBOARD_CONF_KEY.getKey());
		ipserverVars = configurationMapper.loadVariablesByRefkey(GlobalConstant.GlobalCoreCategoryKey.IPSERVER_CONF_KEY.getKey());
		hdfsVars = configurationMapper.loadVariablesByRefkey(GlobalConstant.GlobalCoreCategoryKey.HDFS_CONF_KEY.getKey());
	}
	
	public Map<String,String> getDashboardConfiguration() {
		Map<String, String> map = new HashMap<String, String>();
		
		if (dashboardVars != null) {
			map = dashboardVars.stream().collect(
					Collectors.toMap(GlobalVariables::getVar_name,
							GlobalVariables::getVar_val));
		}
		
		
		return map;
	}
	public Map<String,String> getIPserverConfiguration() {
		Map<String, String> map = new HashMap<String, String>();
		if(ipserverVars != null){
			map = ipserverVars.stream().collect(
					Collectors.toMap(GlobalVariables::getVar_name,
							GlobalVariables::getVar_val));
		}
		
		return map;
	}
	public Map<String,String> getHDFSConfiguration() {
		Map<String, String> map = new HashMap<String, String>();
		if (hdfsVars != null) {
			map = hdfsVars.stream().collect(
					Collectors.toMap(GlobalVariables::getVar_name,
							GlobalVariables::getVar_val));
		}
		return map;
	}
	
	
	private List<GlobalVariables> dashboardVars;
	private List<GlobalVariables> ipserverVars;
	private List<GlobalVariables> hdfsVars;
	
	@Autowired
	private DashboardApplicationConfigurationMapper configurationMapper;
}
