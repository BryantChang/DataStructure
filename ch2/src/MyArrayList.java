/**
 * Created by bryantchang on 2017/3/2.
 */
public class MyArrayList<T> extends List<T> {
    private T[] array;
    private int maxSize;
    private int curLen;
    private int position;

    public MyArrayList(int maxSize){
        this.maxSize = maxSize;
        //泛型数组不能直接初始化,需要强转。
        this.array = (T[])new Object[this.maxSize];
        curLen = position = 0;
    }

    @Override
    void clear() {
        super.clear();
        curLen = position = 0;
        this.array = (T[])new Object[this.maxSize];
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
        Boolean flag = super.isEmpty();
        //边界条件(是否还能继续添加)
        if((curLen + 1) > maxSize) {
            System.out.println("can not append");
            flag = false;
        }else {
            this.array[curLen + 1] = value;
            curLen += 1;
            flag = true;
        }
        return flag;
    }

    @Override
    Boolean insert(T value, int pos) {
        Boolean flag = super.insert(value, pos);
        //边界条件(是否可以插入)
        if(pos < 0 || pos > curLen) {
            flag = false;
        }else {
            //右移元素
            for (int i = curLen; i > pos; i++) {
                array[i] = array[i-1];
            }
            //插入
            array[pos] = value;
            flag = true;
        }
        return flag;
    }
}
