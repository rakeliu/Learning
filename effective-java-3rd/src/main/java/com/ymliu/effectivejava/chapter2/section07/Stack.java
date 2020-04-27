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

package com.ymliu.effectivejava.chapter2.section07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack
{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack()
	{
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e)
	{
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop1()
	{
		if (size == 0) {throw new EmptyStackException();}
		return elements[--size];
		// elements[size] 仍指向该对象，引用仍存在，除非重新push到该元素。
	}

	public Object pop2()
	{
		if (size == 0) {throw new EmptyStackException();}
		Object result = elements[--size];
		// 释放引用
		elements[size] = null;
		return result;
	}

	private void ensureCapacity()
	{
		if (elements.length == size)
		{
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	@Override
	public Stack clone()
	{
		try
		{
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		}
		catch (CloneNotSupportedException e)
		{
			throw new AssertionError();
		}
	}
}
