package DSA;
class Node{
    int data;
    Node prev,next;
    Node(int d){
        data=d;
        prev=next=null;
    }
}

class CCL{
    Node head;
    CCL(){
        head = null;
    }
    public void insert(int data){
        if(head == null){
            head = new Node(data);
            head.prev = head.next = head;
            return;
        }

        Node end = head.prev;
        Node newNode = new Node(data);
        end.next = newNode;
        newNode.prev = end;
        newNode.next = head;
        head.prev = newNode;
    }
    public String toString(){
        Node node = head;
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        do{
            str.append(node.data);
            str.append(',');
            node = node.next;
        }while(node != head);

        str.deleteCharAt(str.length() - 1);
        str.append(" ]");

        return str.toString();
    }

    public void concate(CCL c){

        if(c.head == null) return;

        if(this.head == null) {
            this.head = c.head;
            return;
        }

        Node l1 = this.head;
        Node l2 = c.head;

        l1.prev.next = l2;
        Node prev2 = l2.prev;
        l2.prev = l1.prev;
        l1.prev = prev2;
        prev2.next = l1;

    }
}


public class CircularLinkedList {
    public static void main(String[] args) {
        CCL list = new CCL();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        CCL list2 = new CCL();
        list2.insert(5);
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);
        list.concate(list2);
        System.out.println(list.toString());
    }
}
