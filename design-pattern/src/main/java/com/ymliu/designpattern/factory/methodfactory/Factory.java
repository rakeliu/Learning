package com.ymliu.designpattern.factory.methodfactory;

/**
 * 工厂公共接口
 *
 * @author LYM
 */
public interface Factory
{
	/**
	 * 生产一个 VideoProduct
	 *
	 * @return VideoProduct
	 */
	VideoProduct getVideo();
}
