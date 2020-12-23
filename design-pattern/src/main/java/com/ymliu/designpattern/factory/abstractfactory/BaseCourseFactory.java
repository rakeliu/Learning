package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 抽象工厂接口
 *
 * @author LYM
 */
public interface BaseCourseFactory
{
	/**
	 * 获取一个视频
	 *
	 * @return 视频产品
	 */
	BaseVideo getVideo();

	/**
	 * 获取一个笔记
	 *
	 * @return 笔记产品
	 */
	BaseNote getNote();
}
