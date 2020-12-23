package com.ymliu.designpattern.factory.builderfactory;

/**
 * 建造者模式
 *
 * @author LYM
 */
public class BuilderFactory
{
	public static void main(String[] args)
	{
		SwordsMan man = SwordsMan.builder().setName("令狐冲").setAge(22).setKungFu("独孤九剑").build();
		System.out.println(man.toString());
	}
}
