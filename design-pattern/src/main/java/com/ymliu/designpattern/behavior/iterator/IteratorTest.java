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

/**
 * 迭代器模式，测试
 *
 * @author LYM
 */
public class IteratorTest
{
    public static void main(String[] args)
    {
        // 创建3个课程
        Course course1 = new Course("Java 基础");
        Course course2 = new Course("Android 基础");
        Course course3 = new Course("Java 设计模式");

        // 3个课程添加到课程集合类中
        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.addCourse(course1);
        courseAggregate.addCourse(course2);
        courseAggregate.addCourse(course3);

        System.out.println("--- 课程列表 ---");
        printCourses(courseAggregate);
        // 删除课程3（JAVA涉及模式）
        courseAggregate.removeCourse(course3);
        System.out.println("--- 删除操作之后再打印课程列表 ---");
        printCourses(courseAggregate);
    }

    /**
     * 迭代打印
     *
     * @param courseAggregate 需要迭代的内容
     */
    private static void printCourses(CourseAggregate courseAggregate)
    {
        CourseIterator courseIterator = courseAggregate.getCourseIterator();
        while (!courseIterator.isLastCourse())
        {
            Course course = courseIterator.nextCourse();
            System.out.println(course.getName());
        }
    }
}
