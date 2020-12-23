package com.ymliu.designpattern.factory.simplefactory;

import java.lang.reflect.InvocationTargetException;

/**
 * 工厂类，根据不同参数创建不同具体类型的实例对象
 *
 * @author LYM
 */
public class VideoFactory
{
	/**
	 * 根据Class字节码对象去的的相应的对象
	 *
	 * @param c 字节码对象
	 * @return 相应的对象
	 */
	public BaseVideo getVideo(Class<?> c)
	{
		BaseVideo video = null;
		try
		{
			video = (BaseVideo) c.getDeclaredConstructor().newInstance();
		}
		catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return video;
	}

	/**
	 * 根据type类型去得到对应的对象
	 *
	 * @param type 类型
	 * @return 相应的对象
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
