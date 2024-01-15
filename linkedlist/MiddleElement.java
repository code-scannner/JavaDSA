package linkedlist;

public class MiddleElement {
    public static int middle(Node head) {
        Node i = head;
        Node j = head;
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }

        return i.val;
    }
    public static void main(String[] args) {
        Node list = Node.LList(new int[]{
            1,2,3,4,5,6,7,8,9,10
        });
        System.out.println(middle(list));
    }
}
