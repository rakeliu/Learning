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

package com.ymliu.effectivejava;

import com.ymliu.effectivejava.chapter2.Chapter2;
import com.ymliu.effectivejava.chapter3.Chapter3;
import com.ymliu.effectivejava.chapter4.Chapter4;
import com.ymliu.effectivejava.chapter5.Chapter5;
import com.ymliu.effectivejava.chapter6.Chapter6;

/**
 * @author LYM
 */
public class MainTest
{
	public static void main(String[] args)
	{
		System.out.println("------ Run Test -----------");
		long runStartTime = System.currentTimeMillis();

		BaseTest test = new Chapter2();
		test.test();
		test = null;

		test = new Chapter3();
		test.test();

		test = new Chapter4();
		test.test();

		test = new Chapter5();
		test.test();

		test = new Chapter6();
		test.test();

		long runEndTime = System.currentTimeMillis();
		System.out.printf("------ run cost time = %dms\n", runEndTime - runStartTime);
		System.out.println("------ Test End -----------");
	}
}
