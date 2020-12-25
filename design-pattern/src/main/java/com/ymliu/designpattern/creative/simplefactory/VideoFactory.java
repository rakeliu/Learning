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

package com.ymliu.designpattern.creative.simplefactory;

import java.lang.reflect.InvocationTargetException;

/**
 * 工厂类，根据不同参数生产不同产品实例。
 *
 * @author LYM
 */
public class VideoFactory
{
	/**
	 * 根据Class字节码对象去创建对应的对象实例
	 *
	 * @param c 字节码参数
	 * @return 实例产品
	 */
	public BaseVideo getVideo(Class<? extends BaseVideo> c)
	{
		BaseVideo video = null;
		try
		{
			video = (BaseVideo) Class.forName(c.getName()).getDeclaredConstructor().newInstance();
		}
		catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return video;
	}

	/**
	 * 根据type类型去创建
	 *
	 * @param type 类型
	 * @return 产品实例
	 */
	public BaseVideo getVideo(String type)
	{
		if ("java".equalsIgnoreCase(type))
		{
			return new JavaVideo();
		}
		else if ("python".equalsIgnoreCase(type))
		{
			return new PythonVideo();
		}

		return null;
	}
}
