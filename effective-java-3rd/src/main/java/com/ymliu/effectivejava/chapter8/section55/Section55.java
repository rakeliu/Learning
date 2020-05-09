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

package com.ymliu.effectivejava.chapter8.section55;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * 明智审慎地返回Optional
 *
 * @author LYM
 */
public class Section55
{
	/**
	 * Returns maximum value in collection - throws exception if empty
	 */
	public static <E extends Comparable<E>> E maxException(Collection<E> c)
	{
		if (c.isEmpty()) { throw new IllegalArgumentException("Empty collection"); }

		E result = null;
		for (E e : c)
		{
			if (result == null || e.compareTo(result) > 0)
			{
				result = Objects.requireNonNull(e);
			}
		}

		return result;
	}

	/**
	 * Returns maximum value in collection as an Optional<E>
	 */
	public static <E extends Comparable<E>> Optional<E> maxOption(Collection<E> c)
	{
		if (c.isEmpty()) {return Optional.empty();}

		E result = null;
		for (E e : c)
		{
			if (result == null || e.compareTo(result) > 0)
			{
				result = Objects.requireNonNull(e);
			}
		}

		return Optional.of(result);
	}

	public static <E extends Comparable<E>> Optional<E> maxStream(Collection<E> c)
	{
		return c.stream().max(Comparator.naturalOrder());
	}
}
