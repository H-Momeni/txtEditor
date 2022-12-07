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
        System.out.println(
                "0.end\n1.where\n2.next page\n3.previous page\n4.lines\n5.show n lines\n6.append\n7.insert\n8.remove\n9.replace\n10.swap\n11.find\n");

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

        ////////////// ejad arraye ey az linked list dakhel safheha be andaze safahat
        for (int i = 0; i <= countOfPage; i++) {
            linesOFPage[i] = new CircularDoublyLL();
        }
        ////////////// save line ha dar linked list marbot be safhe
        String[] line;
        String[] line1;
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

        System.out.print("This file has " + countOfPage + " pages. Which page do you want?");
        int safhe = input.nextInt();
        int changePage = safhe;
        while (safhe < 1 || countOfPage < safhe) {
            System.out.println("Please enter an existing page. ");
            safhe = input.nextInt();
            changePage = safhe;
        }

        System.out.println("Page: " + safhe);
        present = linesOFPage[safhe - 1];
        linesOFPage[safhe - 1].displayPage();

        int end = 0;

        while (end == 0) {
            System.out.print("----------Please enter the code:");
            int dastoor = input.nextInt();
            if (dastoor == 0) {
                // end program
                end = 1;

            } else if (dastoor == 1) {
                // where page
                text.where(present);

            } else if (dastoor == 2) {
                // next page
                present = text.nextPage(present);
                present.displayPage();
                changePage++;

            } else if (dastoor == 3) {
                // last page
                present = text.previousPage(present, countOfPage);
                present.displayPage();
                changePage--;

            } else if (dastoor == 4) {
                // count lines each page
                int x = present.countofLines();
                System.out.println(x + " Lines");

            } else if (dastoor == 5) {
                // show nth line
                System.out.print("How many lines do you want to see?");
                int x = input.nextInt();
                while (x < 1 || x > present.countofLines()) {
                    System.out.println("Please enter an existing line.");
                    x = input.nextInt();
                }
                present.showNTHlines(x);

            } else if (dastoor == 6) {
                // append to the end of the text
                String append = input.nextLine();
                int count = 0;
                while (count != 1) {
                    line = append.split("/");
                    for (String a : line) {
                        present.insertLastL(a);
                    }
                    count++;
                }
                System.out.println("Page: " + changePage);
                present.displayPage();

            } else if (dastoor == 7) {
                // insert to specific line
                System.out.println("Enter the line number and text:");
                int x = input.nextInt();
                String matn = input.nextLine();
                while (x < 1 || x > present.countofLines() + 1) {
                    System.out.println("Please enter an existing line.");
                    x = input.nextInt();
                    matn = input.nextLine();
                }
                if (x == present.countofLines() + 1) {
                    present.insertLastL(matn);
                } else {
                    present.insert(matn, x);
                }
                System.out.println("Page: " + changePage);
                present.displayPage();

            } else if (dastoor == 8) {
                // remove a line
                int z = present.countofLines();
                if (present.countofLines() == 0) {
                    System.out.println("This page has no lines.");
                } else {
                    System.out.println("Enter the line number:");
                    int x = input.nextInt();
                    while (x < 1 || x > present.countofLines()) {
                        System.out.println("Please enter an existing line.");
                        x = input.nextInt();
                    }
                    present.remove(x, z);
                    System.out.println("Page: " + changePage);
                    present.displayPage();
                }

            } else if (dastoor == 9) {
                // replace 
                System.out.println("Enter the line number and text:");
                int z = present.countofLines();
                int x = input.nextInt();
                String matn = input.nextLine();
                while (x < 1 || x > present.countofLines()) {
                    System.out.println("Please enter an existing line.");
                    x = input.nextInt();
                    matn = input.nextLine();
                }
                present.replace(present, matn, x, z);
                System.out.println("Page: " + changePage);
                present.displayPage();

            } else if (dastoor == 10) { 
                //swap
                System.out.println("Enter the line numbers:");
                int x = input.nextInt();
                int y = input.nextInt();
                present.swap(x, y);
                System.out.println("Page: " + changePage);
                present.displayPage();
            } else if (dastoor == 11) { // dastor halate mokhtalefi dard ezafe shodan be aval akhar safhe khali
                System.out.println("Enter the text:");
                String matn = input.nextLine();
                int[] khat = new int[50];
                int counter = 0;
                for (int i = 0; i < countOfPage; i++) {
                    System.out.println(i + "\t");
                    khat = linesOFPage[i].find(linesOFPage[i], matn);
                    // System.out.println(khat[0]+" "+khat[1]+" "+khat[2]);
                    for (int z = 0; z < khat.length; z++) {
                        if (khat[z] > 0)
                            System.out.println(" line->" + khat[z] + "\n");
                    }

                    // if(khat==-1){
                    // System.out.println("oh");
                    // }

                }
            }

        }
        // Page.displayPage();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++FINISH");
        // text.displayAllPage();

    }
}