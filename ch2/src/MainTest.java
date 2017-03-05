import sun.awt.image.ImageWatched;

import java.util.ArrayList;

/**
 * Created by bryantchang on 2017/3/2.
 */
public class MainTest {

//    public static ArrayList<Integer> jiaoJi(ArrayList<Integer> list_a, ArrayList<Integer> list_b) {
//        ArrayList<Integer> list_c = new ArrayList<Integer>();
//        int index_a = 0;
//        int index_b = 0;
//        for (index_a = 0; index_a < list_a.size(); index_a++) {
//            if(list_a.get(index_a) < list_b.get(index_b)) {
//                continue;
//            }else if(list_a.get(index_a) > list_b.get(index_b)) {
//                index_b++;
//                index_a--;//保留当前的index_a
//            }else if(list_a.get(index_a) == list_b.get(index_b)){
//                list_c.add(list_a.get(index_a));
//            }
//        }
//        return list_c;
//    }


    public static void main(String[] args) {
//        List<Integer> mylist = new MyArrayList<Integer>(100);
//        System.out.println("Test Append......");
//        for (int i = 0; i < 10; i++) {
//            mylist.append(i);
//        }
//        System.out.println("Test insert......");
//        mylist.insert(11, 4);
//        System.out.println("Test delete......");
//        mylist.delete(6);
//        System.out.println("Test getValue......");
//        for (int i = 0; i < mylist.length(); i++) {
//            System.out.println("The element " + i + " is " + mylist.getValue(i));
//        }

//        List<Integer> myliklist = new LinkList<Integer>();
//        System.out.println("Test Append......");
//        for (int i = 0; i < 10; i++) {
//            myliklist.append(i);
//        }
//        System.out.println("Test insert......");
//        myliklist.insert(11, 4);
//        System.out.println("Test delete......");
//        myliklist.delete(6);
//        System.out.println("Test getValue......");
//        for (int i = 0; i < myliklist.length(); i++) {
//            System.out.println("The element " + i + " is " + myliklist.getValue(i));
//        }
//
//        ArrayList<Integer> list_a = new ArrayList<Integer>();
//        ArrayList<Integer> list_b = new ArrayList<Integer>();
//
//        list_a.add(1);
//        list_a.add(2);
//        list_a.add(4);
//        list_a.add(5);
//
//        list_b.add(3);
//        list_b.add(4);
//        list_b.add(5);
//        list_b.add(7);
//
//        ArrayList<Integer> list_c = jiaoJi(list_a, list_b);
//        for (int i = 0; i < list_c.size(); i++) {
//            System.out.println(list_c.get(i));
//        }
        LinkList<Integer> list = new LinkList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println("before:");
        for (int i = 0; i < list.length(); i++) {
            System.out.println(list.getValue(i));
        }


        LinkList<Integer> list_after = list.reserve(list);
        System.out.println("after:");
        for (int i = 0; i < list_after.length(); i++) {
            System.out.println(list_after.getValue(i));
        }

    }
}
