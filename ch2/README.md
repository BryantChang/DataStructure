# 第二章：线性表

## 线性表实现方法的比较

* 顺序表---基于数组实现

### 不适合使用顺序表的场合

* 线性表中经常要插入/删除内部元素时不适合使用顺序表。
* 无法确定顺序表的具体长度的时候不适合使用顺序表。

### 不适合使用链表的场合

* 需要经常对线性表按位置进行访问，并且需要安慰读操作比插入/删除操作频繁时，不适宜使用链表进行实现。
* 指针所占空间比较大时，要慎重使用链表。

### 习题

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






