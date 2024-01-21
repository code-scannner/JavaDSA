package linkedlist;

public class InterSectionOfTwoLists {
    public static Node intersection(Node A, Node B) {
        int l1 = A.size();
        int l2 = B.size();
        while(l1 > l2){
            A = A.next;
            l1--;
        }
        while(l2 > l1){
            B = B.next;
            l2--;
        }

        while(A != B){
            A = A.next;
            B = B.next;
        }
        
        return A;
    }
    public static void main(String[] args) {
        Node a = Node.LList(new int[]{
            1,2,3,4
        });
        Node b = Node.LList(new int[]{
            5,6,7
        });
        Node c = Node.LList(new int[]{
            8,9,10
        });
        a.next.next.next.next = c;
        b.next.next.next = c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(intersection(a, b));
    }
}
