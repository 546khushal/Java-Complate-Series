import java.util.Scanner;
class PolyNomial{
    Node head;
    class Node{
        int coff,exp;
        Node next;
        public Node(int coff,int exp){
            this.coff=coff;
            this.exp= exp;
            this.next=null;
        }
    }
    void Append(int coff,int ex){
        Node newNode = new Node(coff,ex);
        if(head  == null || head.exp<ex){
            newNode.next=head;
            head=newNode;
        }
        else{
            Node current=head;
            while(current.next!=null && current.next.exp>=ex){
                current=current.next;
            }
            newNode.next=current.next;
            current.next=newNode;
        }
        System.out.println("Inserted Successfully");
    }


    static void Add(Node p,Node q,PolyNomial result){
        if(p==null && q==null){
            System.out.println("Linked List is Empty");
            return;
        }
        while(p!=null && q!=null){
            if(p.exp>q.exp){
                result.Append(p.coff,p.exp);
                p=p.next;
            }else if(p.exp<q.exp){
                result.Append(q.coff,q.exp);
                q=q.next;
            }
            else{
                result.Append(p.coff+q.coff,p.exp);
                p=p.next;
                q=q.next;
            }
        }
        while(p!=null){
            result.Append(p.coff,p.exp);
            p=p.next;
        }
        while(q!=null){
            result.Append(q.coff,q.exp);
            q=q.next;
        }
    }

    void display(){
        Node current=head;
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        while(current!=null){
            if(current.exp==0){
                System.out.print(current.coff);
            }
            else{
                System.out.printf("%dx^%d + ",current.coff,current.exp);
            }
            current=current.next;
        }
        System.out.print(" = 0\n");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PolyNomial Poly = new PolyNomial();
        PolyNomial Poly2 = new PolyNomial();
        PolyNomial result = new PolyNomial();
        int choice,exp,coff;
        do{
            System.out.println("1. Append First Polynomial");
            System.out.println("2. Display First Polynomial");
            System.out.println("3. Append Second Polynomial");
            System.out.println("4. Display Second Polynomial");
            System.out.println("5. Add First & Second Polynomial");
            System.out.println("6. Exit");
            System.out.println("\nEnter Your Choice: ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter coff:");
                    coff=sc.nextInt();
                    System.out.print("Enter exp:");
                    exp=sc.nextInt();
                    Poly.Append(coff,exp);
                    break;
                case 2:
                    Poly.display();
                    break;
                case 3:
                    System.out.print("Enter coff:");
                    coff=sc.nextInt();
                    System.out.print("Enter exp:");
                    exp=sc.nextInt();
                    Poly2.Append(coff,exp);
                    break;
                case 4:
                    Poly2.display();
                    break;
                case 5:
                    result=new PolyNomial();
                    Add(Poly.head,Poly2.head,result);
                    result.display();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid Choice Boss! Please enter right Choice");
            }
            if(choice!=6){
                System.out.println("\nPress Enter to continue...");
                sc.nextLine(); // Consume newline
                sc.nextLine(); // Wait for Enter
            }
        }while(choice!=6);
    }
}