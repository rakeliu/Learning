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

package com.ymliu.effectivejava.chapter2;

import com.ymliu.effectivejava.BaseTest;
import com.ymliu.effectivejava.chapter2.AbstractPizza.Topping;
import com.ymliu.effectivejava.chapter2.NyAbstractPizza.Size;
import com.ymliu.effectivejava.chapter2.section06.RomanNumerals;
import com.ymliu.effectivejava.chapter2.section08.Room;

public class Chapter2 implements BaseTest
{
	@Override
	public void test()
	{
		//		test1();
		//		test2();
		//		test06();
		//		test06_1();
		test08();
	}

	public void test1()
	{
		System.out.println("-------- Section builder 1 -------------");
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
		System.out.printf("NutritionFacts cocaCola=%s\n", cocaCola);
	}

	/**
	 * Test Pizza
	 */
	public void test2()
	{
		System.out.println("-------- Section builder 2 -------------");

		NyAbstractPizza pizza = new NyAbstractPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
		Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();

		System.out.printf("NyPizza: %s\n", pizza);
		System.out.printf("calzone: %s\n", calzone);
	}

	public void test06()
	{
		System.out.println("-------- Section 6 -------------");

		RomanNumerals rn = new RomanNumerals();

		long start, end, time1, time2;
		final int first = 1000, last = first + 10000;
		final String s = "ABC";

		start = System.currentTimeMillis();
		for (int i = first; i < last; i++)
		{
			rn.isRomanNumeral1(s);
		}
		end = System.currentTimeMillis();
		System.out.printf("isRomanNumeral1: {}ms\n", end - start);

		start = System.currentTimeMillis();
		for (int i = first; i < last; i++)
		{
			rn.isRomanNumeral2(s);
		}
		end = System.currentTimeMillis();
		System.out.printf("isRomanNumeral2: %dms\n", end - start);
	}

	public void test06_1()
	{
		System.out.println("-------- Section 6-1 -------------");

		long start = System.currentTimeMillis();

		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {sum += i;}
		long end = System.currentTimeMillis();
		System.out.printf("sum Long : %dms\n", end - start);

		start = System.currentTimeMillis();
		long sum1 = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {sum1 += i;}
		end = System.currentTimeMillis();
		System.out.printf("sum long : %dms\n", end - start);
	}

	public void test08()
	{
		System.out.println("-------- Section 8 -------------");

		try (Room myRoom = new Room(7))
		{
			System.out.println("Goodbye");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("---------------");
		new Room(99);
		System.out.println("Peace out");
		System.gc();
	}
}
