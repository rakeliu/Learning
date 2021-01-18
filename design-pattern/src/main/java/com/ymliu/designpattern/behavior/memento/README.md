# 备忘录模式（Memento Pattern）

保存某个对象的某个状态，以便于在适当的时候恢复对象。关键在于是否可以在必要的时候捕捉到对象的内部状态。

## 场景
- 保存和回复数据相关业务场景；
- 后悔的时候，即想恢复到之前的状态。

## 步骤
见示例。

## 示例

例如：学习的时候回记录自己的思路，然后记下来，如果想修改，恢复到之前保存的状态。

- 创建手记，包含导入/导出（即恢复/保存）功能；
- 创建手记备忘录；
- 创建手记备忘管理者；
- 测试