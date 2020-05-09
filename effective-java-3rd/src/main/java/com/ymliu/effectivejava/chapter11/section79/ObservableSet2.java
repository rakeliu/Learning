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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ymliu.effectivejava.chapter4.section18.ForwardingSet;

/**
 * @param <E>
 * @author LYM
 * @see ObservableSet1 , no synchonized with CopyOnWriteArrayList
 */
public class ObservableSet2<E> extends ForwardingSet<E> implements BaseObservableSet<E>
{
	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

	public ObservableSet2(Set<E> s) { super(s); }

	@Override
	public void addObserver(SetObserver<E> observer) { this.observers.add(observer);}

	@Override
	public boolean removeObserver(SetObserver<E> observer) { return this.observers.remove(observer); }

	@Override
	public void notifyElementAdded(E element)
	{
		for (SetObserver<E> observer : this.observers) {observer.added(this, element);}
	}

	@Override
	public boolean add(E e)
	{
		boolean added = super.add(e);
		if (added) {notifyElementAdded(e);}
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		boolean result = false;
		for (E element : c) {result |= add(element);}
		return result;
	}

	public static void test(String... args)
	{
		ObservableSet2<Integer> set = new ObservableSet2<>(new HashSet<>());

		set.addObserver(new SetObserver<>()
		{
			@Override
			public void added(BaseObservableSet<Integer> set, Integer element)
			{
				System.out.println("ObservableSet2: " + element);
				if (element == 25)
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
}
