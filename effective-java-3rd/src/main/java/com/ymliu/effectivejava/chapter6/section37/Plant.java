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

package com.ymliu.effectivejava.chapter6.section37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * 植物
 *
 * @author LYM
 */
public class Plant
{
	public enum LifeCycle
	{
		/**
		 * 一年生，多年生……
		 */
		ANNUAL,
		PERENNIAL,
		BIENNIAL
	}

	final String name;
	final LifeCycle lifeCycle;

	public Plant(String name, LifeCycle lifeCycle)
	{
		this.name = name;
		this.lifeCycle = lifeCycle;
	}

	@Override
	public String toString()
	{
		return name;
	}

	/**
	 * Using ordinal() to index into an array - DON'T DO THIS!
	 */
	public static void iterateByOrdinal(Plant[] garden)
	{
		System.out.println("iterateByOrdinal");
		Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];

		for (int i = 0; i < plantsByLifeCycle.length; i++)
		{
			plantsByLifeCycle[i] = new HashSet<>();
		}

		for (Plant p : garden)
		{
			plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
		}

		// Print the results
		for (int i = 0; i < plantsByLifeCycle.length; i++)
		{
			System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
		}
	}

	/**
	 * Using an EnumMap to associate data with an enum
	 */
	public static void iterateByMap(Plant[] garden)
	{
		System.out.println("iterateByMap");
		Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);

		for (LifeCycle lc : LifeCycle.values())
		{
			plantsByLifeCycle.put(lc, new HashSet<>());
		}

		for (Plant p : garden)
		{
			plantsByLifeCycle.get(p.lifeCycle).add(p);
		}

		System.out.println(plantsByLifeCycle);
	}

	/**
	 * Using a stream and an EnumMap to associate data with an enum
	 */
	public static void iterateByStream(Plant[] garden)
	{
		System.out.println("groupingBy(lambda)");
		System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle)));

		System.out.println("groupingBy(lambda, lambda)");
		System.out.println(Arrays.stream(garden).collect(groupingBy(p->p.lifeCycle, ()->new EnumMap<>(LifeCycle.class), toSet())));
	}
}
