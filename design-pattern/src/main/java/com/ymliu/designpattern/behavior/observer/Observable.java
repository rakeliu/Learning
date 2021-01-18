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

package com.ymliu.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建被观察者，我自己。
 *
 * @author LYM
 */
public class Observable
{
    private final List<Observer> observers = new ArrayList<>();

    /**
     * 添加一个观察者
     *
     * @param observer 新观察者（新女朋友）
     */
    public void attach(Observer observer)
    {
        observers.add(observer);
        System.out.println("我又新交了一个女朋友");
    }

    /**
     * 去掉一个观察者（分手一个）
     *
     * @param observer 已有的观察者
     */
    public void detach(Observer observer)
    {
        observers.remove(observer);
        System.out.println("我和她分手了");
    }

    /**
     * 通知观察者，所有的观察者
     *
     * @param state 通知内容
     */
    public void notifyObservers(String state)
    {
        for (Observer observer : observers)
        { observer.update(state); }
    }
}
