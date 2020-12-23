package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 实现类，java视频
 *
 * @author LYM
 */
public class JavaVideo extends BaseVideo
{
	/**
	 * 输出视频
	 */
	@Override
	public void produce()
	{
		System.out.println("生产java课程视频");
	}
}
