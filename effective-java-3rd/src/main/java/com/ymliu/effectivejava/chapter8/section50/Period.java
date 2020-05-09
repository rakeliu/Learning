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

package com.ymliu.effectivejava.chapter8.section50;

import java.util.Date;

/**
 * 防御性拷贝
 *
 * @author LYM
 */
public class Period
{
	private final Date start;
	private final Date end;

	/**
	 * @param start the beginning of the period
	 * @param end   then end of the period; must not precede start
	 * @throws IllegalArgumentException if start is after end
	 * @throws NullPointerException     if start or end is null
	 */
	public Period(Date start, Date end)
	{
		if (start.compareTo(end) > 0)
		{
			throw new IllegalArgumentException(start + " after " + end);
		}

		// 防御性拷贝
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
	}

	/**
	 * 防御性拷贝
	 *
	 * @return 一个新对象
	 */
	public Date getStart()
	{
		return new Date(start.getTime());
	}

	/**
	 * 防御性拷贝
	 *
	 * @return 一个新对象
	 */
	public Date getEnd()
	{
		return new Date(start.getTime());
	}
}
