package com.ymliu.designpattern.factory.builderfactory;

/**
 * 实现类，一个大侠，内含一个创造者
 *
 * @author LYM
 */
public class SwordsMan
{
	/**
	 * 姓名
	 */
	private final String name;
	/**
	 * 年龄
	 */
	private final int age;
	/**
	 * 功夫
	 */
	private final String kungFu;

	/**
	 * 通过构造者对属性赋值。
	 * 构造函数私有化，只让下面的静态方法builder能够创建对象。
	 *
	 * @param builder 构造者
	 */
	private SwordsMan(Builder builder)
	{
		this.name = builder.getName();
		this.age = builder.getAge();
		this.kungFu = builder.getKungFu();
	}

	/**
	 * 创建构造者。构造SwordsMan对象的构造器，就是通过Builder这个对象去构建的。
	 *
	 * @return 构造者
	 */
	public static Builder builder()
	{
		return new Builder();
	}

	/**
	 * 定义具体的构造器，定义名字、年龄、武功。
	 */
	public static class Builder
	{
		private String name;
		private int age;
		private String kungFu;

		public Builder setName(String name)
		{
			this.name = name;
			return this;
		}

		public Builder setAge(int age)
		{
			this.age = age;
			return this;
		}

		public Builder setKungFu(String kungFu)
		{
			this.kungFu = kungFu;
			return this;
		}

		public String getName()
		{
			return name;
		}

		public int getAge()
		{
			return age;
		}

		public String getKungFu()
		{
			return kungFu;
		}

		public SwordsMan build()
		{
			return new SwordsMan(this);
		}
	}

	@Override
	public String toString()
	{
		return "SwordsMan{" + "name='" + name + '\'' + ", age=" + age + ", kungFu='" + kungFu + '\'' + '}';
	}
}
