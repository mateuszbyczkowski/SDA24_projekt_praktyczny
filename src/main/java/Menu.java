import database.Slip;
import http.SlipDTo;

import java.util.Scanner;


public class Menu {

    private static AdviceService adviceService;


    public Menu(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    public static void displayMenu(){
        boolean continuing = true;

        while(continuing){
            System.out.println("Advice Book");
            System.out.println("wbierz jedną z opcji:");
            System.out.println("1) Wylosuj cytat.");
            System.out.println("2) Wyszukaj cytat");
            System.out.println("3) Moje cytaty");
            System.out.println("0) Zakończ"); //eksport cytatów, wyświetlanie, usuwanie


            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()){
                nextInt = scanner.nextInt();
            }

            switch (nextInt){

                case 0: {
                    continuing = false;
                    break;
                }
                case 1: {
                    SlipDTo randomAdvice = adviceService.getRandomAdvice();
                    String advice = randomAdvice.getAdvice();
                    adviceService.saveAdvise(randomAdvice);
                    System.out.println("******Cytat dla Ciebie******");
                    System.out.println(advice);
                    System.out.println("***********************");


                    break;
                }
                case 2: {
                    System.out.println("W toku");
                    break;
                }
                case 3:   {
                    System.out.println("W toku");
                    break;
                }
                case -1:{
                    System.out.println("Wpisz liczbę");
                    break;
                }
                default:{
                    System.out.println("Wpisz inny numer.");
                }
            }
        }
    }


}
