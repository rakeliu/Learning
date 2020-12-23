package com.ymliu.designpattern.factory.methodfactory;

/**
 * 生产一个 python video factory
 *
 * @author LYM
 */
public class PythonVideoFactory implements Factory
{
	/**
	 * 生产一个 VideoProduct
	 *
	 * @return VideoProduct
	 */
	@Override
	public VideoProduct getVideo()
	{
		return new PythonVideo();
	}
}
