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

package com.ymliu.effectivejava.chapter7.section45;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * 明智审慎地使用Stream.<br/>
 * 从字典文件中读取单词，并打印其大小（符合用户指定的最小值的所有变位词(anagram）组。<br/>
 * 如果两个单词长度相同，不同顺序的相同字母组成，则他们是变位词。<br/>
 * <br/>
 * 程序从指定的字典文件中读取每个单词，并将单词放入map对象中，键值按字母排序的单词，值是包含共享字母顺序形式的所有单词列表。
 * 处理完成后，每个列表都是一个完整的同位词组。然后便利map对象的values()打印列表。
 *
 * @author LYM
 */
public class Anagrams
{
	/**
	 * 常规方法。<br/>
	 * 将每个单词插入到map中使用了computeIfAbsent方法（Java8），该方法在map中查找一个键；<br/>
	 * 如果键值存在则返回与其关联的值；如果不存在，则通过给定函数对象(lambda)来计算，计算结果与键值关联，并返回计算值。<br/>
	 * 该方法简化了将多个值与每个键关联的map实现。
	 */
	public void example1(String[] args) throws IOException
	{
		File dictionary = new File(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);
		Map<String, Set<String>> groups = new HashMap<>(1024);
		try (Scanner s = new Scanner(dictionary))
		{
			while (s.hasNext())
			{
				String word = s.next();
				groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
			}
		}

		for (Set<String> group : groups.values())
		{
			if (group.size() >= minGroupSize)
			{
				System.out.printf("%d : %s%n", group.size(), group.toString());
			}
		}
	}

	/**
	 * 方法二，大量、过渡使用了流，没有使用私有函数alphabetize进行转换。
	 * Overuse of streams - don't do this!
	 */
	public void example2(String[] args) throws IOException
	{
		Path dictionary = Paths.get(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);
		try (Stream<String> words = Files.lines(dictionary))
		{
			words.collect(groupingBy(
					// 单词转化为字符数组，然后按字母排序
					word -> word.chars().sorted()
							//将字符数组通过StringBuilder组合成串，然后排序
							.collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append).toString()))
					// 转为流
					.values().stream()
					//过滤出需要的流
					.filter(group -> group.size() >= minGroupSize)
					// 流元素转换，将group转为可打印形式的 group.size() : group
					.map(group -> group.size() + " : " + group)
					// 每个map元素打印
					.forEach(System.out::println);
		}
	}

	/**
	 * 方法三，折中的流使用，不过渡使用流，使用alphabetize进行部分转换。
	 * 可读性高
	 */
	public void example3(String[] args) throws IOException
	{
		Path dictionary = Paths.get(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);

		try (Stream<String> words = Files.lines(dictionary))
		{
			words.collect(
					// 通过私有函数转对单词的字符进行重排，还是字符串
					groupingBy(this::alphabetize))
					// 后面差不多
					.values().stream()
					// 过滤出需要的流
					.filter(group -> group.size() >= minGroupSize)
					// 少一步stream.map转换，直接格式化打印每个元素
					.forEach(g -> System.out.println(g.size() + " : " + g));
			;
		}
	}

	private String alphabetize(String s)
	{
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}
