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

package com.ymliu.effectivejava.chapter6.section34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.source.util.Plugin;

/**
 * Enum type that switches on its own value - questionable
 *
 * @author LYM
 */

public enum Operation
{
	/**
	 * 计算方法
	 */
	PLUS("+")
			{
				@Override
				public double apply(double x, double y) { return x + y; }
			},
	MINUS("-")
			{
				@Override
				public double apply(double x, double y) { return x - y; }
			},

	TIMES("*")
			{
				@Override
				public double apply(double x, double y) { return x * y; }
			},

	DIVIDE("/")
			{
				@Override
				public double apply(double x, double y) { return x / y; }
			};

	public abstract double apply(double x, double y);

	private final String symbol;

	Operation(String symbol) {this.symbol = symbol;}

	@Override
	public String toString() {return symbol;}

	/**
	 * Implementing a fromString method on an enum type
	 */
	private static final Map<String, Operation> STRING_TO_ENUM = Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

	/**
	 * REturns Operation for string ,if any
	 *
	 * @param symbol string
	 * @return Operation from string, error for null
	 */
	public static Optional<Operation> fromString(String symbol)
	{
		return Optional.ofNullable(STRING_TO_ENUM.get(symbol));
	}

	/**
	 * Switch on an enum to simulate a missing method
	 */
	public static Operation inverse(Operation op)
	{
		switch (op)
		{
			case PLUS:
				return MINUS;
			case MINUS:
				return PLUS;
			case TIMES:
				return DIVIDE;
			case DIVIDE:
				return TIMES;
			default:
				throw new AssertionError("Unknown op: " + op);
		}
	}
}
