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

package com.ymliu.designpattern.structural.composite;

/**
 * 组合模式 测试
 *
 * @author LYM
 */
public class CatalogTest
{
	public static void main(String[] args)
	{
		// 二级目录
		CatalogComponent operationSystem = new CourseCatalog("操作系统课程目录", 2);
		CatalogComponent linuxCourse = new Course("Linux课程", 120);
		CatalogComponent windowsCourse = new Course("Windows课程", 50);
		operationSystem.add(linuxCourse);
		operationSystem.add(windowsCourse);

		// 二级目录
		CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录", 2);
		CatalogComponent javaBase = new Course("Java基础", 66);
		CatalogComponent designPattern = new Course("Java设计模式", 77);
		CatalogComponent refactory = new Course("重构", 88);
		javaCourseCatalog.add(javaBase);
		javaCourseCatalog.add(designPattern);
		javaCourseCatalog.add(refactory);

		// 一级目录（主目录）
		CatalogComponent mainCourseCatalog = new CourseCatalog("课程主目录", 1);
		mainCourseCatalog.add(linuxCourse);
		mainCourseCatalog.add(windowsCourse);
		mainCourseCatalog.add(javaCourseCatalog);
		mainCourseCatalog.print();
	}
}
