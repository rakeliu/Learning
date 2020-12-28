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

package com.ymliu.designpattern.structural.composite;

/**
 * 目录抽象类
 *
 * @author LYM
 */
public abstract class CatalogComponent
{
	/**
	 * 添加一个目录
	 *
	 * @param catalogComponent 抽象目录
	 */
	public void add(CatalogComponent catalogComponent)
	{
		throw new UnsupportedOperationException("不支持添加操作");
	}

	/**
	 * 删除一个目录
	 *
	 * @param catalogComponent 抽象目录
	 */
	public void remove(CatalogComponent catalogComponent)
	{
		throw new UnsupportedOperationException("不支持删除操作");
	}

	/**
	 * 获取目录名
	 *
	 * @param catalogComponent 抽象目录
	 * @return 目录名
	 */
	public String getName(CatalogComponent catalogComponent)
	{
		throw new UnsupportedOperationException("不支持获取名称操作");
	}

	/**
	 * 获取价格
	 *
	 * @param catalogComponent 抽象目录
	 * @return 价格
	 */
	public double getPrice(CatalogComponent catalogComponent)
	{
		throw new UnsupportedOperationException("不支持获取价格操作");
	}

	/**
	 * 打印当前目录内容
	 */
	public void print()
	{
		throw new UnsupportedOperationException("不支持打印操作");
	}
}
