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

/**
 * 静态内部类方式。
 * 构造函数私有化，创建静态内部类对象，对外提供一个静态方法。
 *
 * @author LYM
 */
public class StaticInnerClassSingleton
{
	/**
	 * 步骤1，构造函数私有化
	 */
	private StaticInnerClassSingleton()
	{
		// 防止反射破解，这一招对饿汉式和静态内部类单例都好使，对懒汉式不好使
		if (Holder.INSTANCE != null)
		{
			throw new RuntimeException("单例构造器禁止反射调用");
		}
	}

	/**
	 * 步骤2，创建静态内部类对象。
	 * 只包含一个final static外部对象。
	 *
	 * @author LYM
	 */
	private static class Holder
	{
		private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
	}

	/**
	 * 步骤3，对外提供一个静态方法
	 *
	 * @return 单例
	 */
	public static StaticInnerClassSingleton getInstance()
	{
		return Holder.INSTANCE;
	}

	/**
	 * 测试方法
	 *
	 * @param args 参数
	 */
	public static void main(String[] args)
	{
		StaticInnerClassSingleton single1 = StaticInnerClassSingleton.getInstance();
		StaticInnerClassSingleton single2 = StaticInnerClassSingleton.getInstance();

		// 比较其地址值
		System.out.println("single1 = " + single1);
		System.out.println("single2 = " + single2);
		System.out.println(single1 == single2);
	}
}
