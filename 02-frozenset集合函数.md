### 1.描述

`frozenset()`返回一个冻结的集合，冻结后不能添加、删除和修改。
`set()`无序且不重复，是可以变的，有add、remove。扩展：删除重复数据，还可以计算交集、差集、并集等

### 2.函数用法
```python
frozenset([iterable])
iterable -- 可迭代对象，如：列表、字典、元组、字符串
```



### 3.返回值

返回新的`frozenset`对象，如果不提供任何参数，默认会生成空集合。

### 4.实例
```python
''' frozenset '''
num = frozenset(range(10))    # 创建不可变集合
print(num)    # frozenset({0, 1, 2, 3, 4, 5, 6, 7, 8, 9})

sitename = frozenset('pythonab')    # 创建不可变集合, 注意：顺序不是按照参数的顺序
print(sitename)    # frozenset({'a', 'b', 'h', 'p', 't', 'y', 'n', 'o'})

''' set '''
sitename1 =  set('pythonab')    # 可变集合
print(sitename1)    # {'a', 'b', 'h', 'p', 't', 'y', 'n', 'o'}

# set中向集合中添加
sitename1.add('.com')
print(sitename1)    # {'.com', 'a', 'b', 'h', 'p', 't', 'y', 'n', 'o'}

# frozenset中向集合中添加成员
sitename.add('.com')    #向不可变集合中添加成员，会报错
'''
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
AttributeError: 'frozenset' object has no attribute 'add'
'''
```