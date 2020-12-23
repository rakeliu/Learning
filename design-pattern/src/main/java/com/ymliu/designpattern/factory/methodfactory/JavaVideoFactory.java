package com.ymliu.designpattern.factory.methodfactory;

/**
 * 生产一个java video factory
 *
 * @author LYM
 */
public class JavaVideoFactory implements Factory
{
	/**
	 * 生产一个 VideoProduct
	 *
	 * @return VideoProduct
	 */
	@Override
	public VideoProduct getVideo()
	{
		return new JavaVideo();
	}
}
