

package hextodecimalconverter;

import java.util.*;
import java.io.*;

public class HexToDecimalConverter {

    public static void main(String[] args) {
        ArrayList results = new ArrayList<>();
        
        File input = new File("Numbers.txt");
        
        try {
            Scanner inputReader = new Scanner(input);
            
            while (inputReader.hasNext()){
            String lineRed = inputReader.nextLine();
            
            String inputPart = "";
            int radix = 10;
            
            if (lineRed.startsWith("0b")){
                inputPart = lineRed.substring(2);
                radix = 2;
            } else if (lineRed.startsWith("0o")) {
                inputPart = lineRed.substring(2);
                radix = 8;
            } else if (lineRed.startsWith("0x")) {
                inputPart = lineRed.substring(2);
                radix = 16;
            } else if (lineRed.startsWith("0d")) {
                inputPart = lineRed.substring(2);
                radix = 10;
            } else {
                inputPart = lineRed;
                radix = 10;
            }
            
            int decimal = Integer.parseInt(inputPart, radix);
            String octal = Integer.toOctalString(decimal);
            String binary = Integer.toBinaryString(decimal);
            String hex = Integer.toHexString(decimal).toUpperCase();
            
            
            
            results.add("Input: " + lineRed + System.lineSeparator() + "Decimal: " + decimal + System.lineSeparator() + "Octal: " + octal + System.lineSeparator() + "Binary: " + binary + System.lineSeparator() + "Hexadecimal: " + hex + System.lineSeparator() + System.lineSeparator());   
            }
            
            inputReader.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            File convertedNumbers = new File("ConvertedNumbers.txt"); 
            FileWriter writer = new FileWriter(convertedNumbers);
            
            for (Object result : results) {
                writer.write((String) result);
            }
            
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}