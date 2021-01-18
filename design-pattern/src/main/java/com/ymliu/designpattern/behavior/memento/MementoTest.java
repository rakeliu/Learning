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

package com.ymliu.designpattern.behavior.memento;

/**
 * 测试
 *
 * @author LYM
 */
public class MementoTest
{
    public static void main(String[] args)
    {
        ArticleMementoManager manager = new ArticleMementoManager();

        Article article = new Article("设计模式A", "手记内容A", "手记图片A");
        ArticleMemento articleMemento = article.saveToMemento();
        manager.addMemento(articleMemento);
        System.out.printf("标题：%s 内容：%s 图片：%s\n", article.getTitle(), article.getContent(), article.getImgs());
        System.out.println("手记完整信息：" + article);

        System.out.println("修改手记 start");
        article.setTitle("设计模式B");
        article.setContent("手机内容B");
        article.setImgs(("手记图片B"));
        System.out.println("修改手记 end");
        System.out.println("手记完整信息：" + article);

        articleMemento = article.saveToMemento();
        manager.addMemento(articleMemento);

        article.setTitle("设计模式C");
        article.setContent("手记内容C");
        article.setImgs("手记图片C");

        System.out.println("暂时回退 start");
        System.out.println("回退出栈 1 次");
        articleMemento = manager.getMemento();
        article.undoFromMemento(articleMemento);

        System.out.println("回退出栈 2 次");
        articleMemento = manager.getMemento();
        article.undoFromMemento(articleMemento);

        System.out.println("暂时回退 end");
        System.out.println("手记完整信息：" + article);
    }
}
