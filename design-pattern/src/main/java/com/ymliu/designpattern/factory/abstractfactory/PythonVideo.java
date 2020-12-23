package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 实现类，python视频
 *
 * @author LYM
 */
public class PythonVideo extends BaseVideo
{
	/**
	 * 输出视频
	 */
	@Override
	public void produce()
	{
		System.out.println("生产python课程视频");
	}
}
