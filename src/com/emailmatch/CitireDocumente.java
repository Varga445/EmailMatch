package com.emailmatch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CitireDocumente {

    private File file;
    private Scanner scanner;

    CitireDocumente() {
        try {
            file = new File("C:/dev/EmailMatch/readme.txt");
            /*!!!!replace the filepath with your own!!!
             */
            scanner = new Scanner(file);
        } catch (FileNotFoundException err) {
            System.out.println("File not found!");
        }
    }

    public void citire() {
        while (scanner.hasNextLine()) {
            String re = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
            /*general email pattern*/
            Pattern pattern = Pattern.compile(re);
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

    }
}
