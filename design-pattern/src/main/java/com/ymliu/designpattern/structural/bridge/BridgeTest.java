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

package com.ymliu.designpattern.structural.bridge;

/**
 * 桥接模式，测试。
 *
 * @author LYM
 */
public class BridgeTest
{
    public static void main(String[] args)
    {
        // 工行，然后账号类型是 定期
        AbstractBank icbcBank = new ICBCBank(new DepositAccount());
        BaseAccount icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();

        // 工行，活期
        AbstractBank icbcBank2 = new ICBCBank(new SavingAccount());
        BaseAccount icbcAccount2 = icbcAccount.openAccount();
        icbcAccount2.showAccountType();

        // 农行 活期
        AbstractBank abcBank = new ABCBank(new SavingAccount());
        BaseAccount abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();
    }
}
