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

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式：构造函数私有化，创建全局静态final变量，对外提供一个静态方法。
 *
 * @author LYM
 */
public class HungrySingleton implements Serializable
{
	@Serial
	private final static long serialVersionUID = 645296316455539384L;

	/**
	 * 步骤2，创建全局静态final变量
	 */
	private static final HungrySingleton HUNGRYSINGLETON = new HungrySingleton();

	/**
	 * 步骤1，构造函数私有化
	 */
	private HungrySingleton()
	{
		// 防止反射破解，这一招对饿汉式的静态内部类都好使，对懒汉式不好使。
		if (HUNGRYSINGLETON != null)
		{
			throw new RuntimeException("单例构造器禁止反射调用！");
		}
	}

	/**
	 * 步骤3，对外提供一个静态方法
	 *
	 * @return 静态final变量
	 */
	public static HungrySingleton getInstance()
	{
		return HUNGRYSINGLETON;
	}

	/**
	 * 一旦单例模式涉及到序列化和反序列化，要小心单例被破坏
	 * 这个方法是反射时调用，如果不写这个方法，序列化就会破坏单例
	 *
	 * @return 静态final变量
	 * @see java.io.ObjectInputStream
	 */
	@Serial
	private Object readResolve()
	{
		return HUNGRYSINGLETON;
	}

	/**
	 * 测试方法
	 *
	 * @param args 参数
	 */
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
	{
		// 正常方法创建对象
		HungrySingleton oldInstance = HungrySingleton.getInstance();
		System.out.println("正常方法创建对象 完成");

		// 反射方法创建，应该抛出异常
		System.out.println("反射方法创建对象 开始");
		Class<?> objectClass = HungrySingleton.class;
		Constructor<?> constructor = objectClass.getDeclaredConstructor();
		// 设置暴力访问
		constructor.setAccessible(true);
		HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
		System.out.println("反射方法创建对象 完成");

		// 比较其地址值
		System.out.println("oldInstance" + oldInstance);
		System.out.println("newInstance" + newInstance);
		System.out.println(oldInstance == newInstance);
	}
}
