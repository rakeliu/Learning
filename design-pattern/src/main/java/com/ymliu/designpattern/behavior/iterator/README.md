# 迭代器模式

提供一种方法，顺序访问一个集合对象中的各个元素，而又不暴露该对象的内部表示（例如java的iterator接口）。

关键在于客户端是否关心遍历的次序。

## 场景
- 访问一个结合对象的内容，而无需暴露它的内部表示；
- 为遍历不同的集合结构提供一个统一的接口。

## 步骤
见示例。

## 示例
网上有很多虚席java的课程，想通过迭代器去遍历并打印。
- 创建课程的实体类；
- 创建课程的集合（接口）；
- 创建课程的集合（实现类）；
- 创建课程迭代器的接口类；
- 创建课程迭代器的实现类；
- 测试