### 1.描述
`filter()`函数用于过滤序列，过滤不符合条件的元素，返回由符合条件元素组成的新列表。
对每个元素进行判断，返回 `True` 或 `False`，`filter()`根据判断结果自动过滤掉不符合条件的元素，最后将返回 `True` 的元素放到新列表中。

### 2.函数用法
`filter(function, iterable)`
参数：
`function -- 判断函数。`
`iterable -- 可迭代对象。`

### 3.实例

```python
''' 过滤非数字字符 '''
>>> list(filter(str.isdigit, name))
['2', '0', '2', '0']

''' 过滤数字 '''
>>> list(filter(str.isalpha, name))
['p', 'y', 't', 'h', 'o', 'n']

''' 保留数字和小数点 '''
>>> list(filter(lambda char: char in '0123456789.', name))
['2', '0', '2', '0']

''' 给定一个字符串元组，筛选出包含python的所有字符串 '''
str_tuple = ("hipython","pyth","lovepython","PYTHON","XMU")
result = filter((lambda x:x.find("python")!=-1), str_tuple)
for str in result:
    print(str)    # hipython lovepython

''' 给定一个字符串列表，筛选出长度为5的字符串 '''
>>> reuslt = filter((lambda x:len(x) == 5),str_list)
>>> for str in reuslt:
... print(str)    # abcde 12345 hello
```

