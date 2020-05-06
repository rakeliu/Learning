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

package com.ymliu.effectivejava.chapter4;

import java.util.List;
import java.util.Set;

import com.ymliu.effectivejava.BaseTest;
import com.ymliu.effectivejava.chapter4.section18.InstrumentedHashSet;
import com.ymliu.effectivejava.chapter4.section18.InstrumentedSet;
import com.ymliu.effectivejava.chapter4.section19.Sub;

/**
 * Chapter4. Classes and Interfaces
 *
 * @author LYM
 */
public class Chapter4 implements BaseTest
{
	@Override
	public void test()
	{
		System.out.println("---- Chapter 4 ----------------");

		System.out.println("-------- Section 18 -----------");
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(List.of("Snap", "Crackle", "Pop"));
		System.out.println("addCount = " + s.getAddCount());

		System.out.println("-------- Section 18-1 ---------");
		Set<String> original = Set.copyOf(List.of("Snap", "Crackle", "Pop"));
		Set<String> s1 = new InstrumentedSet<String>(original);

		System.out.println("-------- Section 19 -----------");
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
