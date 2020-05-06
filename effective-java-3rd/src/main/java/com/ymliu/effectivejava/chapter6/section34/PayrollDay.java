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
 *
 */

package com.ymliu.effectivejava.chapter6.section34;

/**
 * Enum that switches on its value to share code - questionable
 * 计算每日薪水
 *
 * @author LYM
 */

public enum PayrollDay
{
	/**
	 * Days of week
	 */
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;

	/**
	 * 每天8小时*60分钟
	 */
	private static final int MINS_PER_SHIFT = 8 * 60;

	/**
	 * 根据基本工资（每小时）和当天工作分钟数计算当天工资。
	 * 在五个工作日内，任何超过正常工作时间的工作都会产生加班费；在两个周末日子里，所有工作都会产生加班费。
	 * 加班费是基本工资的1.5倍，即增加0.5倍。
	 * 只能区分工作日和周末，如果新增加班费策略（如假日），则无法。
	 *
	 * @param minutesWorked 工作分钟数
	 * @param payRate       薪资水平
	 * @return 当天工资
	 */
	int pay(int minutesWorked, int payRate)
	{
		// 基本工资
		int basePay = minutesWorked * payRate;

		// 加班工资（超额的部分）
		int overtimePay;
		switch (this)
		{
			case SATURDAY, SUNDAY:
				// Weekend, half pay
				overtimePay = basePay / 2;
				break;
			default:
				// Weekday
				overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
		}

		// 基本工资 + 加班工资
		return basePay + overtimePay;
	}
}
