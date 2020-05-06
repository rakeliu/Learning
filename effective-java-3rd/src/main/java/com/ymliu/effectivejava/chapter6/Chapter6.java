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

package com.ymliu.effectivejava.chapter6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.ymliu.effectivejava.BaseTest;
import com.ymliu.effectivejava.chapter6.section34.Operation;
import com.ymliu.effectivejava.chapter6.section34.Planet;
import com.ymliu.effectivejava.chapter6.section37.Plant;
import com.ymliu.effectivejava.chapter6.section37.Plant.LifeCycle;
import com.ymliu.effectivejava.chapter6.section38.ExtendedOperationSection38;
import com.ymliu.effectivejava.chapter6.section38.OperationSection38;

import static java.util.Comparator.comparingInt;

/**
 * Enums and Annotations : 枚举和注解
 *
 * @author LYM
 */
public class Chapter6 implements BaseTest
{
	@Override
	public void test()
	{
		System.out.println("---- Chapter 6 ----------------");

		System.out.println("-------- Section 34-1 ---------");
		double earthWeight = ThreadLocalRandom.current().nextDouble(100, 1000);
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		System.out.printf("EarthWeight is %f, mass is %f%n", earthWeight, mass);
		for (Planet p : Planet.values())
		{
			System.out.printf("Weight on %-10s is %f%n", p, p.surfaceWeight(mass));
		}

		System.out.println("-------- Section 34-2 ---------");
		double x = ThreadLocalRandom.current().nextDouble(0, 10);
		double y = ThreadLocalRandom.current().nextDouble(0, 10);
		for (Operation op : Operation.values())
		{
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}

		System.out.println("-------- Section 34-3 ---------");
		Plant[] plants = new Plant[]{new Plant("1", LifeCycle.ANNUAL), new Plant("2", LifeCycle.BIENNIAL), new Plant("3", LifeCycle.PERENNIAL)};
		Plant.iterateByMap(plants);
		Plant.iterateByOrdinal(plants);
		Plant.iterateByStream(plants);

		System.out.println("-------- Section 38 -----------");
		x = ThreadLocalRandom.current().nextDouble(10);
		y = ThreadLocalRandom.current().nextDouble(10);
		test(ExtendedOperationSection38.class, x, y);
		test(Arrays.asList(ExtendedOperationSection38.values()), x, y);
	}

	private <T extends Enum<T> & OperationSection38> void test(Class<T> opEnumType, double x, double y)
	{
		for (OperationSection38 op : opEnumType.getEnumConstants())
		{
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

	private void test(Collection<? extends OperationSection38> opSet, double x, double y)
	{
		for (OperationSection38 op : opSet)
		{
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

	private void testSection42(List<String> words)
	{
		Collections.sort(words, new Comparator<String>()
		{
			@Override
			public int compare(String s1, String s2)
			{
				return Integer.compare(s1.length(), s2.length());
			}
		});

		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

		Collections.sort(words, comparingInt(String::length));

		words.sort(comparingInt(String::length));
	}
}
