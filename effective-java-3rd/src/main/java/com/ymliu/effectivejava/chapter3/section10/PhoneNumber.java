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

package com.ymliu.effectivejava.chapter3.section10;

import java.util.Comparator;
import java.util.Objects;

/**
 * Returns the string representation of this phone number
 * The string consists of twelve characters whose format is
 * "XXX-YYY-ZZZZ"
 *
 * @author LYM
 */
public class PhoneNumber implements Comparable
{
	private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode).thenComparingInt(pn -> pn.prefix).thenComparingInt(pn -> pn.lineNum);
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum)
	{
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
	}

	private static short rangeCheck(int val, int max, String arg)
	{
		if (val < 0 || val > max) {throw new IllegalArgumentException(arg + ": " + val);}

		return (short) val;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == this) {return true;}
		if (!(o instanceof PhoneNumber)) {return false;}

		PhoneNumber pn = (PhoneNumber) o;

		return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(areaCode, prefix, lineNum);
	}

	@Override
	public String toString()
	{
		return String.format("%03d-%o3d=%04d", areaCode, prefix, lineNum);
	}

	@Override
	public int compareTo(Object o)
	{
		if (o == null) {return 1;}
		if (!(o instanceof PhoneNumber)) {throw new ClassCastException();}
		PhoneNumber pn = (PhoneNumber) o;
		return COMPARATOR.compare(this, pn);
	}
}
