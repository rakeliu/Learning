package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 实现类，python笔记
 *
 * @author LYM
 */
public class PythonNote extends BaseNote
{
	/**
	 * 输出笔记
	 */
	@Override
	public void produce()
	{
		System.out.println("编写python课程笔记");
	}
}
