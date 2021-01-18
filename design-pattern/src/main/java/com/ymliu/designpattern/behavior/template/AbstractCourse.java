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

package com.ymliu.designpattern.behavior.template;

/**
 * 抽象课程类，包含模板及子类的钩子。
 *
 * @author LYM
 */
public abstract class AbstractCourse
{
    /**
     * 模板方法，制作课程。
     */
    protected final void makeCourse()
    {
        this.makePpt();
        this.makeVideo();
        if (this.needWriteArticle())
        {
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePpt()
    {
        System.out.println("制作PPT");
    }

    final void makeVideo()
    {
        System.out.println("制作视频");
    }

    final void writeArticle()
    {
        System.out.println("编写手记");
    }

    /**
     * 钩子方法，子类覆盖。
     *
     * @return boolean
     */
    protected boolean needWriteArticle()
    {
        return false;
    }

    /**
     * 包装课程
     */
    abstract void packageCourse();
}
