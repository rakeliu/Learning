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

package com.ymliu.effectivejava.chapter5;

import java.util.List;

import com.ymliu.effectivejava.BaseTest;
import com.ymliu.effectivejava.chapter5.section29.Stack;
import com.ymliu.effectivejava.chapter5.section33.Favorites;

/**
 * Generics : 泛型。
 *
 * @author LYM
 */
public class Chapter5 implements BaseTest
{
	@Override
	public void test()
	{
		System.out.println("---- Chapter 5 ----------------");

		System.out.println("-------- Section 29 -----------");
		final String[] args = {"a", "b", "c", "d"};
		Stack<String> stack = new Stack<>();
		for (String arg : args) {stack.push(arg);}
		while (!stack.isEmpty())
		{
			System.out.println("stack.pop : " + stack.pop().toUpperCase());
		}

		System.out.println("-------- Section 33 -----------");
		Favorites favorites = new Favorites();
		List<String> listString = List.of("abc","123");
		// favorites.putFavorite(listString.getClass(), listString); // Error code

	}

	/**
	 * Section 31 - PECS (Producer-Extends, Consumer-Super)
	 * @param list producer, so "List<? extends T>"
	 * @param <T> generic
	 * @return consumer, so "Comparable<? super T>"
	 */
	public <T extends Comparable<? super T>> T max(List<? extends T> list)
	{
		return null;
	}
}
