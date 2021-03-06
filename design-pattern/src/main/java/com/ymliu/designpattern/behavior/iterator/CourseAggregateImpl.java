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

import java.util.ArrayList;
import java.util.List;

/**
 * 课程集合 - 实现类
 *
 * @author LYM
 */
public class CourseAggregateImpl implements CourseAggregate
{
    private List<Course> courseList;

    public CourseAggregateImpl()
    {
        this.courseList = new ArrayList<>(0);
    }

    /**
     * 添加课程
     *
     * @param course 课程
     */
    @Override
    public void addCourse(Course course)
    {
        courseList.add(course);
    }

    /**
     * 删除课程
     *
     * @param course 课程
     */
    @Override
    public void removeCourse(Course course)
    {
        courseList.remove(course);
    }

    /**
     * 课程迭代器
     *
     * @return 迭代器
     */
    @Override
    public CourseIterator getCourseIterator()
    {
        return new CourseIteratorImpl(courseList);
    }
}
