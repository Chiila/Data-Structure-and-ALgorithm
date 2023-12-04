import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDirectory {
        
        HashMap<Integer, StudentInformation> hashTable = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        static StudentDirectory directory = new StudentDirectory();
    public static void main(String[] args) throws Exception {
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
        
           System.out.print("Your choice: "); 
           int ans = sc.nextInt();
           
           switch(ans){

            case 1:
             displayStudent();
             break;

            case 2:
             addStudent();
             break;

            case 3:
              searchStudent();
              break;
            
            case 4:
              deleteStudent();
              break;

            case 5: 
               break;
               
            default:
            System.out.println("Input error: Thats not in the choices");
               
           }
           isValid = true;
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
      System.out.print("Input Student Number(key): ");
      int studentNumber = sc.nextInt();
      sc.nextLine();

      System.out.print("Input Student Name: ");
      String studentName = sc.nextLine();
      
      System.out.print("Input Student course: ");
      String course = sc.nextLine();

      StudentInformation studentInfo = new StudentInformation(studentName, course);
      hashTable.put(studentNumber, studentInfo);

      directory.menu();
    }

     void searchStudent(){
      System.out.println("\n--SEARCH STUDENT--");
      System.out.print("Input Student Number(key): ");
      int studentNumber = sc.nextInt();
      if (hashTable.containsKey(studentNumber)) { 
        StudentInformation studentInfo = hashTable.get(studentNumber);
        String studentName = studentInfo.getStudentName();
        String course = studentInfo.getCourse();
        System.out.println("\nStudent Number: " + studentNumber + "\nStudent Name: " + studentName + "\nCourse: " + course);
    } else { 
      System.out.println("\nStudent with Student Number " + studentNumber + " not found."); 
    } 
    directory.menu();



    }

     void deleteStudent(){
      System.out.println("\n--DELETE STUDENT--");
       System.out.print("Input StudentNumber(key): ");
      int studentNumber = sc.nextInt();

      if (hashTable.containsKey(studentNumber)) {
        hashTable.remove(studentNumber);
        System.out.println("\nStudent number: "+studentNumber+" deleted successfully!");
      }else{
        System.out.println("\nStudent number: " +studentNumber+" not found.");
      }
      directory.menu();
    }
    
}
