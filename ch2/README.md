# 第二章：线性表

## 线性表实现方法的比较

* 顺序表---基于数组实现

### 不适合使用顺序表的场合

* 线性表中经常要插入/删除内部元素时不适合使用顺序表。
* 无法确定顺序表的具体长度的时候不适合使用顺序表。

### 不适合使用链表的场合

* 需要经常对线性表按位置进行访问，并且需要安慰读操作比插入/删除操作频繁时，不适宜使用链表进行实现。
* 指针所占空间比较大时，要慎重使用链表。

### Page45 习题

#### 1、方法1：从头开始扫描

```java
Boolean insert(T x) {
    Boolean flag = false;
    //边界条件
    if((curLen + 1) > maxSize) {
        flag = false;
    }else {
        int index = 0;
        while(x.value > a[index].value) {
            index++;
        }
        for(int i = curLen; i > index; i--) {
            a[i] = a[i - 1];
        }
        curLen += 1;
        a[index] = x;
        flag = true;
    }
    return flag;
}
```

#### 方法2：从尾部开始扫描

```java
Boolean insert(T x) {
    Boolean flag = false;
    //边界条件
    if((curLen +1) > maxSize) {
        flag = false;
    }else {
        int index = curLen - 1;
        while(x.value < a[index].value) {
            a[index+1] = a[index];
            index--;
        }
        curLen += 1;
        a[index] = x;
        flag = true;
    }
    return flag;
}
```

### 习题2：

```java
int compare(T[] A, T[] B) {
    //找到第一个不同的元素
    int index = 0;
    int compare = 0;
    while((index < A.length) && (index < B.length) && (A[index] == B[index]))
        index++;
    if((index == A.length) && (index == B.length)) {
        compare = 0;
    }else {
        if(index > B.length){
            compare = 1;
        }else if(index > A.length) {
            compare = -1;
        }else if(A[index] > B[index]) {
            compare = 1;
        }else {
            compare = -1;
        }
    }
    return compare;
}
```

### 习题3：

```java
Boolean rangeDelete(int min, int max) {
    LinkNode pre = first;
    LinkNode cur = first.getNext();
    //找到min
    while(cur.getData.value >= min) {
        pre = cur;
        cur = cur.getNext();
    }
    //找到max
    while(cur.getData.value <= max) {
        cur = cur.getNext();
    }
    pre.setNext(cur.getNext());
    return true;
}
```

### 习题4：两个递增的链表合并为递增的链表

```java
LinkList mergeLinkList(LinkList A, LinkList B) {
    //头节点
    LinkNode node_c = new LinkNode(null, null);
    LinkNode node_a = A.first.getNext();
    LinkNode node_b = B.first.getNext();

    while((node_a.getNext() != null) && (node_b.getNext() != null)) {
        if(node_a.getData() < node_b.getData()) {
            node_c = node_a;
            node_a = node_a.getNext();
        }else if(node_a.getData() > node_b.getData()){
            node_c = node_b;
            node_b = node_b.getNext();
        }else {
            node_c = node_a;
            node_c.setNext(node_b.getNext());
            node_b = node_b.getNext();
        }
    }
    //剩余段
    if(node_a.getNext() != null) {
        node_c.setNext(node_a);
    }else {
        node_c.setNext(node_b);
    }
    LinkList list = new LinkList(node_c);
    return list;

}
```








