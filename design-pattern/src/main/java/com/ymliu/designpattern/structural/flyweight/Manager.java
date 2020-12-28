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

package com.ymliu.designpattern.structural.flyweight;

/**
 * 创建经理，也属于员工
 *
 * @author LYM
 */
public class Manager implements Employee
{
	/**
	 * 所属部门
	 */
	private String department;
	/**
	 * 报告内容
	 */
	private String reportContent;

	/**
	 * 带参数构造函数，指定部门
	 *
	 * @param department 所属部门
	 */
	public Manager(String department)
	{
		this.department = department;
	}

	/**
	 * 做报告
	 */
	@Override
	public void report()
	{
		System.out.println(this.reportContent);
	}

	/**
	 * 设置报告内容
	 *
	 * @param reportContent 报告内容
	 */
	public void setReportContent(String reportContent)
	{
		this.reportContent = reportContent;
	}
}
