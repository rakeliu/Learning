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

/**
 * 测试类
 *
 * @author LYM
 */
public class ObserverTest
{
    public static void main(String[] args)
    {
        // 创建 2 个观察者
        Observer ob1 = new GirlFriendObserver("女朋友一");
        Observer ob2 = new GirlFriendObserver("女朋友二");

        // 创建被观察者
        MessageObservable messageSubject = new MessageObservable();

        // 被观察者 添加 观察者 到集合中
        messageSubject.attach(ob1);
        messageSubject.attach(ob2);

        // 被观察者 通知 观察者，我都在干什么
        messageSubject.change("我在大宝剑");

        messageSubject.detach(ob2);
        messageSubject.notifyObservers("泡吧");
    }
}
