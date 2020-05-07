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

package com.ymliu.effectivejava.chapter7.section45;

import java.math.BigInteger;
import java.util.SplittableRandom;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

/**
 * 流并行计算
 *
 * @author LYM
 */
public class Section45
{
	/**
	 * 美森素数
	 */
	public void mersen()
	{
		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
				// 看不懂
				.filter(mersenne -> mersenne.isProbablePrime(50))
				// 限制20个
				.limit(20)
				//
				.forEach(System.out::println);
	}

	private Stream<BigInteger> primes()
	{
		return Stream.iterate(TWO, BigInteger::nextProbablePrime);
	}

	/**
	 * 并行有效性流管道实例，计算n，素数小于或等于n
	 */
	public long pi(long n)
	{
		return LongStream.rangeClosed(2, n)
				// 转为并行计算
				.parallel()
				// 转为BigInteger
				.mapToObj(BigInteger::valueOf)
				// 过滤
				.filter(bi -> bi.isProbablePrime(50))
				// 统计个数
				.count();
	}
}
