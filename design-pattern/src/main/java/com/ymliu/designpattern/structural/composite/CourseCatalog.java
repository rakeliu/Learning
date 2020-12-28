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

package com.ymliu.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建目录，继承于抽象目录类
 *
 * @author LYM
 */
public class CourseCatalog extends CatalogComponent
{
	/**
	 * 子目录、课程集合
	 */
	private final List<CatalogComponent> items = new ArrayList<>(0);

	private final String name;
	private final Integer level;

	public CourseCatalog(String name, Integer level)
	{
		this.name = name;
		this.level = level;
	}

	@Override
	public void add(CatalogComponent catalogComponent)
	{
		items.add(catalogComponent);
	}

	@Override
	public String getName(CatalogComponent catalogComponent)
	{
		return this.name;
	}

	@Override
	public void remove(CatalogComponent catalogComponent)
	{
		items.remove(catalogComponent);
	}

	@Override
	public void print()
	{
		System.out.println(this.name);
		for (CatalogComponent catalogComponent : items)
		{
			if (this.level != null)
			{
				for (int i = 0; i < this.level; i++)
				{
					System.out.print("  ");
				}
			}
			catalogComponent.print();
		}
	}
}
