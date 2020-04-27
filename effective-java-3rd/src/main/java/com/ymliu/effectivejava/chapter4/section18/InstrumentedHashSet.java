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

package com.ymliu.effectivejava.chapter4.section18;

import java.util.Collection;
import java.util.HashSet;

/**
 * Broken - Inappropriate use of inheritance!
 *
 * @author LYM
 */
public class InstrumentedHashSet<E> extends HashSet<E>
{
	/**
	 * The number of attempted element insertions
	 */
	private int addCount = 0;

	public InstrumentedHashSet() {}

	public InstrumentedHashSet(int initCap, float loadFactor)
	{
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e)
	{
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		addCount += c.size();

		// super.addAll will call super.add that call this.add ...
		return super.addAll(c);
	}

	public int getAddCount()
	{
		return addCount;
	}
}
