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

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * Using a nested EnumMap to associate data with enum pairs
 *
 * @author LYM
 */
public enum Phase2
{
	/**
	 * 状态：固态、液态、气态、等离子态
	 */
	SOLID,
	LIQUID,
	GAS,
	PLASMA;

	/**
	 * 转换过程
	 */
	public enum Transition
	{
		/**
		 * 融化：从固态到液态
		 */
		MELT(SOLID, LIQUID),
		FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS),
		CONDENSE(GAS, LIQUID),
		SUBLIME(SOLID, GAS),
		DEPOSIT(GAS, SOLID),
		/**
		 * 电离：从气态到等离子态
		 */
		IONIZE(GAS, PLASMA),
		DEIONIZE(PLASMA, GAS);

		private final Phase2 from;
		private final Phase2 to;

		Transition(Phase2 from, Phase2 to)
		{
			this.from = from;
			this.to = to;
		}

		private static final Map<Phase2, Map<Phase2, Transition>> m = Stream.of(values()).collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase2.class), toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase2.class))));

		public static Transition from(Phase2 from, Phase2 to)
		{
			return m.get(from).get(to);
		}
	}
}
