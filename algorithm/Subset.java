
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by fanji on 2016/11/16.
 */
public class Subset {
    public static void main(String[] args) {
        String strInput = null;
        RandomizedQueue<String> ran = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            strInput = StdIn.readString();
            ran.enqueue(strInput);
        }
        int k = Integer.parseInt(args[0]);
        for(int i=0;i<k;i++){
           StdOut.println(ran.dequeue());
       }
    }


}
