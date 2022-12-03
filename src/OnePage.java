import java.io.*;
import java.util.*;

class Node {
    CircularDoublyLL data; // or object instead of string   
    Node nextNode;
    Node prevNode;
}

class NodeOfLines{
    String dataL; 
    NodeOfLines nextNodeL;
    NodeOfLines prevNodeL;
}
public class OnePage {
    public static void main(String[] args) throws IOException {

        CircularDoublyLLPage text = new CircularDoublyLLPage();  //change** cir...page
        CircularDoublyLL []linesOFPage;
        linesOFPage=new CircularDoublyLL[100];  //100 be mani tedad khotot nist balke had balaye safhe ra neshan midahad

         //////////////read a txt file
        Scanner scanner = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\txtEditor\\src\\Example.txt"));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();
        //////////////be dast avardan tedad safahat va makane hash ha
        int countOfPage=0;
        int []indexOFhash=new int[100];
        indexOFhash[0]=0;
        int k=1; //shomarande index hash ha
        for (int i = 0; i < txt.length(); i++) {
            if(txt.charAt(i)=='#'){
                indexOFhash[k]=i;
                countOfPage++;
                k++;
            }
        }
         //////////////ejad arraye ey az linked list dakhel safheha be andaze safahat
        for(int i=0;i<=countOfPage;i++){
            linesOFPage[i]=new CircularDoublyLL();     
        }
        //////////////save line ha dar linked list marbot be safhe
        String[] line;
        String str;
        int j=0;
        while(j!=countOfPage){
            str = txt.substring(indexOFhash[j], indexOFhash[j+1]);
            line = str.split("/");
            for (String a : line) {
                linesOFPage[j].insertLastL(a);
            }
            j++;
        }
        linesOFPage[0].displayPage();
        //////////////save hame ye khat ha(linkedlist dar linked list)
        for(int i=0;i<=countOfPage;i++){
            text.insertLast(linesOFPage[i]);
        }

        // Page.displayPage();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //text.displayAllPage();

    }
}