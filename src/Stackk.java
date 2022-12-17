import java.util.EmptyStackException;

public class Stackk {

    CircularDoublyLLPage arr[] = new CircularDoublyLLPage[50];
    int index = -1;  //index be khali eshare mikone na pore dar vaghe yeki ghable top

    public void push(CircularDoublyLLPage element) {
        // element.displayAllPage();
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++index] = element;
        // arr[index].displayAllPage();

    }

    public CircularDoublyLLPage pop() {

        if (isEmpty()) {
            System.out.println(" changes are not available!");
        }
        return arr[--index];
        
        // for(int i=0;i<index;i++){
        // System.out.println(i+"
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        // arr[i].displayAllPage();

        // }
        //index=index-1;
        
        // arr[index--].displayAllPage();
    }

    // public CircularDoublyLLPage peek() {

    //     if (isEmpty()) {
    //         throw new EmptyStackException();
    //     }
    //     return arr[index];
    // }

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