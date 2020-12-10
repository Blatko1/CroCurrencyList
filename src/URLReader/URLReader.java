package URLReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class URLReader {

    private static final HashMap<Integer, String> map = new HashMap<>();

    public URLReader(){
        map.put(0, "Australija AUD");
        map.put(1, "Kanada CAD");
        map.put(2, "Češka CZK");
        map.put(3, "Danska DKK");
        map.put(4, "Mađarska UF ");
        map.put(5, "Japan JPY");
        map.put(6, "Norveška NOK");
        map.put(7, "Švedska SEK");
        map.put(8, "Švicarska CHF");
        map.put(9, "Velika Britanija GBP");
        map.put(10, "SAD USD");
        map.put(11, "Bosna i Hercegovina BAM");
        map.put(12, "EMU EUR");
        map.put(13, "Poljska PLN");
    }

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
            
			return sb.toString().split("\n");
        }
    }

    public static String getCurrencie(int i) {
        return map.get(i);
    }

    public static HashMap<Integer, String> getMap() {
        return map;
    }
}
