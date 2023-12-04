import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDirectory {
        
        HashMap<Integer, StudentInformation> hashTable = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        static StudentDirectory directory = new StudentDirectory();
    public static void main(String[] args) throws Exception {
      System.out.println("---SNEKI'S UNIVERSITY DATABASE---");
      directory.menu();
    }

     void menu(){
        boolean isValid = false;
        System.out.println("\n1. DISPLAY"); 
        System.out.println("2. ADD"); 
        System.out.println("3. SEARCH"); 
        System.out.println("4. DELETE"); 
        System.out.println("5. EXIT"); 

        while(!isValid){

          try {
           System.out.print("Your choice: "); 
           int ans = sc.nextInt();
           
           switch(ans){
            case 1:
             displayStudent();
             isValid = true;
             break;

            case 2:
             addStudent();
             isValid = true;
             break;

            case 3:
              searchStudent();
              isValid = true;
              break;
            
            case 4:
              deleteStudent();
              isValid = true;
              break;

            case 5: 
              System.out.println("Exiting...");
              isValid = true;
               break;
               
            default:
            System.out.println("Input error: Thats not in the choices");
           }
          } catch (java.util.InputMismatchException e) {
            System.out.println("Input error: Please enter a valid number.");
            sc.nextLine();
          }
        }       
    }

     void displayStudent(){
      System.out.println("\n--STUDENTS--");
      if(hashTable.isEmpty()){
        System.out.println("Students records is empty.\n");
        directory.menu();
      }else{
        for (Map.Entry<Integer, StudentInformation> entry : hashTable.entrySet()) {
        Integer key = entry.getKey();
        StudentInformation studentInfo = entry.getValue();
        String studentName = studentInfo.getStudentName();
        String course = studentInfo.getCourse();
        System.out.println("Student Number: " + key + "\nStudent Name: " + studentName + "\nCourse: " + course);
        System.out.println("---------------------------");
    }
    directory.menu();
      }
    }

     void addStudent(){
      System.out.println("\n--ADD STUDENT--");

      while(true){
      try {
       System.out.print("Input Student Number(key): ");
       int studentNumber = sc.nextInt();
       sc.nextLine();
     
      System.out.print("Input Student Name: ");
      String studentName = sc.nextLine();
      
      System.out.print("Input Student course: ");
      String course = sc.nextLine();

      StudentInformation studentInfo = new StudentInformation(studentName, course);
      hashTable.put(studentNumber, studentInfo);

     System.out.println("\n"+studentNumber +": " + studentName + " has been added.\n");

     System.out.print("Do you want to add again? Y/N: ");
     char choice = sc.next().charAt(0);
     choice = Character.toLowerCase(choice);
     if(choice == 'n'){
       directory.menu();
       break;
     }
      }catch (java.util.InputMismatchException e) {
            System.out.println("Input error: Please enter a valid input.");
            sc.nextLine();
      }
      }
    }

     void searchStudent(){
      System.out.println("\n--SEARCH STUDENT--");

      while(true){
        try {
          System.out.print("Input Student Number(key): ");
          int studentNumber = sc.nextInt();

        if (hashTable.containsKey(studentNumber)) { 
          StudentInformation studentInfo = hashTable.get(studentNumber);
          String studentName = studentInfo.getStudentName();
          String course = studentInfo.getCourse();
          System.out.println("\nStudent Number: " + studentNumber + "\nStudent Name: " + studentName + "\nCourse: " + course);
       } else { 
      System.out.println("\nStudent with studentnumber " + studentNumber + " not found."); 
    } 

    System.out.print("\nDo you want to search again? Y/N: ");
    char choice = sc.next().charAt(0);
     choice = Character.toLowerCase(choice);
     if(choice == 'n'){
       directory.menu();
       break;
     }
        } catch (java.util.InputMismatchException e) {
          System.out.println("Input error: Please enter a valid input.");
          sc.nextLine();
        }
      }
    }

     void deleteStudent(){
      System.out.println("\n--DELETE STUDENT--");
      while(true){
        try {
           System.out.print("Input StudentNumber(key): ");
           int studentNumber = sc.nextInt();

      if (hashTable.containsKey(studentNumber)) {
        hashTable.remove(studentNumber);
        System.out.println("\nStudent number: "+studentNumber+" deleted successfully!");
      }else{
        System.out.println("\nStudent number: " +studentNumber+" not found.");
      }

    System.out.print("\nDo you want to delete again? Y/N: ");
    char choice = sc.next().charAt(0);
     choice = Character.toLowerCase(choice);
     if(choice == 'n'){
       directory.menu();
       break;
     }
        }catch (java.util.InputMismatchException e) {
          System.out.println("Input error: Please enter a valid input.");
          sc.nextLine();
        }
      }
     }
  }   
     
    

