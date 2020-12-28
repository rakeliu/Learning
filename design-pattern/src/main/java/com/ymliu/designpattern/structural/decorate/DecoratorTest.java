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
 * 装饰模式，测试。
 *
 * @author LYM
 */
public class DecoratorTest
{
	/**
	 * 测试
	 *
	 * @param args 参数
	 */
	public static void main(String[] args)
	{
		AbstractBatterCake batterCake;
		// 一个煎饼
		batterCake = new BatterCake();
		// 加鸡蛋
		batterCake = new EggDecorator(batterCake);
		// 再加一个鸡蛋
		batterCake = new EggDecorator(batterCake);
		// 加烤肠
		batterCake = new SausageDecorator(batterCake);

		/*
		输出：8+1+1+2=12，煎饼加一个鸡蛋加一个鸡蛋加一个烤肠 销售价格：12
		 */
		System.out.println(batterCake.getDesc() + " 销售价格: " + batterCake.cost());

		/*
		另一种写法，连续写，输出结果：
		煎饼加一个鸡蛋加一个烤肠加一个烤肠 销售价格13
		 */
		SausageDecorator sausageDecorator = new SausageDecorator(new SausageDecorator(new EggDecorator(new BatterCake())));
		System.out.println(sausageDecorator.getDesc() + " 销售价格: " + sausageDecorator.cost());
	}
}
