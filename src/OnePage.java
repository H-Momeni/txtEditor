import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
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
        int shomarande = 0; // baraye shomordan dar undo
        Stackk undo = new Stackk();

        ////////////// tozihat barname
        System.out.println(
                "welcome!\nThis is a text editing program that has various features. To use any feature, you must enter its code");
        System.out.println(
                "0.end\n1.where\n2.next page\n3.previous page\n4.lines\n5.show n lines\n6.append\n7.insert\n8.remove\n9.replace\n10.swap\n11.find\n12.find and replace\n13.undo\n14.redo\n15.save\n");

        //////////////
        CircularDoublyLLPage text = new CircularDoublyLLPage();
        CircularDoublyLLPage undoTEXT = new CircularDoublyLLPage();
        CircularDoublyLLPage[] matnehame = new CircularDoublyLLPage[30];

        for (int i = 0; i < 30; i++) {
            matnehame[i] = new CircularDoublyLLPage();
        }

        CircularDoublyLL[] linesOFPage;
        CircularDoublyLL[][] lineForundo = new CircularDoublyLL[30][100];
        CircularDoublyLL present;
        linesOFPage = new CircularDoublyLL[100]; // 100 tedad khotot nist balke had balaye safhe ra neshan midahad

        ////////////// read a txt file
        Scanner scanner = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\txtEditor\\src\\Example.txt"));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();

        ////////////// be dast avardan tedad safahat va makane hash ha
        int countOfPage = 0;
        int[] indexOFhash = new int[100];
        int[] indexhashhaUNDO = new int[100];
        indexOFhash[0] = 0;
        indexhashhaUNDO[0] = 0;
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

        for (int l = 0; l < 30; l++) {
            for (int i = 0; i < countOfPage; i++) {
                lineForundo[l][i] = new CircularDoublyLL();
            }
        }

        ////////////// save line ha dar linked list marbot be safhe
        String[] line;
        String[] line1;
        String str;
        String str1;
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
            while (dastoor < 0 || dastoor > 21) {
                System.out.print("Please enter the correct code:");
                dastoor = input.nextInt();
            }
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
                // swap
                System.out.println("Enter the line numbers:");
                int x = input.nextInt();
                int y = input.nextInt();
                present.swap(x, y);
                System.out.println("Page: " + changePage);
                present.displayPage();

            } else if (dastoor == 11) {
                // find
                System.out.println("Enter the text:");
                String matn = input.nextLine();
                matn = matn.trim();
                for (int i = 0; i < countOfPage; i++) {
                    System.out.println("page: " + (i + 1)
                            + "_____________________________________________________________________________");
                    linesOFPage[i].find(linesOFPage[i], matn);
                }

            } else if (dastoor == 12) {
                // find and replace
                System.out.println("Enter the text:");
                String matn = input.nextLine();
                String jaygozin = input.nextLine();
                matn = matn.trim();
                jaygozin = jaygozin.trim();
                for (int i = 0; i < countOfPage; i++) {
                    System.out.println("page: " + (i + 1)
                            + "_____________________________________________________________________________");
                    linesOFPage[i].findANDreplace(linesOFPage[i], matn, jaygozin);
                }

            } else if (dastoor == 13) {
                // undo
                if (shomarande == 0 || shomarande == 1) {
                    System.out.println("Can not undo!");
                } else {
                    undo.pop();
                    undoTEXT = undo.pop();
                    undoTEXT.displayAllPage();
                    present = lineForundo[shomarande - 2][changePage - 1];
                    text.DeletPAGE(changePage, countOfPage);
                    text.insertPAGE(lineForundo[shomarande - 2][changePage - 1], changePage);
                }
                // text.displayAllPage();

            } else if (dastoor == 15) {
                // save
                String matn = "";
                for (int i = 0; i < countOfPage; i++) {
                    matn = matn + linesOFPage[i].save(linesOFPage[i]) + "#/";
                }
                Path path = Paths.get("C:\\Users\\ACER\\OneDrive\\Desktop\\txtEditor\\src\\save.txt");
                try {
                    Files.writeString(path, matn,
                            StandardCharsets.UTF_8);
                    System.out.println("Saved successfully!");
                } catch (IOException ex) {
                    System.out.print("Invalid Path");
                }

            }
            if (6 <= dastoor && dastoor <= 10 || dastoor == 12) {
                int kk = 1;
                int e = 0;
                // text.displayAllPage();
                // undo.push(text);
                String matn = "";
                for (int i = 0; i < countOfPage; i++) {
                    matn = matn + linesOFPage[i].save(linesOFPage[i]) + "#/";
                }

                for (int i = 0; i < matn.length(); i++) {
                    if (matn.charAt(i) == '#') {
                        indexhashhaUNDO[kk] = i;

                        kk++;
                    }
                }

                while (e != countOfPage) {
                    str1 = matn.substring(indexhashhaUNDO[e], indexhashhaUNDO[e + 1]);
                    line1 = str1.split("/");
                    for (String a : line1) {
                        lineForundo[shomarande][e].insertLastL(a);
                    }
                    e++;
                }
                // System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                // System.out.println("shomarande:"+shomarande);
                // for (int l = 0; l < shomarande+1; l++) {
                // for (int i = 0; i < countOfPage; i++) {
                // System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                // lineForundo[l][i].displayPage();
                // }
                // System.out.println("444444444444444444444444444444444444444444444444444444444444444444444");
                // }

                for (int i = 0; i < countOfPage; i++) {
                    matnehame[shomarande].insertLast(lineForundo[shomarande][i]);
                    // System.out.println("***********************i"+i+" j"+changePage);
                    // lineForundo[i][changePage-1].displayPage();

                }
                // System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                // if(shomarande!=0)
                // lineForundo[shomarande][changePage-1].displayPage();
                // matnehame[shomarande].displayAllPage();
                undo.push(matnehame[shomarande]);
                shomarande++;
                // matnehame[shomarande]=text;

                // shomarande++;

            }
            if (dastoor == 20) {
                for (int i = 0; i < matnehame.length; i++) {
                    matnehame[i].displayAllPage();
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                }
            }

        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++FINISH");
    }
}