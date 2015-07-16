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
package com.ifeng.vdn.hdfs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 18, 2015
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListStatus {
	
	public ListStatus() {}
	
	public ListStatus(FileStatuses fileStatuses) {
		this.fileStatuses = fileStatuses;
	}
	
	public FileStatuses getFileStatuses() {
		return fileStatuses;
	}

	public void setFileStatuses(FileStatuses fileStatuses) {
		this.fileStatuses = fileStatuses;
	}


	private FileStatuses fileStatuses;

}
