/**
 * Created by bryantchang on 2017/3/2.
 */
public class LinkList<T>  extends List<T>{
    int curLen;
    LinkNode<T> first, current;
    public void printLength() {
        System.out.println("The current length is: " + curLen);
    }

    public LinkList() {
        first = new LinkNode<T>(null, null);
        current = new LinkNode<T>(null, null);
        current = first;
        curLen = 0;
    }

    public LinkList(LinkNode<T> first, int curLen) {
        this.first = new LinkNode(null, first.getNext());
        current = new LinkNode<T>(null, null);
        current = first;
        this.curLen = curLen;
    }

    public LinkNode<T> getFirst() {
        return first;
    }

    @Override
    Boolean isEmpty() {
        return (curLen == 0);
    }

    @Override
    int length() {
        return curLen;
    }

    @Override
    void clear() {
        first = new LinkNode<T>(null, null);
        current = new LinkNode<T>(null, null);
        current = first;
        curLen = 0;
    }

    @Override
    Boolean append(T value) {
        Boolean flag = false;
        LinkNode node = new LinkNode(value, null);
        current.setNext(node);
        current = node;
        curLen += 1;
        flag = true;
//        printLength();
        return flag;
    }

    @Override
    Boolean insert(T value, int pos) {
        Boolean flag = false;
        //边界条件
        if(pos < 0 || pos > curLen) {
            System.out.println("illeagle position");
            flag = false;
        }else {
            //同时指向第一个节点
            LinkNode cur =  first.getNext();
            LinkNode pre = first;
            int index = 0;
            while(index < pos){
                pre = pre.getNext();
                cur = cur.getNext();
                index++;
            }
            LinkNode node = new LinkNode(value, null);
            pre.setNext(node);
            node.setNext(cur);
            curLen += 1;
            flag = true;
        }
        printLength();
        return flag;
    }

    @Override
    Boolean delete(int pos) {
        Boolean flag = false;
        //边界条件
        if(pos < 0 || pos > curLen) {
            System.out.println("illeagle position");
            flag = false;
        }else {
            //同时指向第一个节点
            LinkNode cur =  first.getNext();
            LinkNode pre = first;
            int index = 0;
            while(index < pos){
                pre = pre.getNext();
                cur = cur.getNext();
                index++;
            }
            pre.setNext(cur.getNext());
            curLen -= 1;
            flag = true;
        }
        printLength();
        return true;
    }

    @Override
    T getValue(int pos) {
//        System.out.println("pos: " + pos);
        //边界条件
        T res = null;
        if(pos < 0 || pos > curLen) {
            System.out.println("illeagle position");
            res = null;
        }else {
            //同时指向第一个节点
            LinkNode cur =  first.getNext();
            LinkNode pre = first;
            int index = 0;
            while(index < pos){
                pre = pre.getNext();
                cur = cur.getNext();
                index++;
            }
            res = (T)cur.getData();
        }
        return res;
    }

    @Override
    int getPos(T value) {
        int pos = -1;
        //同时指向第一个节点
        LinkNode cur =  first.getNext();
        LinkNode pre = first;
        int index = 0;
        while(cur.getNext() != null) {
            if(cur.getData().equals(value)) {
                pos = index;
                break;
            }else {
                pre = pre.getNext();
                cur = cur.getNext();
            }
        }
        return pos;
    }


    LinkList<T> reserve(LinkList<T> other) {
        LinkNode first = other.getFirst();
        LinkNode p1, p2, p3;
        p1 = first.getNext();
        LinkList list = null;
        if(p1 == null) {
            //空链表
            list = null;
        }else {
            p2 = p1.getNext();
            if(p2 == null) {
                //一个节点时和原链表一样
                list = other;
            }else {
                while(p2 != null) {
                    p3 = p2.getNext();
                    p2.setNext(p1);
                    p1 = p2;
                    p2 = p3;
                }
                LinkNode head_new = new LinkNode(null, p1);
                list = new LinkList(head_new, other.length());
            }
        }
        return list;
    }
}
