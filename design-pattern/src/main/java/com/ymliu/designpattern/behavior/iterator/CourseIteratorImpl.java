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

package com.ymliu.designpattern.behavior.iterator;

import java.util.List;

/**
 * 课程迭代器 - 实现类
 *
 * @author LYM
 */
public class CourseIteratorImpl implements CourseIterator
{
    private List<Course> courseList;
    private int position;
    public Course course;

    public CourseIteratorImpl(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    /**
     * 获取下一个课程
     *
     * @return 课程
     */
    @Override
    public Course nextCourse()
    {
        System.out.println("返回课程，位置是：" + position);

        course = courseList.get(position);
        position++;

        return course;
    }

    /**
     * 是否最后一个课程
     *
     * @return 是否
     */
    @Override
    public boolean isLastCourse()
    {
        return position >= courseList.size();
    }
}
