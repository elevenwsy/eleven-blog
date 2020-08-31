### 1.描述


函数原型：`format(value[, format_spec])`
参数意义：
`value: 需要被格式化的字符串`
`format_spec： 格式化的格式`

### 2.实例
```python
''' 根据位置 '''
>>>"{} {}".format("hello", "Eleven")    # 不设置指定位置，按默认顺序
'hello Eleven'
 
>>> "{0} {1}".format("hello", "Eleven")  # 设置指定位置
'hello Eleven'
 
>>> "{1} {0} {1}".format("hello", "Eleven")  # 设置指定位置
'Eleven hello Eleven'
```


```python
''' 通过字典设置参数 '''
site = {"name": "Eleven-Blog", "url": "https://github.com/elevenwsy/eleven-blog"}
print("网站名：{name}, 地址 {url}".format(**site))    # 网站名：Eleven-Blog, 地址 https://github.com/elevenwsy/eleven-blog

```



```python
''' 通过列表索引设置参数 '''
my_list = ['Eleven-Blog', 'https://github.com/elevenwsy/eleven-blog']
print("网站名：{0[0]}, 地址 {0[1]}".format(my_list))  # 网站名：Eleven-Blog, 地址 https://github.com/elevenwsy/eleven-blog

```

