学习笔记



### 深度优先搜索和广度优先搜索

#### 9.1深度优先搜索和广度优先搜索的实现和特性

![image-20201212161932533](E:\picture\typora\image-20201212161932533.png)

##### 搜索

1. 每个节点都要访问一次
2. 每个节点仅仅访问一次
3. 节点的访问顺序不限
   1. 深度优先 depth first search
   2. 广度优先 breadth first search 

DFS

递归、栈

> 不会等循环跑完就会直接进入到下一层

```java
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```

BFS

队列

> 一层一层的访问所有子节点

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

### 10、贪心的实现、特性及实战题目解析

> 每一步选择都采取在当前状态下最好或最优的选择，从而希望导致结果是最好或最优的算法
>
> 贪心算法**对每个子问题都会选择**，**不能回退**
>
> 动态规划会**保存**运算结果，并根据当前进行选择，有**回退**功能

#### 适用情况 

> 处理**最优化问题**、不适用工程和生活
>
> 辅助算法、接近最优、不要求精确

1. 最小生成树
2. 哈夫曼编码

#### 适用场景

> 问题能够分解成子问题，子问题的最优解能地推到最终问题的最优解

### 11、二分查找的实现、特性

#### 前提

1. 目标函数单调性(单调递增或者递减)
2. 存在上下界(bounded)
3. 能够访问索引(index accessible)

#### 代码模板

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

#### 牛顿迭代法(常用的二分查找)

[牛顿迭代法官网](https://www.beyond3d.com/content/articles/8/)

##### 示例

>  已知$y = x^2$，根据y求x
>
>  $r = \frac{(r +  \frac {r}{y})}{2}$ ==> r = (r  + r/y)/2