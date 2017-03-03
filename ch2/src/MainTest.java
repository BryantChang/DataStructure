/**
 * Created by bryantchang on 2017/3/2.
 */
public class MainTest {
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

        List<Integer> myliklist = new LinkList<Integer>();
        System.out.println("Test Append......");
        for (int i = 0; i < 10; i++) {
            myliklist.append(i);
        }
        System.out.println("Test insert......");
        myliklist.insert(11, 4);
        System.out.println("Test delete......");
        myliklist.delete(6);
        System.out.println("Test getValue......");
        for (int i = 0; i < myliklist.length(); i++) {
            System.out.println("The element " + i + " is " + myliklist.getValue(i));
        }
    }
}
