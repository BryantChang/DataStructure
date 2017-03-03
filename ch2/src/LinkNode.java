/**
 * Created by bryantchang on 2017/3/2.
 */
public class LinkNode<T> {
    T data;
    LinkNode next;

    public LinkNode(T data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkNode(LinkNode next) {
        this.data = null;
        this.next = next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
