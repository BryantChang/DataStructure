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