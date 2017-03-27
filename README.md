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
       int c = 0;
        int sum = 0;
        //两个游标节点
        ListNode head = new ListNode(-1);
        ListNode p = new ListNode(-1);
        ListNode pa = new ListNode(-1);
        ListNode pb = new ListNode(-1);
        pa = a;
        pb = b;
        p = head;
        //生成链表节点终止条件
        while(pa != null || pb != null || c != 0) {
            int val1 = (pa == null ? 0 : pa.val);
            int val2 = (pb == null ? 0 : pb.val);

            sum = val1 + val2 + c;
            //进位
            c = sum / 10;
            //生成加法当前数位的节点
            ListNode node = new ListNode(sum%10);
            p.next = node;
            p = p.next;
            //指针同时向后移
            pa = (pa == null ? null : pa.next);
            pb = (pb == null ? null : pb.next);

        }
        return head.next;
    }
}
```

### 4、请编写一个函数，检查链表是否为回文。给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。

```
解题思路：将链表的前半部分入栈，使用快慢指针的方式筛选出链表的前半部分元素。然后从对称轴的后一个元素开始遍历，和每一个出栈的元素对比，如果全部相等说明是回文，否则中间出现任何不相等的现象则返回false
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
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        Stack<Integer> stack = new Stack<Integer>();
        ListNode slow = new ListNode(-1);
        ListNode fast = new ListNode(-1);
        slow = pHead;
        fast = pHead;

        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if(slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
```


### 5、输入一个链表，反转链表后，输出链表的所有元素。

```
解题思路：使用三个游标节点进行控制，核心是提前标记到当前节点的next域。
```

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
```


### 6、输入一个链表，从尾到头打印链表每个节点的值。

```
解题思路：利用ArrayList中的add函数特点(每次添加时如果元素已经存在，则剩余的元素向后移动)
```

```java
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       ArrayList list = new ArrayList<Integer>();
       while(listNode != null) {
           list.add(0, listNode.val);
           listNode = listNode.next;
       }
       return list;
    }
}
```

### 7、输入两个链表，找出它们的第一个公共结点

```
解题思路:首先确定两个链表具有公共节点的特征，如下图所示，解决方案可以为设置两个游标指针，不停地在两个链表交替遍历，两个游标每次同时向后移动一个节点，若非公共部分长度相同，则移动非公共部分个数的节点就能够找到两个链表的公共节点，若非公共部分不同，即两个链表的长度不相同时，则两个指针会不同时到达末尾，则会变为快慢指针的追击问题。因此此方法最终会找到俩个链表的公共节点。
```

![image](https://raw.githubusercontent.com/BryantChang/DataStructure/master/imgs/common_node.png)

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-1);

        node1 = pHead1;
        node2 = pHead2;

        while(node1 != node2) {
            node1 = (node1 == null ? pHead2 : node1.next);
            node2 = (node2 == null ? pHead1 : node2.next);
        }
        return node1;
    }
}
```

### 8、在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

```
解题思路：为了统一化操作，设立头结点，并设两个游标节点，前驱节点和当前节点，前驱节点首先指向头结点，当前节点初始指向给定链表头pHead，当当前节点的值与当前节点下一个节点的值相同时，游标指针向后遍历，找到第一个与当前值不相等的节点，删除中间的节点，进行下面的遍历。
```


```java
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode first = new ListNode(-1);//头结点
        first.next = pHead;
        ListNode p = pHead;
        ListNode pre = first;
        while(p != null && p.next != null) {
            if(p.val == p.next.val) {
                int val = p.val;
                while(p != null && p.val == val) {
                    p = p.next;
                }
                pre.next = p;
            }else {
                pre = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
```

### 9、输入一个链表，输出该链表中倒数第k个结点。

```
解题思路：使用快慢指针的方法，让前面的指针先走k个节点，如果链表长度小于k则会遇到空直接返回null，当前面的指针完成遍历时，快慢指针同时向前移动，当前面的指针走到链表尾部时，后面指针所指的位置正好为倒数第k个元素。
```

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node = new ListNode(0);
        ListNode nodeK = new ListNode(0);
        node = head;
        nodeK = head;
        if(head == null || k == 0) {
            return null;
        }
        for(int i = 1; i < k; i++) {
            if(nodeK.next != null) {
                nodeK = nodeK.next;
            }else {
                return null;
            }
            
        }
        while(nodeK.next != null) {
            node = node.next;
            nodeK = nodeK.next;
        }
        return node;
    }
}
```

### 10、输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

```
解题思路：首先是递归思路，首先是当有一条链表为空时
```





