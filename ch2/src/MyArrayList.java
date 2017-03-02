/**
 * Created by bryantchang on 2017/3/2.
 */
public class MyArrayList<T> extends List<T> {
    private T[] array;
    private int maxSize;
    private int curLen;

    public void printLength() {
        System.out.println("The current length is: " + curLen);
    }

    public MyArrayList(int maxSize){
        this.maxSize = maxSize;
        //泛型数组不能直接初始化,需要强转。
        this.array = (T[])new Object[this.maxSize];
        curLen = 0;
    }

    @Override
    void clear() {
        super.clear();
        curLen = 0;
        this.array = (T[])new Object[this.maxSize];
        printLength();
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
    Boolean append(T value) {
        Boolean flag = super.append(value);
        //边界条件(是否还能继续添加)
        if((curLen + 1) > maxSize) {
            System.out.println("can not append");
            flag = false;
        }else {
            this.array[curLen] = value;
            curLen += 1;
            flag = true;
        }
        printLength();
        return flag;
    }

    @Override
    Boolean insert(T value, int pos) {
        Boolean flag = super.insert(value, pos);
        //边界条件(是否可以插入)
        if(pos < 0 || pos > curLen) {
            System.out.println("illeagle position");
            flag = false;
        }else {
            //右移元素
            for (int i = curLen; i > pos; i--) {
                array[i] = array[i-1];
            }
            //插入
            array[pos] = value;
            curLen += 1;
            flag = true;
        }
        printLength();
        return flag;
    }

    @Override
    Boolean delete(int pos) {
        Boolean flag = super.delete(pos);
        //边界条件(是否可以删除)
        if(pos < 0 || pos > curLen) {
            System.out.println("illeagle position");
            flag = false;
        }else {
            for (int i = pos; i < curLen-1; i++) {
                array[i] = array[i+1];
            }
            curLen -= 1;
            flag = true;
        }
        printLength();
        return flag;
    }

    @Override
    T getValue(int pos) {
        T res = super.getValue(pos);
        //边界条件判读
        if(pos < 0 || pos > curLen) {
            System.out.println("illeagle position");
            res = null;
        }else {
            res = array[pos];
        }
        return res;
    }

    @Override
    int getPos(T value) {
        int pos = super.getPos(value);
        for (int i = 0; i < curLen; i++) {
            if (array[i].equals(value)) {
                pos = i;
            }
        }
        return pos;
    }
}
