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

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifeng.vdn.dashboard.service.IPAddressHandler;
import com.ifeng.vdn.test.support.BasicTestSuit;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 2, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class IPV4HandlerTest extends BasicTestSuit {

	@Test
	public void getAllFromRange(){
//		List<String> ips = ipV4Handler.getAllFromRange("218.1.0.0", "218.1.255.255");
		List<String> ips = ipV4Handler.getAllFromRange("202.110.216.64", "202.110.216.71");
		
		for(String ip : ips){
			log.info("IP: {}", ip);
		}
	}
	
	@Autowired
	IPAddressHandler ipV4Handler;
}
