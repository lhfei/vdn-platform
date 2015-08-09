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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.vdn.dashboard.commons.constant.ComboboxCategoryEnum;
import com.ifeng.vdn.dashboard.orm.domain.Combobox;
import com.ifeng.vdn.dashboard.orm.mybatis.mapper.BasicMapper;
import com.ifeng.vdn.dashboard.service.BasicService;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 29, 2015
 */
@Service("basicService")
public class BasicServiceImpl implements BasicService {

	@Override
	public List<Combobox> readISP() {
		Combobox model = new Combobox(ComboboxCategoryEnum.ISP);
		List<Combobox> list = new ArrayList<Combobox>();
		
		list = readCombobox(model);
		
		return list;
	}
	
	@Override
	public List<Combobox> readCombobox(Combobox model) {
		
		return basicMapper.readCombobox(model);
	}

	@Override
	public void importRegion(List<Combobox> list) {
		basicMapper.importRegion(list);
	}
	
	@Override
	public List<Combobox> getRegion(Integer pId) {
		return basicMapper.getRegion(pId);
	}
	
	@Autowired
	private BasicMapper basicMapper;

}
