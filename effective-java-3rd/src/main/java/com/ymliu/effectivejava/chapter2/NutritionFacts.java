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

package com.ymliu.effectivejava.chapter2;

/**
 * Build pattern
 */
public class NutritionFacts
{
	private final int servingSize;  // (mL) required
	private final int servings;     // (per container) required
	private final int calories;     // (per serving) optional
	private final int fat;          // (g/serving) optional
	private final int sodium;       // (mg/serving) optional
	private final int carbohydrate; // (g/serving) optional

	public static class Builder
	{
		// Required parameters
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		public Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder fat(int val)
		{
			this.fat = val;
			return this;
		}

		public Builder calories(int val)
		{
			this.calories = val;
			return this;
		}

		public Builder sodium(int val)
		{
			this.sodium = val;
			return this;
		}

		public Builder carbohydrate(int val)
		{
			this.carbohydrate = val;
			return this;
		}

		public NutritionFacts build()
		{
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder)
	{
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}

	@Override
	public String toString()
	{
		return "NutritionFacts{" + "servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + '}';
	}
}
