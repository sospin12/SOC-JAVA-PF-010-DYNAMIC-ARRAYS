import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        menu(scan);
    }

    public static void fisrt(Scanner scan) {// CREATE A ARRAYLIST TO FILL WITH NAMES AND PRINT IT.
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Exercise 1: ");

        System.out.println("Write names until 'END'");
        String student;

        do {// DO WHILE STRUCTURE
            student = scan.nextLine();

            if (student.equals("END")) {// BREAK CONDITION, IF "END" IS TYPED.
                break;
            }

            if (!student.matches(".*[0-9].*") && !student.matches("")) {// IN CASE OF FILLING WITH NUMBERS AND EMPTY
                                                                        // THEN DO NOT STORAGE THE NUMBER.
                arr.add(student);
            }

        } while (true);// ALWAYS RUNNING UNTIL BREAK

        for (String value : arr) {
            System.out.println(value);
        }
    }

    public static void second(Scanner scan) {// CREATE A ARRAYLIST TO FILL WITH NAMES AND PRINT IT USIGN OTHER METHOD.
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Exercise 1: ");

        System.out.println("Escribe el nombre de los estudiantes, finaliza con (FIN)");
        String student;

        do {
            student = scan.nextLine();

            if (student.equals("FIN")) {
                break;
            }

            if (!student.matches(".*[0-9].*") && !student.matches("")) {
                arr.add(student);
            }

        } while (true);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void third(Scanner scan) {// FIRST FUNCTION: CREATE A STATIC ARRAY, SECOND FUNCTION: CHAGE TO A
                                            // DYNAMIC ARRAY, THIRD FUNCTION: PRINT THE ARRAY.
        System.out.println("Enter the length of the static array: ");
        int n = scan.nextInt();
        int[] arr = createArray(n, scan);
        ArrayList<Integer> arr2 = convertArrStatic(arr);
        printArrDyn(arr2);

    }

    public static void fourth(Scanner scan) {// FIRST FUNCTION: CREATE A DYNAMIC ARRAY, SECOND FUNCTION: CHAGE TO A
                                             // STATIC ARRAY, THIRD FUNCTION: PRINT THE ARRAY.
        System.out.println("Enter the array length: ");
        int n = scan.nextInt();
        ArrayList<Integer> arr = createArray2(scan, n);
        int[] arr2 = convertArrDyn(arr);
        printArrSta(arr2);
    }

    public static void fifth(Scanner scan) {// MATH EXCERSICES FROM A READEN DYNAMIC ARRAY
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter number until you type '0' or a negative number: ");
        // int n = 0;
        do {// DO WHILE
            
            try {// TRY TO RUN THE INNER PROGRAM
                int n = scan.nextInt();
                if (n <= 0)
                    break; // BREAK CONDITION IF LOWER OR EQUAL TO 0.
                
                arr.add(n);

            } catch (Exception e) {// CATCHES THE ERROR
                System.out.println(e.getLocalizedMessage());
                System.out.println("Please enter a valid value.");
                scan.next();// CLEAR THE LAST VALUE
            }

        } while (true);

        System.out.println("You have entered: " + arr.size() + " numbers.");
        int sum = arr.stream().collect(Collectors.summingInt(Integer::intValue));//  **** NEW METHOS TO ADD ALL THE ELEMENTS IN THE ARRAY ****
        System.out.println("the sum of the given number is: " + sum);
        int prom = sum / arr.size();
        System.out.println("The average is: " + sum / arr.size());
        int cont = 0;

        for (int i = 0; i < arr.size(); i++) {//COUNT THE NUMBERS HIGHER THAN THE AVERAGE
            if (arr.get(i) < prom) {//COMPARE THE PROME AND THE i VALUE OF THE ARRAY
                cont++;
            }
        }
        System.out.println("The number of elements lower than the average are: " + cont);
        System.out.println("The equal o greater elements to the average are: " + (arr.size() - cont));//IF THE REST OF THE NUMBER ARE GREATHER THAN THE AVERAGE

        System.out.println("The elements lower than the average are: ");//PRINT THE NUMBERS 
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < prom) {
                System.out.println(arr.get(i));//PRINT NUMBER LOWER THAN THE AVERAGE
            }
        }

        System.out.println("The equal o greater elements to the average are: ");
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= prom) {// PRINT THE NUMBERS HIGHER O EQUAL THE AVERAGE
                System.out.println(arr.get(i));
            }
        }
    }

    public static void menu(Scanner scan) {// MENU TU SWITCH WICH EXCERCISE TO RUN. ALL THE VARIABLES ARE STATIC TO EACH
                                           // METHOD
        System.out.println("enter the excercise number: ");
        System.out.println("1. Excersice 1 ");
        System.out.println("2. Excersice 2 ");
        System.out.println("3. Excersice 3 ");
        System.out.println("4. Excersice 4 ");
        System.out.println("5. Excersice 5 ");
        System.out.println("6. End the program ");

        int num = scan.nextInt();
        switch (num) {
            case 1:
                fisrt(scan);
                menu(scan);
            case 2:
                second(scan);
                menu(scan);
            case 3:
                third(scan);
                menu(scan);
            case 4:
                fourth(scan);
                menu(scan);
            case 5:
                fifth(scan);
                menu(scan);
            case 6:
                System.out.println("Close the program...");
                break;
        }
    }

    //INDEPENDENT FUNCTIONS.

    public static int[] createArray(int n, Scanner scan) {// CREATES A 1D STATIC ARRAY OF n ELEMENTS.
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static ArrayList<Integer> convertArrStatic(int[] arr) {// CONVERT FORM STATIC ARRAY TO A DYNAMIC ARRAY.
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int value : arr) {
            arr2.add(value);
        }
        return arr2;
    }

    public static void printArrDyn(ArrayList<Integer> arr) {// PRINT A DYNAMIC ARRAY
        for (int value : arr) {
            System.out.println(value);
        }

    }

    public static ArrayList<Integer> createArray2(Scanner scan, int n) {// CREATE A n ELEMENTS DYNAMIC ARRAY
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add((int) (Math.random() * 100));
        return arr;
    }

    public static int[] convertArrDyn(ArrayList<Integer> arr) {// CONVERT FROM A DYNAMIC ARRAY TO A STATIC ARRAY
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = arr.get(i);
        return arr2;
    }

    public static void printArrSta(int[] arr) {// PRINT THE VALUES OF GIVEN STATIC ARRAY
        for (int value : arr) {
            System.out.println(value);
        }

    }

}
