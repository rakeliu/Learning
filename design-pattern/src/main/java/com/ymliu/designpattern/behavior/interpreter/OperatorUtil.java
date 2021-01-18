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

package com.ymliu.designpattern.behavior.interpreter;

/**
 * 工具类。
 * 判断输入是否运算符，并根据运算符进行计算。
 *
 * @author LYM
 */
public class OperatorUtil
{
    /**
     * 判断是否运算符，仅限 加法 和 乘法。
     *
     * @param symbol 输入
     * @return 是否
     */
    public static boolean isOperator(String symbol)
    {
        return ("+".equals(symbol) || "*".equals(symbol));
    }

    /**
     * 执行运算符的运算，即执行解释后结果
     *
     * @param firstExpression  第一个解释器
     * @param secondExpression 第二个解释器
     * @param symbol           运算符
     * @return 一个解释器，结果。
     */
    public static Interpreter getExpressionObject(Interpreter firstExpression, Interpreter secondExpression, String symbol)
    {
        if ("+".equals(symbol))
        {
            return new AddInterpreter(firstExpression, secondExpression);
        }
        else if ("*".equals(symbol))
        {
            return new MultiInterpreter(firstExpression, secondExpression);
        }

        return null;
    }
}
