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

import java.io.Serializable;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jul 23, 2015
 */
public abstract class AbstractAvlbReport implements Serializable {
	
	private static final long serialVersionUID = 8859366677137736909L;
	
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public double getAvlb() {
		return avlb;
	}
	public void setAvlb(double avlb) {
		this.avlb = avlb;
	}
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String dCode) {
		this.dCode = dCode;
	}
	public String getnCode() {
		return nCode;
	}
	public void setnCode(String nCode) {
		this.nCode = nCode;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

	private String err;
	private int total;
	private int denominator;	// 分母
	private int numerator;		// 分子
	private double avlb;		// 可用性
	private String dCode;		// 分母 code
	private String nCode;		// 分子 code
	
	private int type;
	private int range;
}
