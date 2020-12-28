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
 * 创建抽象的装饰类，集成抽象的实体类（抽象的煎饼）
 *
 * @author LYM
 */
public abstract class AbstractDecorator extends AbstractBatterCake
{
	/**
	 * 抽象的煎饼，当然也可以传入具体的煎饼
	 * 一般都采用final，也可不使用final。
	 */
	private final AbstractBatterCake batterCake;

	/**
	 * 重新定义构造函数，必须传入一个抽象的煎饼（具体的煎饼），以备后面进行装饰
	 *
	 * @param batterCake 煎饼
	 */
	public AbstractDecorator(AbstractBatterCake batterCake)
	{
		this.batterCake = batterCake;
	}

	/**
	 * 描述，新增装饰
	 *
	 * @return string
	 */
	@Override
	public String getDesc()
	{
		return this.batterCake.getDesc();
	}

	/**
	 * 价值，新增装饰
	 *
	 * @return integer
	 */
	@Override
	public int cost()
	{
		return this.batterCake.cost();
	}
}
