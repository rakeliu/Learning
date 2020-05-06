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

package com.ymliu.effectivejava.chapter4.section23;

/**
 * 类层次结构优于标签类。
 * Tagged class - vastly inferior to a class hierarchy!
 *
 * @author LYM
 */
public class Figure
{
	/**
	 * Tag field - the shapre of this figure
	 */
	final Shape shape;
	/**
	 * These fields are used only if shape is RECTANGLE
	 */
	double length;
	double width;
	/**
	 * This field is used only if shape is CIRCLE
	 */
	double radius;

	/**
	 * Constructor for circle
	 */
	Figure(double radius)
	{
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	/**
	 * Constructor for rectangle
	 */
	Figure(double length, double width)
	{
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area()
	{
		switch (shape)
		{
			case RECTANGLE:
				return length * width;
			case CIRCLE:
				return Math.PI * (radius * radius);
			default:
				throw new AssertionError(shape);
		}
	}

	enum Shape
	{
		/**
		 * 多边形
		 */
		RECTANGLE,
		/**
		 * 圆形
		 */
		CIRCLE
	}
}
