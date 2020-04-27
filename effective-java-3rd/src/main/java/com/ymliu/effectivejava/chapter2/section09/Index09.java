/*
 * MIT License
 *
 * Copyright (c) 2020 Liu Yamin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.ymliu.effectivejava.chapter2.section09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Index09
{
	private static final int BUFFER_SIZE = 1 << 10;

	/**
	 * 传统try-finally
	 */
	static String firstLineOfFile(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		try
		{
			return br.readLine();
		}
		finally
		{
			br.close();
		}
	}

	/**
	 * 使用try-with-resources - the best way to close resources!
	 */
	static String firstLineOfFile2(String path) throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
		}
	}

	static String firstLineOfFile3(String path, String defaultVal)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
		}
		catch (IOException e)
		{
			return defaultVal;
		}
	}

	/**
	 * 传统 try-finally is ugly when used with more than one resource!
	 */
	static void copy(String src, String dst) throws IOException
	{
		InputStream in = new FileInputStream(src);
		try
		{
			OutputStream out = new FileOutputStream(dst);
			try
			{
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while ((n = in.read(buf)) >= 0) { out.write(buf, 0, n); }
			}
			finally
			{
				out.close();
			}
		}
		finally
		{
			in.close();
		}
	}

	/**
	 * try-with-resource on multiple resources - short and sweet
	 */
	static void copy2(String src, String dst) throws IOException
	{
		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst))
		{
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0) {out.write(buf, 0, n);}
		}
	}
}
