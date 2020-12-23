package com.ymliu.designpattern.factory.methodfactory;

/**
 * 生产 python video
 *
 * @author LYM
 */
public class PythonVideo extends VideoProduct
{
	/**
	 * 输出生产结果。
	 */
	@Override
	public void produce()
	{
		System.out.println("录制python课程视频");
	}
}
