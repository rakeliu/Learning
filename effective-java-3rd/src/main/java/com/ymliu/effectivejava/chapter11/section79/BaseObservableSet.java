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

package com.ymliu.effectivejava.chapter11.section79;

import java.util.Set;

/**
 * 因为有两种不同的用法，抽象接口。
 *
 * @param <E> 泛型
 * @author LYM
 */
public interface BaseObservableSet<E> extends Set<E>
{
	/**
	 * 添加一个观察者
	 *
	 * @param observer 观察者
	 */
	void addObserver(SetObserver<E> observer);

	/**
	 * 移除一个观察者
	 *
	 * @param observer 观察者
	 * @return 移除成功标志
	 */
	boolean removeObserver(SetObserver<E> observer);

	/**
	 * 提示观察者添加元素
	 *
	 * @param element 元素
	 */
	void notifyElementAdded(E element);
}
