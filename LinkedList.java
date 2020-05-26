class LinkedList{
    Node head;
    class Node{
        Node next;
        int data;
        Node(int newdata){
            data=newdata;
            next=null;
        }

    }
    public void push(int newdata){
        Node newnode=new Node(newdata);
        newnode.next=head;
        head=newnode;
    }
    public void pushAfter(Node prev,int newdata){
        Node newnode=new Node(newdata);
        newnode.next=prev.next;
        prev.next=newnode;
    }
    public void append(int newdata){
        Node newnode=new Node(newdata);
        if(head==null){
            head=new Node(newdata);
            return;
        }
        newnode.next=null;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        return;
        
    }
    public void printList(){
        Node temp=head;
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        
    }
    public void delete(int key){
        Node temp=head;
        Node prev=null;
        if(temp!=null && temp.data==key){
            head=temp.next;
        }
        while(temp!=null && temp.data!=key){
            prev=temp;
            temp=temp.next;
        }
        if(temp==null){
            return;
        }
        prev.next=temp.next;
    }
    public void deleteNode(int index){
        if(head==null){
            return;
        }
        Node temp=head;
        if(index==0){
            head=temp.next;
        }
        for(int i=0;temp!=null && i<index-1;i++){
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            return;
        }
        Node newnode=temp.next.next;
        temp.next=newnode;
    }
    void deleteList(){
        head=null;
    }
    public int getCount(){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public int getCountRec(Node n){
        if(n==null){
            return 0;
        }
        return 1+getCountRec(n.next);
    }
    public boolean searchI(Node head, int n){
        Node current=head;
        while(current!=null){
            if(current.data==n){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public boolean searchR(Node head ,int n){
        if(head==null){
            return false;
        }
        if(head.data==n){
            return true;
        }
        return searchR(head.next,n);
    }
    public int getNth(int index){
        Node current=head;
        int count=0;
        while(current!=null){
            if(count==index){
                return current.data;
            }
            count++;
            current=current.next;
        }
        assert(false);
        return 0;
    }
    public void printFromLast(int n){
        Node newnode=head;
        int len=0;
        while(newnode!=null){
            newnode=newnode.next;
            len++;
        }
        if(n>len)return;
        newnode=head;
        for(int i=0;i<len-n+1;i++){
            newnode=newnode.next;
        }
        System.out.print(newnode.data+" ");
    }
    public void printMiddle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.print(slow.data+" ");
    }
    public int countOccurence(int n){
        Node temp=head;
        int count=0;
        while(temp!= null){
            if(temp.data==n){
                count++;
            }
            temp=temp.next;
        }
        return count;
    }
    public boolean detectLoop(){
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public int countNode(Node n){
        int res=1;
        Node temp=n;
        while(n.next!=temp){
            res++;
            n=n.next;
        }
        return res;
    }
    public int loopLength(){
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                countNode(slow);
            }
        }
        return 0;
    }
    public void removeDuplicates(){
        Node current=head;
        while(current!=null){
            Node temp=current;
            while(temp!=null && temp.data==current.data){
                temp=temp.next;
            }
            current.next=temp;
            current=current.next;
        }
    }
    public void removeDuplicatesNonSorted(){
        Node p1=null;
        Node p2=null;
        p1=head;
        while(p1!=null && p1.next!=null){
            p2=p1;
            while(p2.next!=null){
                if(p1.data==p2.next.data){
                    p2.next=p2.next.next;

                }else{
                    p2=p2.next;
                }
            }
            p1=p1.next;
        }
        
    }
    public void swapNodes(int x, int y){
        if(x==y){
            return;
        }
        Node prevX=null;
        Node currX=head;
        while(currX!=null && currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }
        Node prevY=null;
        Node currY=head;
        while(currY!=null && currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }
        if(currX==null || currY==null){
            return;
        }
        if (prevX != null) 
            prevX.next = currY; 
        else 
            head = currY; 

        if (prevY != null) 
            prevY.next = currX; 
        else 
            head = currX; 
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;
    }
    public void partwiseSwap(){
        Node temp=head;
        while(temp!=null && temp.next!=null){
            int k=temp.data;
            temp.data=temp.next.data;
            temp.next.data=k;

            temp=temp.next.next;
        }   
    }
    public void FirstToLast(){
        if(head==null || head.next==null){
            return;
        }
        Node curr=head;
        Node prev=null;
        while(curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        curr.next=head;
        head=curr;
    }
    public void bubbleSort(){
        Node out=head;
        while(out!=null){
            Node temp=head;
            while(temp!=null && temp.next!=null){
                if(temp.data>temp.next.data){
                    int val=temp.data;
                    temp.data=temp.next.data;
                    temp.next.data=val;
                }
                temp=temp.next;
            }
            out=out.next;
        }
    }
    public void oddEven(){
        Node evenStart=null;
        Node evenEnd=null;
        Node oddStart=null;
        Node oddEnd=null;
        Node curr=head;
        while(curr!=null){
            int item=curr.data;
            if(item%2==0){
                if(evenStart==null){
                    evenStart=curr;
                    evenEnd=evenStart;
                }else{
                    evenEnd.next=curr;
                    evenEnd=evenEnd.next;
                }
            }else{
                if(oddStart==null){
                    oddStart=curr;
                    oddEnd=oddStart;
                }else{
                    oddEnd.next=curr;
                    oddEnd=oddEnd.next;
                }
            }
            curr=curr.next;
        }
        if(oddStart == null || evenStart == null) { 
            return; 
        } 
        oddEnd.next=evenStart;
        evenEnd.next=null;
        head=oddStart;
    }
    public static Node getMiddle(Node head) 
    { 
        if (head == null) 
            return head; 
        Node slow = head, fast = head; 
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    }
    public Node sortedMerge(Node a,Node b){
        Node res=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<=b.data){
            res=a;
            res.next=sortedMerge(a.next,b);
        }
        else{
            res=b;
            res.next=sortedMerge(a,b.next);
        }
        return res;
    }
    public Node mergeSort(Node h){
        if(h==null || h.next==null){
            return h;
        }
        Node middle=getMiddle(h);
        Node nextmiddle=middle.next;
        middle.next=null;
        
        Node left=mergeSort(h);
        Node right=mergeSort(nextmiddle);
        Node sortedList=sortedMerge(left,right);
        return sortedList;
    }
    public static void main(String[] args){
        LinkedList list=new LinkedList();
        list.append(9);
        list.append(7);
        list.push(1);
        list.pushAfter(list.head,2);
        list.append(5);
        //list.push(5);
        //list.printList();
        //list.delete(2);
        //list.deleteNode(3);
        //System.out.println();
        list.printList();
        System.out.println();
        // System.out.println(list.getCount());
        // System.out.println(list.getCountRec(list.head));
        // System.out.println(list.searchI(list.head,2));
        // System.out.println(list.searchR(list.head,2));
        //System.out.print(list.getNth(2));
        //list.printFromLast(3);
        //list.printMiddle();
        // System.out.print(list.countOccurence(1));
        // System.out.println(list.loopLength());
        //list.removeDuplicatesNonSorted();
        // list.swapNodes(1,3);
        //list.partwiseSwap();
        // list.FirstToLast();
        list.bubbleSort();
        list.printList();
    }
}