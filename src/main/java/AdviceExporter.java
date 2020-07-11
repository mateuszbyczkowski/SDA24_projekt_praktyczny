import database.Slip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


//| slipId = 5 | id = 10 | advice = advice |
public class AdviceExporter {

    private final String dirPath = "D:\\Kurs SDA\\Projekt praktyczny\\";
    public void exportToFile(List<Slip> allAdvice){
        try {
            PrintWriter zapis = new PrintWriter(dirPath + "cytaty.txt");
            for (Slip slips: allAdvice) {
                zapis.println("| slipId = " + slips.getSlipId()+ " | id = " + slips.getId() + " | advice = " + slips.getAdvice());
            }
            zapis.close();
        }catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku!");
        }
    }
}
