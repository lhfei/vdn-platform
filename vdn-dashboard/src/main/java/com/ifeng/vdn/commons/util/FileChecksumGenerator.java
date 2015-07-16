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
package com.ifeng.vdn.commons.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * @version 1.0.0
 *
 * @author Hefei Li
 *
 * @since Jun 30, 2015
 */
public class FileChecksumGenerator {
	public static String getChecksumByMD5(InputStream in) {
		String digestStr = "";
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();

			byte[] bytes = new byte[2048 * 10];
			int numBytes;

			while ((numBytes = in.read(bytes)) != -1) {
				md.update(bytes, 0, numBytes);
			}

			byte[] digest = md.digest();
			digestStr = new String(Hex.encodeHex(digest));
			
		} catch (IOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		return digestStr;
	}
}
