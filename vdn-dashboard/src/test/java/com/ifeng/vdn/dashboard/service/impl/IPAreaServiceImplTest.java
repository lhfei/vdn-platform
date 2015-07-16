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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifeng.vdn.dashboard.orm.domain.IPImportReport;
import com.ifeng.vdn.dashboard.service.IPAreaService;
import com.ifeng.vdn.test.support.BasicTestSuit;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 30, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class IPAreaServiceImplTest extends BasicTestSuit {

	@Test
	public void getIPAreaFileChecksum() {
		String md5 = ipAreaService.getIPAreaFileChecksum();
		
		log.info("MD5: {}", md5);
	}
	
	@Test
	public void importIPFromIPAreaFile() {
		IPImportReport report = ipAreaService.importIPFromIPAreaFile();
		
		log.info("Total: {}, Valid: {}", report.getTotal(), report.getValid());
	}
	
	@Test
	public void extractIPAreaFile(){
		List<String> lines = new ArrayList<String>();
		
		lines = ipAreaService.extractIPAreaFile();
		
		log.info("Total: {}, {}\n{}",lines.size(), lines.get(0), lines.get(lines.size() - 1));
		
		log.info("Distinct: {}", lines.stream().distinct().count());
		
		lines.stream().distinct().forEach(new Consumer<String>(){
			@Override
			public void accept(String line) {
				log.info("Line: {}",line);
			}
		});
	}
	
	@Test
	public void downloadIPAreaFile() {
		ipAreaService.downloadIPAreaFile();
	}
	
	@Test
	public void distinctIPAreaFile() {
		ipAreaService.distinctIPAreaFile();
	}
	
	
	@Test
	public void importIPFromIPServer() {
		IPImportReport report = ipAreaService.importIPFromIPServer();
		
		log.info("Total: {}, Valid: {}", report.getTotal(), report.getValid());
	}
	
	@Autowired
	private IPAreaService ipAreaService;
}
