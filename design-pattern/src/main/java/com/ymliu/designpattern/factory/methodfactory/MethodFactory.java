package com.ymliu.designpattern.factory.methodfactory;

import com.ymliu.designpattern.factory.methodfactory.JavaVideoFactory;
import com.ymliu.designpattern.factory.methodfactory.PythonVideoFactory;
import com.ymliu.designpattern.factory.methodfactory.VideoProduct;

/**
 * 方法工厂
 *
 * @author LYM
 */
public class MethodFactory
{
	public static void main(String[] args)
	{
		JavaVideoFactory javaVideoFactory = new JavaVideoFactory();
		VideoProduct video = javaVideoFactory.getVideo();
		video.produce();

		PythonVideoFactory pythonVideoFactory = new PythonVideoFactory();
		VideoProduct pythonVideo = pythonVideoFactory.getVideo();
		pythonVideo.produce();
	}
}
