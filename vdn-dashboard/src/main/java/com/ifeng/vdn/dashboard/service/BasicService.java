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
package com.ifeng.vdn.dashboard.service;

import java.util.List;

import com.ifeng.vdn.dashboard.orm.domain.Combobox;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 29, 2015
 */
public interface BasicService {
	
	List<Combobox> readISP();
	
	List<Combobox> readCombobox(Combobox model);
	
	void importRegion(List<Combobox> list);
	
	List<Combobox> getRegion(Integer pId);
}
