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

package com.ymliu.effectivejava.chapter11.section79;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ymliu.effectivejava.chapter4.section18.ForwardingSet;

/**
 * Broken - invokes alien method from synchronized block !
 *
 * @author LYM
 */
public class ObservableSet1<E> extends ForwardingSet<E> implements BaseObservableSet<E>
{
	private final List<SetObserver<E>> observers = new ArrayList<>();

	public ObservableSet1(Set<E> s) { super(s); }

	public static void test(String... args)
	{
		ObservableSet1<Integer> set = new ObservableSet1<>(new HashSet<>());
		set.addObserver((s, e) -> System.out.println(e));

		set.addObserver(new SetObserver<>()
		{
			@Override
			public void added(BaseObservableSet<Integer> set, Integer element)
			{
				System.out.println(element);
				if (element == 23)
				{
					ExecutorService exec = Executors.newSingleThreadExecutor();
					try
					{
						exec.submit(() -> set.removeObserver(this)).get();
					}
					catch (ExecutionException | InterruptedException ex)
					{
						throw new AssertionError(ex);
					}
					finally
					{
						exec.shutdown();
					}
				}
			}
		});

		for (int i = 0; i < 100; i++) {set.add(i);}
	}

	@Override
	public void addObserver(SetObserver<E> observer)
	{
		synchronized (observers) {observers.add(observer);}
	}

	@Override
	public boolean removeObserver(SetObserver<E> observer)
	{
		synchronized (observers) { return observers.remove(observer); }
	}

	@Override
	public void notifyElementAdded(E element)
	{
		synchronized (observers)
		{
			for (SetObserver<E> observer : observers)
			{
				observer.added(this, element);
			}
		}
	}

	@Override
	public boolean add(E e)
	{
		boolean added = super.add(e);
		if (added) { notifyElementAdded(e); }
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		boolean result = false;
		for (E element : c) { result |= add(element); }
		return result;
	}
}
