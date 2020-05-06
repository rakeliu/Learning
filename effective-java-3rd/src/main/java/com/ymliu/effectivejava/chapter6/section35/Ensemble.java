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

package com.ymliu.effectivejava.chapter6.section35;

/**
 * Do not use ordinal()
 * 演奏人数类型
 */
public enum Ensemble
{
	/**
	 * 单人 solo
	 */
	SOLO(1),
	DUET(2),
	TRIO(3),
	QUARTET(4),
	QUINTET(5),
	SEXTET(6),
	SEPTET(7),
	OCTET(8),
	DOUBLE_QUARTET(8),
	NONET(9),
	DECTET(10),
	TRIPLE_QUARTET(12);
	private final int numberOfMusicians;

	Ensemble(int size) { this.numberOfMusicians = size; }

	public int numberOfMusicians() { return numberOfMusicians; }
}
