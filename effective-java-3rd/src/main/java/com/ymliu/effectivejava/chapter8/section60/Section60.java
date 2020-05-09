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

package com.ymliu.effectivejava.chapter8.section60;

import java.math.BigDecimal;

/**
 * 若需要精确答案就应该避免使用float和double类型。
 *
 * @author LYM
 */
public class Section60
{
	public void example1()
	{
		System.out.println("1.03 - 0.42 = " + (1.03 - 0.42));

		System.out.println("1.00 - 9*0.10 = " + (1.00 - 9 * 0.10));
	}

	public void example2()
	{
		double funds = 1.00;
		int itemsBought = 0;
		for (double price = 0.10; funds >= price; price += 0.10)
		{
			funds -= price;
			itemsBought++;
		}

		System.out.println(itemsBought + " item bought.");
		System.out.println("Change: $" + funds);
	}

	public void example3()
	{
		final BigDecimal TEN_CENTS = new BigDecimal(".10");
		int itembought = 0;
		BigDecimal funds = new BigDecimal("1.00");

		for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS))
		{
			funds = funds.subtract(price);
			itembought++;
		}

		System.out.println(itembought + " item bought.");
		System.out.println("Money left over: $" + funds);
	}

	public void example4()
	{
		int itemBought = 0;
		int funds = 100;

		for (int price = 10; funds >= price; price += 10)
		{
			funds -= price;
			itemBought++;
		}

		System.out.println(itemBought + " item bought.");
		System.out.println("Cash left over: " + funds + " cents");
	}
}
