package com.ymliu.designpattern.factory.methodfactory;

/**
 * 生产 java video
 *
 * @author LYM
 */
public class JavaVideo extends VideoProduct
{
	/**
	 * 输出生产结果。
	 */
	@Override
	public void produce()
	{
		System.out.println("录制java课程视频");
	}
}
