### 3、数组、链表、跳表

#### 3.1数组(ArrayList)

##### 特点

- 插入删除操作
  - O(n)
  - 时间复杂度高，效率低
- 查询
  - O(1)

#### 3.2链表(LinkedList-双向链表)

##### 结构

- Node
  - value
  - next：指针指向下一个节点
  - previous：指向上一节点

##### 特点

- 新增、删除、插入
  - 时间复杂度低O(1)
- 查看
  - O(n)

#### 3.3跳表

> 基于链表，只能用于链表元素**有序**的情况，对标的是**平衡树**，新增插入O($logn$)，Redis、LevelDB使用该数据结构

##### 原理 

> 一维数据结构优化，要增加一级数据，可以存放更多数据信息，升**维思维，空间换时间**，**索引**

##### 时间复杂度

- O($logn$)

##### 空间复杂度

- O(n)

##### 应用

- [LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)
- [Redis使用跳表](https://www.zhihu.com/question/20202931)

### 4、栈、队列

#### 4.1、栈Stack

##### 特点：

- 先入后出FILO
- 添加删除O(1)
- 查询O(n)

##### 方法：

- empty():空
- peek()：获取
- pop():拿取，并在原队列删除
- push(E item):添加
- search(Object o):查询

#### 4.2队列Queue

> 接口

##### 特点：

- 后入先出LIFO
- 添加删除O(1)
- 查询O(n)

##### 方法：

|         | Throws Exception | return special value |
| :-----: | :--------------: | :------------------: |
| Insert  |      add(e)      |       offer(e)       |
| Remove  |     remove()     |        poll()        |
| Examine |    element()     |        peek()        |



#### 4.3Deque(Double-End Queue):双端队列

> 两端都可以插入，接口

##### 方法：

|         | First Element(Head) |               | Last Element(Fail) |               |
| ------- | ------------------- | ------------- | ------------------ | ------------- |
|         | Throws Exception    | Special value | Throws Exception   | Special value |
| Insert  | addFirst(e)         | offerFirst(e) | addLast(e)         | offerLast()   |
| Remove  | removeFirst()       | pollFirst()   | removeLast()       | pollLast()    |
| Examine | getFirst()          | peekFirst()   | getLast()          | peekLast()    |

#### 4.4Priority Queue

##### 特点：

- 插入O(1)
- 取出O(logn)
- 底层实现的数据结构较为多样和复杂：heap、bst、treap

![image-20201126232802777](E:\picture\typora\1126O.png)

### 