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

/**
 * Using ordinal() to index array of arrays - DON'T DO THIS!
 *
 * @author LYM
 */
public enum Phase
{
	/**
	 * 形态：固态、液态、气态
	 */
	SOLID,
	LIQUID,
	GAS;

	public enum Transition
	{
		/**
		 * 相变过程：融化、冰冻、沸腾...
		 */
		MELT,
		FREEZE,
		BOIL,
		CONDENSE,
		SUBLIME,
		DEPOSIT;

		/**
		 * Rows indexed by from-ordinal, cols by to ordinal
		 */
		private static final Transition[][] TRANSITIONS = {{null, MELT, SUBLIME}, {FREEZE, null, BOIL}, {DEPOSIT, CONDENSE, null}};

		/**
		 * Returns the phase transition from on phase to another
		 */
		public static Transition from(Phase from, Phase to)
		{
			return TRANSITIONS[from.ordinal()][to.ordinal()];
		}
	}
}
