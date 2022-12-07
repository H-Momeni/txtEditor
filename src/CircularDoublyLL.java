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
        if (x == 1) {
            newNode.nextNodeL = temp;
            newNode.prevNodeL = tail;
            temp.prevNodeL = newNode;
            tail.nextNodeL = newNode;
            head = newNode;
        } else {
            for (int i = 1; i < x - 1; i++) {
                temp = temp.nextNodeL;
            }
            newNode.nextNodeL = temp.nextNodeL;
            (temp.nextNodeL).prevNodeL = newNode;
            temp.nextNodeL = newNode;
            newNode.prevNodeL = temp;
        }
    }

    public void remove(int x, int z) {
        NodeOfLines temp = new NodeOfLines();
        temp = head;
        if (x == 1 && z == 1) {
            head = null;
        } else if (x == 1 && z != 1) {
            (temp.nextNodeL).prevNodeL = tail;
            tail.nextNodeL = temp.nextNodeL;
            head = temp.nextNodeL;
        } else if (x == z) {
            (tail.prevNodeL).nextNodeL = head;
            head.prevNodeL = tail.prevNodeL;
            tail = tail.prevNodeL;
        } else {
            for (int i = 1; i < x; i++) {
                temp = temp.nextNodeL;
            }
            temp.nextNodeL.prevNodeL = temp.prevNodeL;
            temp.prevNodeL.nextNodeL = temp.nextNodeL;
        }
    }

    public void replace(CircularDoublyLL present, String matn, int x, int z) {
        int count = 0;
        String[] line;
        present.remove(x, z);
        if (x == present.countofLines() + 1) {
            while (count != 1) {
                line = matn.split("/");
                for (String a : line) {
                    present.insertLastL(a);
                }
                count++;
            }
        } else {
            while (count != 1) {
                line = matn.split("/");
                for (String a : line) {
                    present.insert(a, x);
                    x++;
                }
                count++;
            }
        }
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

    public void find(CircularDoublyLL linesOFPage, String matn) {
        NodeOfLines temp = new NodeOfLines();
        temp = head;
        for (int z = 0; z < linesOFPage.countofLines(); z++) {
            for (int i = -1; (i = temp.dataL.indexOf(matn, i + 1)) != -1; i++) {
                System.out.println("Line:" + (z + 1) + temp.dataL + "-->index:" + i);
            }
            temp = temp.nextNodeL;
            if (temp == head) {
                break;
            }
        }
    }

    public void findANDreplace(CircularDoublyLL linesOFPage, String matn, String jaygozin) {
        NodeOfLines temp = new NodeOfLines();
        temp = head;
        for (int z = 0; z < linesOFPage.countofLines(); z++) {
            temp.dataL = temp.dataL.replaceAll(matn, jaygozin);
            System.out.println("Line:" + (z + 1) + temp.dataL);
            temp = temp.nextNodeL;
            if (temp == head) {
                break;
            }
        }
    }

    public String save(CircularDoublyLL linesOFPage) {
        NodeOfLines temp = new NodeOfLines();
        String matn = "";
        temp = head;
        for (int z = 0; z < linesOFPage.countofLines(); z++) {
            matn = matn + temp.dataL+"/";
            temp = temp.nextNodeL;
            if (temp == head) {
                break;
            }
        }
        return matn;
    }
}
