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
package com.ifeng.vdn.dashboard.web.model;
/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 28, 2015
 */
public class FluentMinutelyModel extends AbstractAvlbReport {

	private static final long serialVersionUID = -7102329424908292178L;
	
	public int getT0() {
		return t0;
	}
	public void setT0(int t0) {
		this.t0 = t0;
	}
	public int getT1() {
		return t1;
	}
	public void setT1(int t1) {
		this.t1 = t1;
	}
	public int getT2() {
		return t2;
	}
	public void setT2(int t2) {
		this.t2 = t2;
	}
	public int getT3() {
		return t3;
	}
	public void setT3(int t3) {
		this.t3 = t3;
	}
	public int getT4() {
		return t4;
	}
	public void setT4(int t4) {
		this.t4 = t4;
	}
	public double getK1() {
		return k1;
	}
	public void setK1(double k1) {
		this.k1 = k1;
	}
	public double getK2() {
		return k2;
	}
	public void setK2(double k2) {
		this.k2 = k2;
	}
	public double getK3() {
		return k3;
	}
	public void setK3(double k3) {
		this.k3 = k3;
	}
	public double getK4() {
		return k4;
	}
	public void setK4(double k4) {
		this.k4 = k4;
	}
	
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getTr() {
		return tr;
	}
	public void setTr(String tr) {
		this.tr = tr;
	}



	private int t0;
	private int t1;		// total of 303001
	private int t2;		// total of 303002
	private int t3;		// total of 303003
	private int t4;		// total of 303004
	
	private double k1;
	private double k2;
	private double k3;
	private double k4;
	
	private String ct;
	private String tr;
}
