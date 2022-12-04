import java.io.*;
import java.util.*;

class Node {
    CircularDoublyLL data; // or object instead of string
    Node nextNode;
    Node prevNode;
}

class NodeOfLines {
    String dataL;
    NodeOfLines nextNodeL;
    NodeOfLines prevNodeL;
}

public class OnePage {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        ////////////// tozihat barname
        System.out.println(
                "welcome!\nThis is a text editing program that has various features. To use any feature, you must enter its code");
        System.out.println("1.where\n2.next page\n3.previous page\n4.lines\n5.show n lines");

        //////////////
        CircularDoublyLLPage text = new CircularDoublyLLPage(); // change** cir...page
        CircularDoublyLL[] linesOFPage;
        CircularDoublyLL present;
        linesOFPage = new CircularDoublyLL[100]; // 100 be mani tedad khotot nist balke had balaye safhe ra neshan
                                                 // midahad

        ////////////// read a txt file
        Scanner scanner = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\txtEditor\\src\\Example.txt"));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();
        ////////////// be dast avardan tedad safahat va makane hash ha
        int countOfPage = 0;
        int[] indexOFhash = new int[100];
        indexOFhash[0] = 0;
        int k = 1; // shomarande index hash ha
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '#') {
                indexOFhash[k] = i;
                countOfPage++;
                k++;
            }
        }
        // System.out.println(countOfPage);

        ////////////// ejad arraye ey az linked list dakhel safheha be andaze safahat
        for (int i = 0; i <= countOfPage; i++) {
            linesOFPage[i] = new CircularDoublyLL();
        }
        ////////////// save line ha dar linked list marbot be safhe
        String[] line;
        String str;
        int j = 0;
        while (j != countOfPage) {
            str = txt.substring(indexOFhash[j], indexOFhash[j + 1]);
            line = str.split("/");
            for (String a : line) {
                linesOFPage[j].insertLastL(a);
            }
            j++;
        }
        ////////////// save hame ye khat ha(linkedlist dar linked list)
        for (int i = 0; i < countOfPage; i++) {
            text.insertLast(linesOFPage[i]);
        }
        /////////////

        System.out.println("This file has " + countOfPage + " pages. Which page do you want?");
        int safhe = input.nextInt();
        int nextPage=safhe;
        int lastPage=safhe;
        System.out.println("Page: " + safhe);
        present = linesOFPage[safhe - 1];
        linesOFPage[safhe - 1].displayPage();

        int end = 0;

        while (end == 0) {
            System.out.print("----------Please enter the code:");
            int dastoor = input.nextInt();
            if (dastoor == 0) {
                end = 1;
            } else if (dastoor == 1) {
                // WHERE
                for (int i = 0; i < countOfPage; i++) {
                    CircularDoublyLL now = linesOFPage[i];
                    if (present == now) {
                        System.out.print("Page: ");
                        System.out.println(i + 1);
                    }
                }
            } else if (dastoor == 2) {
                int q = nextPage + 1;
                System.out.println("Page: " + q);
                present = linesOFPage[nextPage];
                present.displayPage();
                nextPage++;
            } else if (dastoor == 3) {
                int p = lastPage - 1;
                System.out.println("Page: " + p);
                present = linesOFPage[lastPage-2];
                present.displayPage();
                lastPage--;
            } else if(dastoor==4){
                present.countofLines();
            }else if(dastoor==5){
                System.out.print("How many lines do you want to see?");
                int x=input.nextInt();
                present.showNTHlines(x);
            }
        }
        // Page.displayPage();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++FINISH");
        // text.displayAllPage();

    }
}