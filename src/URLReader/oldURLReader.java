package URLReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class oldURLReader {

    public static void main(String[] args) throws IOException {
    	
    	HashMap<Integer, String> currencies = initializeCurrencies();
    	
    	String filePath = readURL();
    	File file = new File(filePath);
    	FileWriter lista = new FileWriter("C:/Users/" + System.getenv("USERNAME") + "/Desktop/TecajnaLista.txt");
    	PrintWriter writer = new PrintWriter(lista);
    	Scanner reader = new Scanner(file);
    	String line;
    	line = reader.nextLine();
    	int i = 0;
    	
    	LocalDate date = LocalDate.now();
    	
    	while(reader.hasNextLine()) {
    		line = reader.nextLine();
    		String[] currentLine = line.split("       ");
    		writer.println(currencies.get(i) + "	" + currentLine[2]);
    		i++;
    	}
    	writer.println();
    	writer.println(date);
    	writer.close();
    	
    }
    
    public static HashMap<Integer, String> initializeCurrencies() {
    	HashMap<Integer, String> map = new HashMap<Integer, String>();
    	map.put(0, "Australija		AUD");
    	map.put(1, "Kanada			CAD");
    	map.put(2, "Češka			CZK");
    	map.put(3, "Danska			DKK");
    	map.put(4, "Mađarska		HUF");
    	map.put(5, "Japan			JPY");
    	map.put(6, "Norveška		NOK");
    	map.put(7, "Švedska			SEK");
    	map.put(8, "Švicarska		CHF");
    	map.put(9, "Velika Britanija	GBP");
    	map.put(10, "SAD			USD");
    	map.put(11, "Bosna i Hercegovina	BAM");
    	map.put(12, "EMU			EUR");
    	map.put(13, "Poljska			PLN");
    	return map;
    }
    
    public static String readURL() throws IOException {
    	
    	final String filePath = "lista.txt";
    	
        URL url = new URL("https://www.hnb.hr/tecajn/htecajn.htm");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String line;

            StringBuilder sb = new StringBuilder();
            
            FileWriter file = new FileWriter(filePath);
            PrintWriter writer = new PrintWriter(file);

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
                writer.println(line);
            }
            writer.close();
            
            return filePath;
        }
    }
	
}
