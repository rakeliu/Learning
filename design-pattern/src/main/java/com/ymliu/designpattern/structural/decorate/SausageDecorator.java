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

package com.ymliu.designpattern.structural.decorate;

/**
 * 具体装饰类（烤肠装饰类），集成抽象的装饰。
 *
 * @author LYM
 */
public class SausageDecorator extends AbstractDecorator
{
	/**
	 * 重新定义构造函数，必须传入一个抽象的煎饼（具体的煎饼），以备后面进行装饰
	 *
	 * @param batterCake 煎饼
	 */
	public SausageDecorator(AbstractBatterCake batterCake)
	{
		super(batterCake);
	}


	/**
	 * 描述，新增装饰:“加一个烤肠”
	 *
	 * @return string
	 */
	@Override
	public String getDesc()
	{
		return super.getDesc() + " 加一个烤肠";
	}

	/**
	 * 价值，新增装饰：+2
	 *
	 * @return integer
	 */
	@Override
	public int cost()
	{
		return super.cost() + 2;
	}
}
