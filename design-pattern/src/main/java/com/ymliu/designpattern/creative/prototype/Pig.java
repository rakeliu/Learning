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

package com.ymliu.designpattern.creative.prototype;

import java.util.Date;

/**
 * 深拷贝示例
 * 创建原始类，实现Cloneable接口，重写clone方法（在其中进行一些操作）
 *
 * @author LYM
 */
public class Pig implements Cloneable
{
	private String name;
	private Date birthday;
	private boolean deepClone = false;

	public Pig(String name, Date birthday)
	{
		this.name = name;
		this.birthday = birthday;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public void setDeepClone(boolean deepClone)
	{
		this.deepClone = deepClone;
	}

	@Override
	public String toString()
	{
		return "Pig{" + "name='" + name + '\'' + ", birthday=" + birthday + ", deepClone=" + deepClone + '}';
	}

	/**
	 * 实现深克隆
	 *
	 * @return 深克隆一个对象
	 * @throws CloneNotSupportedException 克隆异常抛出
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		Pig pig = (Pig) super.clone();
		// 深克隆的关键
		if (deepClone) { pig.birthday = (Date) pig.birthday.clone(); }

		return pig;

	}

	/**
	 * 测试
	 *
	 * @param args 参数
	 */
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Date birthday = new Date(0L);
		Pig pig1 = new Pig("佩奇", birthday);

		/*
		下面打印的pig1和pig2是两个不同的对象，这一点毋庸置疑。
		但是，里面的Date类型的birthday如果没有经过深克隆，则克隆出来的birthday变量引用的是同一个对象。
		所以修改pig1的生日，pig2也会随之改变。
		 */
		Pig pig2 = (Pig) pig1.clone();

		System.out.println("原始数据以及克隆");
		System.out.println(pig1);
		System.out.println(pig2);
		System.out.println();

		// 改变pig1的生日
		System.out.println("改变pig1的生日");
		pig1.getBirthday().setTime(666666666666L);
		System.out.println(pig1);
		System.out.println(pig2);
		System.out.println();

		// 采取深克隆后，新克隆pig3，然后更改pig1的生日
		pig1.setDeepClone(true);
		Pig pig3 = (Pig) pig1.clone();

		System.out.println("深克隆pig3");
		System.out.println(pig3);

		pig1.getBirthday().setTime(777777777777L);
		System.out.println("再次改变pig1的生日");
		System.out.println(pig1);
		System.out.println(pig2);
		System.out.println(pig3);
	}
}
