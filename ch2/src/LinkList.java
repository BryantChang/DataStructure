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
        printLength();
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
        System.out.println(pos);
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
}
