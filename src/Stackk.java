import java.util.EmptyStackException;

public class Stackk {

    CircularDoublyLLPage arr[]=new CircularDoublyLLPage[50];
    int index = 0;

    public void push(CircularDoublyLLPage element) {
        // element.displayAllPage();
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index++] = element;
        //arr[index].displayAllPage();
       
    }

    public CircularDoublyLLPage pop() {
        
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // for(int i=0;i<index;i++){
        //     System.out.println(i+"    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        //     arr[i].displayAllPage();

        // }
        return arr[--index];
       // arr[index--].displayAllPage();
    }

    // public void printerarr() {
    // if (isEmpty()) {
    // System.out.print("ohhhh");
    // throw new EmptyStackException();
    // }

    // if (arr.length == 0)
    // System.out.print("ohhhh");
    // else
    // for (int i = 0; i < arr.length; i++) {
    // arr[i].displayAllPage();
    // }
    // }

    /*
     * public CircularDoublyLLPage peek() {
     * 
     * if (isEmpty()) {
     * throw new EmptyStackException();
     * }
     * return arr[--index];
     * }
     */

    public boolean isEmpty() {
        if (index == 0) {
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