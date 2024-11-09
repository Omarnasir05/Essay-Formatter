
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.IOException;
public class Hello{
    public static void main(String[] args){
        Scanner userInput2 = new Scanner(System.in);
        String userConfirmation = "";
        String header = "";

        do{
            header = createHeader();
            System.out.println("Your header will look like this: \n\n\n" + header);
            System.out.println("Does this header look correct? (Yes or No?)");
            userConfirmation = userInput2.nextLine();

            if(userConfirmation.equalsIgnoreCase("No")){

            }
        }
        while(userConfirmation.equalsIgnoreCase("No"));

        
           
        wordDoc(header);

        userInput2.close(); 

    }

    public static String createHeader(){
        Scanner userInput = new Scanner(System.in);
        String name;
        String professor;
        String className;
        LocalDate todaysDate;
        String title;
        String date;

        String header;


        System.out.println("Please submit name: ");
        name = userInput.nextLine();

        System.out.println("Please submit professor name: ");
        professor = userInput.nextLine();

        System.out.println("Please submit class name: ");
        className = userInput.nextLine();

        System.out.println(("Would you like to use todays date? (Yes or No)"));
        todaysDate = LocalDate.now();

        if(userInput.nextLine().equals("Yes")){
                System.out.println(todaysDate);
                date = todaysDate.toString();
        } else {
                System.out.println("Please enter desired date");
                date = userInput.nextLine();
        }
       
        System.out.println("Please submit a title for your essay");
        title = userInput.nextLine();

        
        

        header = name + "\n" + professor + "\n" +  className + "\n" + todaysDate.toString() + "\n" + title;


        

        return header;



    }
        public static void wordDoc(String header){ 

            Scanner userInput3 = new Scanner(System.in);

            System.out.print("Please submit your essay file name:");
            String fileName = userInput3.nextLine();
   
            File file = new File(fileName);

            try{
                XWPFDocument fileInputer = new XWPFDocument(new FileInputStream(fileName));
                fileInputer.write(header);
                fileInputer.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}