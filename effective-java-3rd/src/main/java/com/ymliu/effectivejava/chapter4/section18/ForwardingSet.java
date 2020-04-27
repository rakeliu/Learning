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
import java.util.Iterator;
import java.util.Set;

/**
 * Instead of InstrumentedHashSet
 *
 * @author LYM
 */
public class ForwardingSet<E> implements Set<E>
{
	private final Set<E> s;

	public ForwardingSet(Set<E> s) {this.s = s;}

	@Override
	public int size()
	{
		return s.size();
	}

	@Override
	public boolean isEmpty()
	{
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator()
	{
		return s.iterator();
	}

	@Override
	public Object[] toArray()
	{
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return s.toArray(a);
	}

	@Override
	public boolean add(E e)
	{
		return s.add(e);
	}

	@Override
	public boolean remove(Object o)
	{
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return s.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return s.removeAll(c);
	}

	@Override
	public void clear()
	{
		s.clear();
	}

	@Override
	public boolean equals(Object o)
	{
		return s.equals(o);
	}

	@Override
	public int hashCode()
	{
		return s.hashCode();
	}

	@Override
	public String toString()
	{
		return s.toString();
	}
}
