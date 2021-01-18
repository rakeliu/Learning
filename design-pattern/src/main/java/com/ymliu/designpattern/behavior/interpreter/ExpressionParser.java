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

import java.util.Stack;

/**
 * 自定义解释器，解释字符串，实现 波兰栈表示法。
 *
 * @author LYM
 */
public class ExpressionParser
{
    private final Stack<Interpreter> stack = new Stack<>();

    public int parse(String str)
    {
        String[] strItermArray = str.split(" ");
        for (String symbol : strItermArray)
        {
            if (OperatorUtil.isOperator(symbol))
            {
                // 是运算符，可以计算
                Interpreter firstExpression = stack.pop();
                Interpreter secondExpression = stack.pop();
                System.out.printf("出栈： %d  和 %d\n", firstExpression.interpreter(), secondExpression.interpreter());

                Interpreter operator = OperatorUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                System.out.printf("应用运算符：%s\n", operator);

                int result = operator.interpreter();
                NumberInterpreter resultExpress = new NumberInterpreter(result);
                stack.push(resultExpress);
                System.out.printf("结算结果入栈：%d\n", resultExpress.interpreter());

            }
            else
            {
                // 不是运算符，作为数字入栈
                Interpreter numberInterpreter = new NumberInterpreter(symbol);
                stack.push(numberInterpreter);
                System.out.printf("入栈：%d\n", numberInterpreter.interpreter());
            }
        }

        int result = stack.pop().interpreter();
        return result;
    }
}
