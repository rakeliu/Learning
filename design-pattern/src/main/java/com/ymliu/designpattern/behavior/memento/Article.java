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
 * 创建手记，支持保存/恢复（导出/导入）功能。
 *
 * @author LYM
 */
public class Article
{
    private String title;
    private String content;
    private String imgs;

    public Article(String title, String content, String imgs)
    {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getImgs()
    {
        return imgs;
    }

    public void setImgs(String imgs)
    {
        this.imgs = imgs;
    }

    /**
     * 保存到备忘录中
     *
     * @return 一条备忘录
     */
    public ArticleMemento saveToMemento()
    {
        return new ArticleMemento(title, content, imgs);
    }

    public void undoFromMemento(ArticleMemento articleMemento)
    {
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
        this.imgs = articleMemento.getImgs();
    }

    @Override
    public String toString()
    {
        return "Article{" + "title='" + title + '\'' + ", content='" + content + '\'' + ", imgs='" + imgs + '\'' + '}';
    }
}
