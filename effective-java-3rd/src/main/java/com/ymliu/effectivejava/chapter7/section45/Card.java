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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 一副牌
 *
 * @author LYM
 */
public class Card
{
	/**
	 * 花色
	 */
	enum Suit
	{
		/**
		 * 黑
		 */
		SPADE,
		/**
		 * 红
		 */
		HEARTS,
		/**
		 * 梅
		 */
		PLUMS,
		/**
		 * 方，钻石
		 */
		DIAMONDS;
	}

	enum Rank
	{
		/**
		 * 从A.2.3..J.Q.K
		 */
		ACE(1);

		private final int num;

		Rank(int num) {this.num = num;}


		@Override
		public String toString()
		{
			return String.valueOf(num);
		}
	}

	private final Suit suit;
	private final Rank rank;

	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString()
	{
		return suit + ":" + rank;
	}

	public static List<Card> newDeckLoop()
	{
		List<Card> result = new ArrayList<>(Suit.values().length * Rank.values().length);

		for (Suit suit : Suit.values())
		{
			for (Rank rank : Rank.values())
			{
				result.add(new Card(suit, rank));
			}
		}

		return result;
	}

	public static List<Card> newDeckStream()
	{
		return Stream.of(Suit.values())
				// 平面展开为stream
				.flatMap(suit -> Stream.of(Rank.values())
						// 映射过程中 new Card
						.map(rank -> new Card(suit, rank)))
				// 规约为List
				.collect(toList());
	}
}
