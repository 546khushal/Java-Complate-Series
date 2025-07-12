/*
WAP to create two link list and perform Operation Union,intersect*/
import java.util.Scanner;
class Union_intersect{
    Node head;

    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    void Append(int value){
        Node newNode=new Node(value);
        Node current=head;
        if(head==null || head.data>value){
            newNode.next=head;
            head=newNode;
        }else{
            while(current.next!=null && current.next.data<=value){
                current=current.next;
            }
            newNode.next=current.next;
            current.next = newNode;
        }
    }
    /** p -> pehli list ka head node
        q -> dusri list ka head node
        result -> jahan answer store hoga */
    static void UnionList(Node p,Node q,Union_intersect result){
        Node tmp=null;
        boolean found;
        Node current=p;
        while(current!=null){
            result.Append(current.data);
            current=current.next;
        }
        current=q;
        while(current!=null){
            tmp=result.head;//Jab manually nodes traverse karna ho
            found=false;
            while(tmp!=null){//check element already in result
                if(tmp.data==current.data){
                    found=true;
                    break;
                }
                tmp=tmp.next;
            }
            if(!found){
                result.Append(current.data);
            }
            current=current.next;
        }
    }

    static void Intersect(Node p,Node q,Union_intersect result){
        Node tmp1=p;
        Node tmp2;
        Node check;
        boolean flag;
        while(tmp1!=null){
            tmp2=q;
            while(tmp2!=null){
                if(tmp1.data==tmp2.data){
                    check=result.head;
                    flag=false;
                    while(check!=null){
                        if(check.data==tmp1.data){
                            flag=true;
                            break;
                        }
                        check=check.next;
                    }
                    if(!flag){
                        result.Append(tmp1.data);
                    }
                }
                tmp2=tmp2.next;
            }
            tmp1=tmp1.next;
        }
    }
    void display(){
        Node current=head;
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Union_intersect list = new Union_intersect();
        Union_intersect list2 = new Union_intersect();
        Union_intersect result = new Union_intersect();
        
        int choice,value;
        do{
            System.out.println("1. Insert First list");
            System.out.println("2. Display First list");
            System.out.println("3. Insert Second list");
            System.out.println("4. Display Second list");
            System.out.println("5. Union Both List");
            System.out.println("6. InterSect Both List");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter in List 1: ");
                    value=sc.nextInt();
                    list.Append(value);
                    list.display();
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter in List 1: ");
                    value=sc.nextInt();
                    list2.Append(value);
                    list2.display();
                    break;
                case 4:
                    list2.display();
                    break;
                case 5:
                    result = new Union_intersect(); // Reset result
                    UnionList(list.head,list2.head,result);
                    /**    result: Poori LinkedList ka object (jisme head pointer hota hai)
                            result.head: Sirf pehla Node (list ka starting point) 
                                list.head: Pehli list ka pehla Node
                                list2.head: Dusri list ka pehla Node
                                result: Result store karne wali poori list
                                
                                    Sirf pehla Node milega
                                    Naye nodes add karne mein problem hogi
                                    Poori list modify nahi kar payenge*/
                    result.display();
                    break;
                case 6:
                    result = new Union_intersect(); // Reset result
                    Intersect(list.head,list2.head,result);
                    result.display();
                    break;
                case 7:
                     System.out.println("\nReturning to main menu...");
                    break;
                default:
                    System.out.println("Invalid Choice Boss! Please enter right Choice");
            }
            if(choice!=7){
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        
        }while(choice!=7);
    }
}