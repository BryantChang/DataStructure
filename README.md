# 牛客网数据结构练习题

### 1、实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true

```
解题思路：由于只能访问这个节点，因此无法通过改动指针的方式实现删除。因此需要通过用下一个节点代替本节点的方式对于该节点进行删除。
```


```java
import java.util.*;
 
/*
public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Remove {
    public boolean removeNode(ListNode pNode) {
        // write code here
        //尾节点返回false
        if(pNode.next == null) {
            return false;
        }else {
            pNode.val = pNode.next.val;
            pNode.next = pNode.next.next;
            return true;
        }
    }
}
```


### 2、编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前,给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。

```
解题思路：本题的思路主要是借鉴了链表的尾插法进行，使用两个头结点分别作为大于x的和小于x的链表，最终把两个链表进行连接。
```

```java
import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        small = smallHead;
        big = bigHead;

        //空链表或只有一个节点
        if(pHead == null || pHead.next == null) {
            return pHead;
        }else {
            while(pHead != null) {
                if(pHead.val < x) {
                    small.next = pHead;
                    pHead = pHead.next;
                }else{
                    big.next = pHead;
                    pHead = pHead.next;
                }
            }
            big.next = null;
            small.next = bigHead.next;
            return smallHead.next;
        }
    }
}
```

### 3、有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。

```
基本思路：本文可以作为大数加法的基本思路，主要根据加法的特点，生成链表节点时主要是根据进位情况和是否遍历完A和B所表示的链表来确定。
```

```java
import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        //进位位
        int c = 0;
        int sum = 0;
        //两个游标节点
        ListNode newHead = new ListNode(-1);
        ListNode pc = new ListNode(-1);
        pc = newHead;
        ListNode pa = new ListNode(-1);
        ListNode pb = new ListNode(-1);
        pa = a;
        pb = b;
        //生成链表节点终止条件
        while(pa != null || pb != null || c != 0) {
            int val1 = (pa == null ? 0 : pa.val);
            int val2 = (pb == null ? 0 : pb.val);

            sum = val1 + val2 + c;
            //进位
            c = sum / 10;
            //生成加法当前数位的节点
            ListNode node = new ListNode(sum%10);
            pc.next = node;
            pc = pc.next;
            //指针同时向后移
            pa = (pa == null ? null : pa.next);
            pb = (pb == null ? null : pb.next);

        }
        pc.next = null;
        return newHead.next;
    }
}
```




