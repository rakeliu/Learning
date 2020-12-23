package com.ymliu.designpattern.factory.simplefactory;

/**
 * 具体生产类 PYTHON
 * @author LYM
 */
public class PythonVideo extends BaseVideo
{
	/**
	 * 生产PYTHON。
	 */
	@Override
	public void produce()
	{
		System.out.println("生产 PythonVideo");
	}
}
