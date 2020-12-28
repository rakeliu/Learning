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

import java.util.HashMap;
import java.util.Map;

/**
 * 员工工厂
 *
 * @author LYM
 */
public class EmployeeFactory
{
	/**
	 * 缓存区
	 */
	private static final Map<String, Employee> map = new HashMap<>(0);

	/**
	 * 根据部门获取部门经理
	 *
	 * @param department 部门
	 * @return 经理
	 */
	public static Employee getManager(String department)
	{
		Manager manager = (Manager) map.get(department);

		if (manager == null)
		{
			manager = new Manager(department);
			System.out.println("创建部门经理：" + department);

			String reportContent = department + "部门汇报：此次报告的主要内容是...";
			manager.setReportContent(reportContent);
			System.out.println("创建报告：" + reportContent);

			// 保存到map集合中
			map.put(department, manager);
		}
		return manager;
	}
}
