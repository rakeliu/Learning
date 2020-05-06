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

package com.ymliu.effectivejava.chapter2.section08;

import java.lang.ref.Cleaner;

/**
 * @author LYM
 */
public class Room implements AutoCloseable
{
	private static final Cleaner cleaner = Cleaner.create();
	// The state of this room, shared with our cleanable
	private final State state;
	// Our cleanable. Cleans the room when it's eligible for gc
	private final Cleaner.Cleanable cleanable;

	public Room(int numJunkPiles)
	{
		this.state = new State(numJunkPiles);
		this.cleanable = cleaner.register(this, state);
	}

	@Override
	public void close() throws Exception
	{
		this.cleanable.clean();
	}

	/**
	 * Resource that requires cleaning. Must not refer to Room!
	 *
	 * @author LYM
	 */
	private static class State implements Runnable
	{
		// Number of junk piles in this room
		int numJunkPiles;

		State(int numJunkPiles) {this.numJunkPiles = numJunkPiles;}

		// Invoked by close method or cleaner
		@Override
		public void run()
		{
			System.out.println("Cleaning room");
			numJunkPiles = 0;
		}
	}
}
