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
 *
 */

package com.ymliu.effectivejava.chapter11.section81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * 并发工具优于wait和notify
 *
 * @author LYM
 */
public class Section81
{
	public static long time(Executor executor, int concureency, Runnable action) throws InterruptedException
	{
		CountDownLatch ready = new CountDownLatch(concureency);
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch done = new CountDownLatch(concureency);
		for (int i = 0; i < concureency; i++)
		{
			executor.execute(() -> {
				ready.countDown();
				// Tell timer we're ready
				try
				{
					start.await();
					// Wait till peers are ready
					action.run();
				}
				catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
				finally
				{
					done.countDown();
				}
			});
		}
		ready.await();
		// Wait for all workers to be ready
		long startNanos = System.nanoTime();
		start.countDown();
		// And they're off!
		done.await();
		// Wait for all workers to finish
		return System.nanoTime() - startNanos;
	}
}
