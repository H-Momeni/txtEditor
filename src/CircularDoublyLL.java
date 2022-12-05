

public class CircularDoublyLL {
    public NodeOfLines head = null;
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

    public int countofLines() {
        NodeOfLines currentNode = head;
        int pageNo = 1;
        if (head == null) {
            pageNo = 0;
        } else {
            while (currentNode != tail) {
                pageNo++;
                currentNode = currentNode.nextNodeL;
            }
        }
        return pageNo;
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
        NodeOfLines temp = new NodeOfLines();
        temp = head;
        newNode.dataL = matn;
        for (int i = 1; i < x; i++) {
            temp = temp.nextNodeL;
        }
        newNode.nextNodeL = temp.nextNodeL;
        (temp.nextNodeL).prevNodeL = newNode;
        temp.nextNodeL = newNode;
        newNode.prevNodeL = temp;
    }

    public void remove(int x) {
        NodeOfLines temp = new NodeOfLines();
        temp = head;
        for (int i = 2; i < x; i++) {
            temp = temp.nextNodeL;
        }
        temp.nextNodeL.prevNodeL = temp.prevNodeL;
        temp.prevNodeL.nextNodeL = temp.nextNodeL;

    }

    public void replace(CircularDoublyLL present, String matn, int x) {
        present.remove(x + 1);
        present.insert(matn, x - 1);
    }

    public void swap(int x, int y) {
        NodeOfLines pos1 = new NodeOfLines();
        NodeOfLines pos2 = new NodeOfLines();
        pos1 = head;
        pos2 = head;
        for (int i = 1; i < x; i++) {
            pos1 = pos1.nextNodeL;
        }
        for (int i = 1; i < y; i++) {
            pos2 = pos2.nextNodeL;
        }
        String val = pos1.dataL;
        pos1.dataL = pos2.dataL;
        pos2.dataL = val;

    }

    public int[] find(CircularDoublyLL linesOFPage, String matn) {
        NodeOfLines temp = new NodeOfLines();
        temp = head;
        int found = 0;
        int[] ans = new int[20];
        int[] empty = { -1 };
        for (int z = 0; z < linesOFPage.countofLines(); z++) {
            
            if (temp.dataL.equals(matn)) {
                ans[found] = z;
                found++;
            }
            temp = temp.nextNodeL;
            if (temp == this.head) {
                break;
            }
        }
        if (found == 0) {
            return empty;
        } else {
            return ans;
        }

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
