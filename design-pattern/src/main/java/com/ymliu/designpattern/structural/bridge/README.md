# 桥接模式

将抽象部分与它的具体实现部分分离，使他们都可以独立的变换。

关键在于是否可以将对象拆分成多个不相关的维度。

## 场景
- 抽象和具体之间增加更多的灵活性；
- 一个类存在两个或多个独立变化的维度， 且这两个或多个维度都需要独立进行扩展；
- 不希望适用继承，或因为多层继承导致系统类的个数剧增。

## 步骤

参看示例。

## 示例

- 中国有很多银行，如农行、工行，有自己的账号，然后又分为定期和活期；
- 可以拆分为一块是银行，一块是账号；
- 以后银行越来越多，希望用桥接模式去进行设计，便于扩展。


- 创建银行账号接口类；
- 创建定期账号和活期账号，实现账号接口类；
- 创建银行抽象类，**桥**在这个抽象类中；
- 创建工行和农行，继承于银行抽象类。