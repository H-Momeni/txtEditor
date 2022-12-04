import java.rmi.Remote;

public class CircularDoublyLL {
    NodeOfLines head = null;
    NodeOfLines tail = null;

    public void insertLastL(String Line) {
        NodeOfLines newNode = new NodeOfLines();
        if (!Line.equals("#")) {// hash ha vared node nashavand
            newNode.dataL = Line;
            if (head == null) {
                head = tail = newNode;
                head.nextNodeL = head;
                head.prevNodeL = head;
            } else {
                tail.nextNodeL = newNode;
                newNode.prevNodeL = tail;
                newNode.nextNodeL = head;
                head.prevNodeL = newNode;
                tail = newNode;
            }
        } else {
            int x = 0;
        }

    }

    public void displayPage() {
        NodeOfLines currentNode = head;
        if (head == null) {
            System.out.println("Page is empty!");
        } else {
            int pageNo = 1;
            while (currentNode != tail) {
                System.out.println("Line " + pageNo + ": " + currentNode.dataL);
                pageNo++;
                currentNode = currentNode.nextNodeL;
            }
            System.out.println("Line " + pageNo + ": " + currentNode.dataL);
        }
    }

    public void countofLines() {
        NodeOfLines currentNode = head;
        if (head == null) {
            System.out.println("Page is empty!");
        } else {
            int pageNo = 1;
            while (currentNode != tail) {
                pageNo++;
                currentNode = currentNode.nextNodeL;
            }
            System.out.println(pageNo + " Lines");
        }
    }

    public void showNTHlines(int x) {
        NodeOfLines currentNode = head;
        if (head == null) {
            System.out.println("Page is empty!");
        } else {
            int pageNo = 1;
            do {
                System.out.println("Line " + pageNo + ": " + currentNode.dataL);
                pageNo++;
                currentNode = currentNode.nextNodeL;

            } while (pageNo <= x);
        }
    }

    public void insert(String matn, int x) {
        NodeOfLines newNode = new NodeOfLines();
        NodeOfLines temp=new NodeOfLines();
        temp=head;
        newNode.dataL = matn;
        for(int i=1;i<x;i++){
            temp=temp.nextNodeL;
        }
        newNode.nextNodeL=temp.nextNodeL;
        (temp.nextNodeL).prevNodeL=newNode;
        temp.nextNodeL=newNode;
        newNode.prevNodeL=temp;
    }

    public void remove(int x) {
        //NodeOfLines oldNode=new NodeOfLines();
        NodeOfLines temp=new NodeOfLines();
        temp=head;
        for(int i=2;i<x;i++){
            temp=temp.nextNodeL;
        }
        temp.nextNodeL.prevNodeL=temp.prevNodeL;
        temp.prevNodeL.nextNodeL=temp.nextNodeL;

    }

    // public void displayAllPage() {
    // Node currentNode = head;
    // if (head == null) {
    // System.out.println("Page is empty!");
    // } else {
    // int pageNo = 1;
    // while (currentNode != tail) {
    // if (!currentNode.data.equals("/")) {
    // System.out.println("Page " + pageNo + ": " + currentNode.data);
    // pageNo++;
    // }
    // currentNode = currentNode.nextNode;

    // }
    // System.out.println("Page " + pageNo + ": " + currentNode.data);
    // }
    // }
}
