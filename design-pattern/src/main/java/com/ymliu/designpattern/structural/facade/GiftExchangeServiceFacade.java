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

package com.ymliu.designpattern.structural.facade;

/**
 * 创建外观/门面类，统一管理3个子系统
 *
 * @author LYM
 */
public class GiftExchangeServiceFacade
{
	/**
	 * 资格兑换子系统
	 */
	private QualifyService qualifyService = new QualifyService();
	/**
	 * 积分支付子系统
	 */
	private PointPaymentService pointPaymentService = new PointPaymentService();
	/**
	 * 物流子系统
	 */
	private LogisticsService logisticsService = new LogisticsService();

	public void giftExchange(PointGift pointGift)
	{
		if (qualifyService.isAvailable(pointGift))
		{
			// 资格验证通过
			if (pointPaymentService.pay((pointGift)))
			{
				// 积分支付成功
				String shippingOrderNo = logisticsService.shipGift(pointGift);
				System.out.println("物流系统下单成功，订单号：" + shippingOrderNo);
			}
		}
	}
}
