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
package com.ifeng.vdn.dashboard.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.vdn.dashboard.orm.domain.Combobox;
import com.ifeng.vdn.dashboard.service.BasicService;
import com.ifeng.vdn.test.support.BasicTestSuit;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 30, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
public class BasicServiceImplTest extends BasicTestSuit {

	@Test
	public void importCountry() {
		List<Combobox> list = new ArrayList<Combobox>();
		Combobox model = new Combobox();
		
		model.setComboLabel("中国");
		model.setpId(0);
		model.setComboCode("08");
		model.setComboKey("CN");
		
		Combobox model2 = new Combobox();
		model2.setComboLabel("美国");
		model2.setpId(0);
		model2.setComboCode("01");
		model2.setComboKey("US");
		
		Combobox model3 = new Combobox();
		model3.setComboLabel("加拿大");
		model3.setpId(0);
		model3.setComboCode("06");
		model3.setComboKey("CNA");
		
		list.add(model);
		list.add(model2);
		list.add(model3);
		
		basicService.importRegion(list);
	}
	
	@Test
	public void importCom() {
		ObjectMapper json = new ObjectMapper();
		try {
			
			JsonNode jsonArray  = json.readTree(new FileInputStream(new File("src/test/resources/data/country.json")));
			
			List<Combobox> list = new ArrayList<Combobox>();
			
			
			
			if(jsonArray.isArray()){
				log.info("JSON Array Size: {}", jsonArray.size());
				
				Iterator<JsonNode> items = jsonArray.iterator();
				
				while(items.hasNext()){
					JsonNode node = items.next();
					String label = node.get("name").asText();
					
					Combobox model = new Combobox();
					
					model.setpId(1);
					model.setComboLabel(label);
					model.setComboCode(label);
					model.setComboKey("CN");
					
					list.add(model);
				}
				
				
				basicService.importRegion(list);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void importCity() {
		ObjectMapper json = new ObjectMapper();
		try {
			
			JsonNode jsonArray  = json.readTree(new FileInputStream(new File("src/test/resources/data/city.json")));
			
			int startPid = 4;
			
			
			if(jsonArray.isArray()){
				log.info("JSON Array Size: {}", jsonArray.size());
				
				Iterator<JsonNode> items = jsonArray.iterator();
				
				while(items.hasNext()){
					List<Combobox> list = new ArrayList<Combobox>();
					
					JsonNode cityNode = items.next();
					
					if(cityNode.isArray()){
						Iterator<JsonNode> citys = cityNode.iterator();
						while(citys.hasNext()){
							JsonNode city = citys.next();
							
							String label = city.get("name").asText();
							log.info("City: {}", label);
							
							Combobox model = new Combobox();
							model.setpId(startPid);
							model.setComboLabel(label);
							model.setComboCode(label);
							model.setComboKey("CN");
							
							list.add(model);
						}
						
						basicService.importRegion(list);
						
						startPid ++;
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Autowired
	private BasicService basicService;
}
