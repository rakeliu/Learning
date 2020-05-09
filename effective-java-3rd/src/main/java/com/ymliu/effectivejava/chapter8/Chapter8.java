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

package com.ymliu.effectivejava.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ymliu.effectivejava.BaseTest;
import com.ymliu.effectivejava.chapter8.section52.CollectionClassifier;
import com.ymliu.effectivejava.chapter8.section52.Overriding;
import com.ymliu.effectivejava.chapter8.section60.Section60;

/**
 * 第8章 方法：如何处理参数和返回值，如何设计方法签名，如何记载方法文档。
 *
 * @author LYM
 */
public class Chapter8 implements BaseTest
{
	@Override
	public void test()
	{
		System.out.println("---- Chapter 8 ----------------");

		System.out.println("---- Chapter 8 52 1------------");
		CollectionClassifier collectionClassifier = new CollectionClassifier();
		Collection<?>[] collections = {
				// Set
				new HashSet<String>(16),
				// List
				new ArrayList<String>(16),
				// Collection
				new HashMap<String, String>(16).values()};

		for (Collection<?> c : collections)
		{
			System.out.println(collectionClassifier.classifier(c));
			// 结果全部为 Unknown ...
		}

		System.out.println("---- Chapter 8 52 2------------");
		new Overriding().example();

		System.out.println("---- Chapter 8 52 3------------");
		section52_3();

		System.out.println("---- Chapter 8 60 -------------");
		Section60 section60 = new Section60();
		section60.example1();
		section60.example2();
		section60.example3();
		section60.example4();
	}

	private void section52_3()
	{
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>(8);

		for (int i = -3; i < 3; i++)
		{
			set.add(i);
			list.add(i);
		}
		for (int i = 0; i < 3; i++)
		{
			// Set.remove(E)
			set.remove(i);
			// List.remove(index)
			list.remove(i);
		}

		System.out.println(set + " " + list);
	}
}
