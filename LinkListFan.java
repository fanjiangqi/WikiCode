package fan;

/**
 * Created by fanjiangqi on 2016/12/26.
 * 链表的操作
 */
public class LinkListFan {
    private Node first = null; //链表的表头

    private class Node{
        int val;
        Node next;
        public Node(int i){
            this.val = i;
        }
    }


    //从链表头添加一个节点
    public void addNodeInFirst(int val){
        if(this.first == null){
            this.first = new Node(val);
            return;
        }
        Node oldFirst = this.first;
       this.first = new Node(val);
        this.first.next = oldFirst;

    }

    //从链表尾部添加一个节点
    private void addNodeInLast(int val){
        Node root = first;//保存first节点，不然会丢失
        //找到最后一个节点
        while (root.next != null){
            root = root.next;
        }
        Node last = new Node(val);
        last.next = null;
        root.next = last;
    }

    //获得链表中所有数据
    private int[] getAllValues(){
        Node actFirst = first;
        int i = 0;
        while (actFirst.next != null){
            i++;
            actFirst = actFirst.next;
        }
        i++;
        actFirst = first; //再次等于链表头，方便下次操作
        int[] size = new int[i];
        for(int j=0;j<i;j++){
            size[j] = actFirst.val;
            actFirst = actFirst.next;
        }
        return size;
    }

    @Override
    public String toString() {

        return "LinkListFan{" +
                "first=" + first +
                '}';
    }

    public static void main(String[] args) {
        LinkListFan test = new LinkListFan();
        test.addNodeInFirst(3);
        test.addNodeInFirst(8);
        test.addNodeInLast(10);
        int[] arr = test.getAllValues();
        for(int i :arr){
            System.out.println(i);
        }
      // System.out.println(arr[0]);

    }
}
