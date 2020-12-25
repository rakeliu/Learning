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
 */

package com.ymliu.designpattern.creative.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器式单例
 *
 * @author LYM
 */
public class ContainerSingleton
{
	private static Map<String, Object> singlttonMap = new HashMap<>(0);

	private ContainerSingleton() {}

	public static void putInstance(String key, Object instance)
	{
		if (!singlttonMap.containsKey(key))
		{
			singlttonMap.put(key, instance);
		}
	}

	public static Object getInstance(String key)
	{
		return singlttonMap.get(key);
	}

	public static void main(String[] args)
	{
		ContainerSingleton.putInstance("city", "北京");
		ContainerSingleton.putInstance("风清扬", "独孤九剑");

		String str = (String)ContainerSingleton.getInstance("风清扬");
		System.out.print(str);
	}
}
