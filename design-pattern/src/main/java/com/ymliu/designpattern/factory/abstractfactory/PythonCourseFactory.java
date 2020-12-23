package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 工厂类，python工厂
 *
 * @author LYM
 */
public class PythonCourseFactory implements BaseCourseFactory
{
	/**
	 * 获取一个视频
	 *
	 * @return 视频产品
	 */
	@Override
	public BaseVideo getVideo()
	{
		return new PythonVideo();
	}

	/**
	 * 获取一个笔记
	 *
	 * @return 笔记产品
	 */
	@Override
	public BaseNote getNote()
	{
		return new PythonNote();
	}
}
