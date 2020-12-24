### 1.描述
`enumerate`函数用于遍历序列中的元素以及它们的下标

### 2.函数说明
`enumerate(sequence, [start=0])`
`sequence` -- 一个序列、迭代器或其他支持迭代对象。
`start` -- 下标起始位置。
1）将可循环序列sequence以start开始分别列出序列数据和数据下标。

2）会将该数据对象组合为一个索引序列，同时列出数据和数据下标。

### 3.实例
```python
import string
s = string.ascii_lowercase
e = enumerate(s)
print(s)
print(list(e))
>>> abcdefghijklmnopqrstuvwxyz
>>> [(0, 'a'), (1, 'b'), (2, 'c'), (3, 'd'), (4, 'e'), (5, 'f'), (6, 'g'), (7, 'h'), (8, 'i'), (9, 'j'), (10, 'k'), (11, 'l'), (12, 'm'), (13, 'n'), (14, 'o'), (15, 'p'), (16, 'q'), (17, 'r'), (18, 's'), (19, 't'), (20, 'u'), (21, 'v'), (22, 'w'), (23, 'x'), (24, 'y'), (25, 'z')]
```

### 4.适用场景
1）在同时需要index和value值的时候可以使用enumerate。
2）需要将一组包含0和1的数字中，找出1所对应的下标和值。

```python
def xread_line(line):
    return ((idx, int(val)) for idx, val in enumerate(line) if val != '0')
print(list(xread_line('0001110101')))
>>> [(3, 1), (4, 1), (5, 1), (7, 1), (9, 1)]
```

