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

import java.util.List;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 18, 2015
 */
public class FileStatuses {
	
	public FileStatuses() {}
	
	public FileStatuses(List<FileStatus> FileStatus) {
		this.FileStatus = FileStatus;
	}
	
	public List<FileStatus> getFileStatus() {
		return FileStatus;
	}

	public void setFileStatus(List<FileStatus> fileStatus) {
		FileStatus = fileStatus;
	}

	private List<FileStatus> FileStatus;
}
