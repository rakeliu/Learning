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

package com.ymliu.effectivejava.chapter7.section46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * 流范式中，将计算结构化为一系列转换，每个阶段的结果尽可能接近前一阶段。
 * 过程中尽可能使用纯函数，结果仅取决于输入，不依赖任何可变状态，也不更新任何状态；
 * 传递给纯函数的任何对象（中间操作和终结操作）都应该没有副作用。
 *
 * @author LYM
 */
public class Section46
{
	/**
	 * Uses the streams API but not the paradigm -- Don't do this!
	 */
	public void example1(String file)
	{
		Map<String, Long> freq = new HashMap<>(16);
		try (Stream<String> words = new Scanner(file).tokens())
		{
			words.forEach(word -> {
				// 改变了freq内容
				freq.merge(word.toLowerCase(), 1L, Long::sum);
			});
		}

		// 如下代码直接获取到freq，不会发生改变
		try (Stream<String> words = new Scanner(file).tokens())
		{
			//freq = words.collect(groupingBy(String::toLowerCase, counting()));
		}

		// 继续使用，从频率表中提取频率前十的单词列表
		List<String> topTen = freq.keySet().stream()
				// 排序，比较器上进行翻转，由大到小
				.sorted(comparing(freq::get).reversed())
				// 限制前十
				.limit(10)
				// 收集List
				.collect(Collectors.toList());
	}

}
