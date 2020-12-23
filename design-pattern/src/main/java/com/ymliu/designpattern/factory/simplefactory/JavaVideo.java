package com.ymliu.designpattern.factory.simplefactory;

/**
 * 具体产品类型 JAVA
 *
 * @author ymliu
 */
public class JavaVideo extends BaseVideo
{
	/**
	 * 生产JAVA
	 */
	@Override
	public void produce()
	{
		System.out.println("生产 JavaVideo");
	}
}
