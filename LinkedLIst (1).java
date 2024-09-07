import packagenew.Node;
public class LinkedLIst{
    //convert array into linkedlist
    
    private static Node convert(int[] array) {
		Node head = new Node(array[0]);
		Node mover = head;
		for(int i=1;i<array.length;i++) {
			Node temp = new Node(array[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
    }


    //serach the value
    private static void search(Node head, int element){
        Node temp = head;
        int flag = 0;
        while(temp != null){
            if(temp.data == element){
                flag = 1;
            }
            temp = temp.next;
        }
        if(flag == 1){
            System.out.println("The key element is available");
        }else{
            System.out.println("The key element is not found");
        }

    }

    //display the linkedlist
    private static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    //findout the length of the linkedlist
    public static int length(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //delete the head Node
    private static Node deleteHead(Node head){
            head = head.next;
        return head;
    }

    //delete the tail node
    private static Node deleteTail(Node head){
        Node temp = head;
        if(head == null || head.next == null){
            return null;
        }
        else{
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }

    //delete the kth node
    private static Node deleteKthNode(Node head, int k){
        if(head == null) return null;
        if(k==1) {
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp =head;
        Node prev = null;
        while(temp != null){
            count++;
            if(count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //delete by value
    private static Node deleteByValue(Node head, int value){
        if(head == null || head.data == value) return null;
        Node prev = null;
        Node temp = head;
        while(temp !=null){
            if(temp.data == value){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //insert at head of the ll
    private static Node insertAtHead(Node head,int value){
        Node temp = new Node(value,head);
        return temp;
    }

    //insert at the tail of the ll
    private static Node insertAtTail(Node head, int value){
        if(head == null){
            return new Node(value);
        }
        
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node newNode = new Node(value);
            temp.next = newNode;
        
        return head;
    }

    //insert at the particular node
    private static Node insertAtKthNode(Node head, int value, int k){
        if(head == null){
            if(k == 1){
                Node newNode = insertAtHead(head, value);
                return newNode;
            }else{
                return null;
            }
        }
        if(k==1){
            Node temp = new Node(value, head);
            return temp;
        }
        int count =0;
        Node temp = head;
        while(temp != null){
            count++;
            if(count == k){
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    //driver code
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6};
        Node head = convert(array);
        display(head);
        System.out.println("length of the linkedlist is:"+length(head));
        search(head, 9);
        Node newNode = deleteHead(head);
        display(newNode);
        Node tail = deleteTail(newNode);
        display(tail);
        Node k = deleteKthNode(tail, 3);
        display(k);
        Node value = deleteByValue(k, 5);
        display(value);
        Node insertHead = insertAtHead(value,1);
        display(insertHead);
        Node insertagain = insertAtHead(insertHead, 0);
        display(insertagain);
        Node inertTail = insertAtTail(insertagain, 4);
        display(inertTail);
        Node kth = insertAtKthNode(inertTail, 9, 4);
        display(kth);
    }
}
