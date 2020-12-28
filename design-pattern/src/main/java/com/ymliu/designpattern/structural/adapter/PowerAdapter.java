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

package com.ymliu.designpattern.structural.adapter;

/**
 * 创建适配器
 *
 * @author LYM
 */
public class PowerAdapter implements DirectCurrent5
{
	private final AlternatingCurrent220 ac220 = new AlternatingCurrent220();

	/**
	 * 输出 DC 5V
	 *
	 * @return 5
	 */
	@Override
	public int outputDirectCurrent5V()
	{
		int adapterInput = ac220.output220V();

		// 模拟变压器
		int adapterOutput = adapterInput / 44;

		System.out.println("使用PowerAdapter输入" + ac220.mode() + adapterInput + "V, 输出 DC" + adapterOutput + "V");
		return adapterOutput;
	}
}
