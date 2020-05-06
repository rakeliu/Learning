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

package com.ymliu.effectivejava.chapter5.section29;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Object-based collection - a prime candidate for generic
 * Base of section 7
 *
 * @author LYM
 */
public class Stack<E>
{
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	private E[] elements;
	private int size = 0;

	public Stack()
	{
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e)
	{
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop()
	{
		if (size == 0) {throw new EmptyStackException();}

		E result = elements[--size];
		// Eliminate obsolete reference
		elements[size] = null;
		return result;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	private void ensureCapacity()
	{
		if (elements.length == size)
		{
			elements = Arrays.copyOf(elements, (size << 1) + 1);
		}
	}

	/**
	 * Wildcard type for a parameter tah serves as an E producer
	 * for section 31
	 *
	 * @param src wildcard generic "? extends E"
	 */
	public void pushAll(Iterable<? extends E> src)
	{
		for (E e : src) {push(e);}
	}

	/**
	 * Wildcard type for parameter that serves as an E consumer
	 * for section 31
	 *
	 * @param dst wildcar generic "? super E"
	 */
	public void popAll(Collection<? super E> dst)
	{
		while (!isEmpty()) {dst.add(pop());}
	}
}
