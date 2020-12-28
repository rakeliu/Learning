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

package com.ymliu.springcloud.zuul;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 服务过滤
 *
 * @author LYM
 * @version 1.0
 * 2020-3-10
 */
@Component
public class MyFilter extends ZuulFilter
{
	private static final Logger logger = LogManager.getLogger(MyFilter.class);

	@Override
	public String filterType()
	{
		return "pre";
	}

	@Override
	public int filterOrder()
	{
		return 0;
	}

	@Override
	public boolean shouldFilter()
	{
		return true;
	}

	@Override
	public Object run() throws ZuulException
	{
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info("{} >> {}", request.getMethod(), request.getRequestURL().toString());
		Object accessToken = request.getParameter("token");
		if (accessToken == null)
		{
			logger.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try
			{
				ctx.getResponse().getWriter().write("token is empty");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return null;
		}

		logger.info("ok");
		return null;
	}
}
