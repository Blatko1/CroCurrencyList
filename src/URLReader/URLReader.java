package URLReader;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class URLReader {
    
    public static String[] getValues() throws IOException {
    	
        URL url = new URL("https://www.hnb.hr/tecajn/htecajn.htm");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String line;

            StringBuilder sb = new StringBuilder();
            line = br.readLine();

            while ((line = br.readLine()) != null) {
            	//Pulls out the third coloumn.
				String word = line.substring(line.length()-23, line.length()-15);
                sb.append(word);
                sb.append(System.lineSeparator());
            }
            String[] wrds = sb.toString().split("\n");
            
			return wrds;
        }
    }
}
