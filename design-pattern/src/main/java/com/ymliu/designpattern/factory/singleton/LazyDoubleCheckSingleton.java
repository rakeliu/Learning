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

package com.ymliu.designpattern.factory.singleton;

import java.lang.reflect.Constructor;

/**
 * 双重校验懒汉式单例。
 * 构造函数私有化，创建全局静态私有变量，对外提供一个静态方法（含双重校验）
 *
 * @author LYM
 */
public class LazyDoubleCheckSingleton
{
	/**
	 * 步骤2，创建全局静态私有变量。
	 */
	private static LazyDoubleCheckSingleton instance = null;

	/**
	 * 步骤1，构造函数私有化
	 */
	private LazyDoubleCheckSingleton()
	{
		/*
		 * 放置反射破解，这一招对饿汉式和静态内部类都好使，对懒汉式不好使。
		 * 因为，如果反射的创建方式先进来，就能直接创建对象。
		 * 然后正常的创建方式后进来，又能创建对象，就把这个单例破坏了。
		 */
		if (instance != null)
		{
			throw new RuntimeException("单例构造器禁止反射调用");
		}
	}

	/**
	 * 步骤3，对外提供一个静态方法，里面进行了双重校验
	 *
	 * @return 单例
	 */
	public static LazyDoubleCheckSingleton getInstance()
	{
		// 第一次校验
		if (instance == null)
		{
			synchronized (LazyDoubleCheckSingleton.class)
			{
				// 第二次校验，同步方式下
				if (instance == null)
				{ instance = new LazyDoubleCheckSingleton(); }
			}
		}

		return instance;
	}

	/**
	 * 测试
	 *
	 * @param args 参数
	 */
	public static void main(String[] args)
	{
		LazyDoubleCheckSingleton newInstance = null;

		// 先反射方式创建
		try
		{
			Class<?> objectClass = LazyDoubleCheckSingleton.class;
			Constructor<?> constructor = objectClass.getDeclaredConstructor();
			// 暴力访问
			constructor.setAccessible(true);
			newInstance = (LazyDoubleCheckSingleton) constructor.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		// 正常方式创建
		LazyDoubleCheckSingleton oldInstance = LazyDoubleCheckSingleton.getInstance();

		// 比较其地址值
		System.out.println("oldInstance = " + oldInstance);
		System.out.println("newInstance = " + newInstance);
	}
}
