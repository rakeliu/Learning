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

package com.ymliu.effectivejava.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ymliu.effectivejava.BaseTest;
import com.ymliu.effectivejava.chapter3.section10.CaseInsensitiveString1;
import com.ymliu.effectivejava.chapter3.section10.Color;
import com.ymliu.effectivejava.chapter3.section10.ColorPoint1;
import com.ymliu.effectivejava.chapter3.section10.PhoneNumber;
import com.ymliu.effectivejava.chapter3.section10.Point;

public class Chapter3 implements BaseTest
{
	@Override
	public void test()
	{
		this.test10();
		this.test11();
	}

	private void test10()
	{
		final String ORGINAL = "Polish";
		CaseInsensitiveString1 cis = new CaseInsensitiveString1(new String(ORGINAL));
		String s = new String(ORGINAL);

		System.out.println("-------- Section 10 -------------");
		System.out.println("cis.equals(s)=" + cis.equals(s));
		System.out.println("s.equals(cis)=" + s.equals(cis));

		List<CaseInsensitiveString1> list = new ArrayList<>();
		list.add(cis);
		System.out.println("list.contains(cis)=" + list.contains(s));

		System.out.println("     ------------------          ");
		Point p = new Point(1, 2);
		ColorPoint1 cp = new ColorPoint1(1, 2, Color.RED);
		System.out.println("Point p = " + p);
		System.out.println("ColorPoint cp = " + cp);
		System.out.println("p.equals(cp) = " + p.equals(cp));
		System.out.println("cp.eqauls(p) = " + cp.equals(p));

	}

	private void test11()
	{
		System.out.println("-------- Section 11 -------------");
		Map<PhoneNumber, String> m = new HashMap<>();
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");
		System.out.println("m.get(new PhoneNumber(...)) = " + m.get(new PhoneNumber(707, 867, 5309)));
	}
}
