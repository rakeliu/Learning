package com.ymliu.designpattern.factory.abstractfactory;

/**
 * 抽象工厂模式
 *
 * @author LYM
 */
public class AbstractFactory
{
	public static void main(String[] args)
	{
		// 通过JavaCourseFactory创建java产品
		BaseCourseFactory javaCourseFactory = new JavaCourseFactory();
		javaCourseFactory.getVideo().produce();
		javaCourseFactory.getNote().produce();

		// 通过PythonCourseFactory创建python产品
		BaseCourseFactory pythonCourseFactory = new PythonCourseFactory();
		pythonCourseFactory.getVideo().produce();
		pythonCourseFactory.getNote().produce();
	}
}
