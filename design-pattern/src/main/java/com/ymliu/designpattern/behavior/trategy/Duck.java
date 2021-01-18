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

package com.ymliu.designpattern.behavior.trategy;

/**
 * 鸭子父类，抽象类。
 *
 * @author LYM
 */
public abstract class Duck
{
    /**
     * 接口，让子类去实现这个接口。
     */
    FlyBehaviour flyBehaviour;

    /**
     * 飞行这个动作，由接口去具体实现。
     */
    public void fly()
    {
        this.flyBehaviour.fly();
    }

    /**
     * 输出一个类名称显示。
     */
    public abstract void display();

    /**
     * 设置可以飞行的行为接口实现类
     *
     * @param flyImp 可以飞
     */
    public void setFlyBehaviour(FlyImpl flyImp)
    {
        this.flyBehaviour = flyImp;
    }

    /**
     * 设置不可以飞行的行为接口实现类。
     *
     * @param flayNoWayBehaviour 不可以飞行
     */
    public void setFlayNoWayBehaviour(FlyNoWayImp flayNoWayBehaviour)
    {
        this.flyBehaviour = flayNoWayBehaviour;
    }
}
