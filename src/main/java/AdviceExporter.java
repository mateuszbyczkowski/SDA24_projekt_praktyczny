import database.Slip;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


//| slipId = 5 | id = 10 | advice = advice |
public class AdviceExporter {

    public void exportToFile(List<Slip> allAdvice) {
        try {
            String dirPath = PropertiesManager.getProperty("dirPath");

            PrintWriter zapis = new PrintWriter(dirPath + "cytaty.txt");
            for (Slip slips : allAdvice) {
                zapis.println("| slipId = " + slips.getSlipId() + " | id = " + slips.getId() + " | advice = " + slips.getAdvice());
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
        }
    }
}
