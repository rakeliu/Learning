package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 实现类，java笔记
 *
 * @author LYM
 */
public class JavaNote extends BaseNote
{
	/**
	 * 输出笔记
	 */
	@Override
	public void produce()
	{
		System.out.println("编写java课程笔记");
	}
}
