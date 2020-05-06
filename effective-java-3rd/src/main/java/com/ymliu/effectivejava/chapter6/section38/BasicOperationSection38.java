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

package com.ymliu.effectivejava.chapter6.section38;

/**
 * 基本枚举继承接口，可通过接口扩展枚举。
 *
 * @author LYM
 */
public enum BasicOperationSection38 implements OperationSection38
{
	/**
	 * 加法，使用匿名函数来继承接口
	 */
	PLUS("+")
			{
				@Override
				public double apply(double x, double y)
				{
					return x + y;
				}
			},
	MINUS("-")
			{
				@Override
				public double apply(double x, double y)
				{
					return x - y;
				}
			},
	TIMES("*")
			{
				@Override
				public double apply(double x, double y)
				{
					return x * y;
				}
			},
	DIVIDE("/")
			{
				@Override
				public double apply(double x, double y)
				{
					return x / y;
				}
			};

	private final String symbol;

	BasicOperationSection38(String symbol) { this.symbol = symbol; }

	@Override
	public String toString()
	{
		return symbol;
	}
}
