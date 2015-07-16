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

import java.util.Date;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 18, 2015
 */
public class FileStatus extends AbstractHDFSModel {

	private static final long serialVersionUID = 3533865986164369719L;
	
	public FileStatus() {}
	
	public void FileStatusModel(Date accessTime, Date modificationTime,
			int blockSize, int childrenNum, String fileId, String group,
			long length, String owner, String pathSuffix, String permission,
			int replication, String storagePolicy, String type) {

		this.accessTime = accessTime;
		this.modificationTime = modificationTime;
		this.blockSize = blockSize;
		this.childrenNum = childrenNum;
		this.fileId = fileId;
		this.group = group;
		this.length = length;
		this.owner = owner;
		this.pathSuffix = pathSuffix;
		this.permission = permission;
		this.replication = replication;
		this.storagePolicy = storagePolicy;
		this.type = type;
		
	}
	
	
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public Date getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getChildrenNum() {
		return childrenNum;
	}
	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPathSuffix() {
		return pathSuffix;
	}
	public void setPathSuffix(String pathSuffix) {
		this.pathSuffix = pathSuffix;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public int getReplication() {
		return replication;
	}
	public void setReplication(int replication) {
		this.replication = replication;
	}
	public String getStoragePolicy() {
		return storagePolicy;
	}
	public void setStoragePolicy(String storagePolicy) {
		this.storagePolicy = storagePolicy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	private Date accessTime;
	private Date modificationTime;
	private int blockSize;
	private int childrenNum;
	private String fileId;
	private String group;
	private long length;
	private String owner;
	private String pathSuffix;
	private String permission;
	private int replication;
	private String storagePolicy;
	private String type;
}
