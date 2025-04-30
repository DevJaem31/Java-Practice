
package palindrome_checker;

import java.io.*;
import java.util.*;

public class Palindrome_Checker {
    public static void main(String[] args) {
        File toCheck = new File("Words.txt");
        ArrayList<String> checked = new ArrayList<>();
        
        //Reads the given from the file and store it in an ArrayList
        try {
            Scanner checker = new Scanner(toCheck);
            
            while (checker.hasNext()){
                String items = checker.nextLine();
                String reverse = "";
                
                int itemLength = items.length();
                
                for (int x = (itemLength - 1); x >= 0; --x){
                    reverse = reverse + items.charAt(x);
                }
                
                if (reverse.toLowerCase().equals(items.toLowerCase())){
                    checked.add(reverse);
                }
                
            }
            
            checker.close();
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        //Writes the result to a new text file
        try {
            FileWriter writer = new FileWriter("checked_palindrome.txt");
            
            for (String palindrome : checked){
                writer.write(palindrome + System.lineSeparator());
                System.out.println(palindrome);
            }
            
            writer.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
        
        
    }
    
}
