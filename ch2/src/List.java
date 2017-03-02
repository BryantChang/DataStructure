/**
 * Created by bryantchang on 2017/3/2.
 */
abstract public class List<T> {
    //Common implement
    void clear(){}
    Boolean isEmpty(){return false;}
    int length(){return 0;}
    Boolean append(T value){return false;}
    Boolean insert(T value, int pos){return false;}
    Boolean delete(int pos){return false;}
    T getValue(int pos){return null;}
    int getPos(T value){return -1;}
}
