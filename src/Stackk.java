public class Stackk {

    CircularDoublyLLPage arr[] = new CircularDoublyLLPage[50];
    int index = -1; // index be khali eshare mikone na pore dar vaghe yeki ghable top

    public void push(CircularDoublyLLPage element) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++index] = element;
    }

    public CircularDoublyLLPage pop() {
        if (isEmpty()) {
            System.out.println(" changes are not available!");
        }
        return arr[--index];
    }

    public boolean isEmpty() {
        if (index == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (index == 50) {
            return true;
        }
        return false;
    }

    public int size() {
        return index;
    }
}