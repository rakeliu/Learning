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
 * 更新的薪资算法，加入节假日区分。
 *
 * @author LYM
 */

public enum PayrollDay2
{
	/**
	 * Days of week
	 */
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND);

	private final PayType payType;

	/**
	 * Default - 默认工作日
	 */
	PayrollDay2() {this(PayType.WEEKDAY);}

	PayrollDay2(PayType payType) {this.payType = payType;}

	int pay(int minutesWorked, int payRate)
	{
		return payType.pay(minutesWorked, payRate);
	}

	/**
	 * 加班工资类型
	 */
	private enum PayType
	{
		/**
		 * 工作日
		 */
		WEEKDAY
				{
					@Override
					int overtimePay(int mins, int payRate)
					{
						return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
					}
				},
		/**
		 * 周末
		 */
		WEEKEND
				{
					@Override
					int overtimePay(int mins, int payRate)
					{
						return mins * payRate / 2;
					}
				};

		private static final int MINS_PER_SHIFT = 8 * 60;

		/**
		 * 加班费计算
		 *
		 * @param mins    当日工作时长（分钟）
		 * @param payRate 薪资水平
		 * @return 加班工资
		 */
		abstract int overtimePay(int mins, int payRate);

		int pay(int minsWorked, int payRate)
		{
			int basePay = minsWorked * payRate;
			return basePay + overtimePay(minsWorked, payRate);
		}
	}
}
