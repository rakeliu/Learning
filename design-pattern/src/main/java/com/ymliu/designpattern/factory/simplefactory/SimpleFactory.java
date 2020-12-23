package com.ymliu.designpattern.factory.simplefactory;

import com.ymliu.designpattern.factory.simplefactory.BaseVideo;
import com.ymliu.designpattern.factory.simplefactory.JavaVideo;
import com.ymliu.designpattern.factory.simplefactory.VideoFactory;

/**
 * 简单工厂测试
 * @author  LYM
 */
public class SimpleFactory
{
	public static void main(String[] args)
	{
		VideoFactory videoFactory = new VideoFactory();

		BaseVideo javaVideo = videoFactory.getVideo(JavaVideo.class);
		javaVideo.produce();

		BaseVideo pythonVideo = videoFactory.getVideo("python");
		pythonVideo.produce();
	}
}
