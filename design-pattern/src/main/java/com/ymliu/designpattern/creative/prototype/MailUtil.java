/*
 * MIT License
 *
 * Copyright (c) 2020 Liu Yamin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ymliu.designpattern.creative.prototype;

import java.text.MessageFormat;

/**
 * 浅拷贝对应的工具类。
 *
 * @author LYM
 */
public class MailUtil
{
	public static void sendMail(Mail mail)
	{
		String outputContent = "向 {0} 同学，邮件地址:{1}，邮件内容:{2} 发送邮件成功。";
		System.out.println(MessageFormat.format(outputContent, mail.getName(), mail.getEmailAddress(), mail.getContent()));
	}

	public static void saveOriginMailRecord(Mail mail)
	{
		System.out.println("存储originMail记录，originMail: " + mail.getContent());
	}

	public static void main(String[] args) throws CloneNotSupportedException
	{
		/*
		 * 下面这个例子目的是：
		 * 创建一个Mail对象，然后保存初始化的内容，然后一个for循环，发送10份出去。
		 */

		Mail mail = new Mail();
		mail.setContent("初始化模板");
		System.out.println("初始化mail: " + mail);
		for (int i = 0; i < 10; i++)
		{
			// 根据原始的mail对象，去clone一个全新的mail对象，这个是用二进制流的方式复制，所以性能比较好
			// 目前这个是浅拷贝，并没有调用构造器，只是调用了clone方法，但是对象是新的
			Mail mailTmp = (Mail) mail.clone();

			mailTmp.setName("姓名" + i);
			mailTmp.setEmailAddress("姓名" + i + "@XXX.com");
			mailTmp.setContent("恭喜您，中奖了！ 500w !!!");

			MailUtil.sendMail(mailTmp);
			System.out.println("克隆的mailTmp: " + mailTmp);
		}

		// 假如现在的业务非常复杂，这个保存Mail对象需要放到后面
		// 保存原始的Mail对象
		MailUtil.saveOriginMailRecord(mail);
	}
}
