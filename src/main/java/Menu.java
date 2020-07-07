import database.Slip;
import http.SlipDTo;

import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Menu {

    private static AdviceService adviceService;


    public Menu(AdviceService adviceService) {
        Menu.adviceService = adviceService;
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
                    System.out.println("******Cytat dla Ciebie******");
                    System.out.println(advice);
                    System.out.println("***********************");

                    MenuCase1(randomAdvice);
                    break;
                }
                case 2: {
                    System.out.println("W toku");
                    break;
                }
                case 3:   {
                    List<Slip> allAdvice = adviceService.getAllAdvice();
                    MenuCase3(allAdvice);
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

    private static void MenuCase1(SlipDTo randomAdvice) {
        boolean flaga = true;
        while (flaga){
            System.out.println("wbierz jedną z opcji:");
            System.out.println("1) Losuj następny cytat.");
            System.out.println("2) Dodaj do ulubionych");
            System.out.println("3) Cofnij do menu głównego");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()){
                nextInt = scanner.nextInt();
            }
            switch (nextInt){

                case 1:{
                    randomAdvice = adviceService.getRandomAdvice();
                    String advice = randomAdvice.getAdvice();
                    System.out.println("******Cytat dla Ciebie******");
                    System.out.println(advice);
                    System.out.println("***********************");
                    break;
                }
                case 2:{
                    adviceService.saveAdvise(randomAdvice);
                    break;
                }
                case 3: {
                    flaga = false;
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

    private static void MenuCase3(List<Slip> allAdvice) {
        boolean development = true;
        Long Id;

        while (development) {
            System.out.println();
            System.out.println("New Menu");
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("1. Wyświetl ulubione cytaty");
            System.out.println("2. Usuń cytat z ulubionych");
            System.out.println("0. Zakończ - Powrót do poprzedniego menu");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }
            switch (nextInt) {
                case 0: {
                    development = false;
                    break;
                }
                case 1: {
                    System.out.println();
                    System.out.println("ulubione cytaty");
                    System.out.println(Arrays.toString(allAdvice.toArray()));
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("usuwanie cytatu - prosze podać ID");
                    Id = scanner.nextLong();
                    adviceService.deleteID(Id);
                }
                case -1: {
                    System.out.println("Wpisz liczbę");
                    break;
                }
                default: {
                    System.out.println("Wpisz inny numer.");
                }
            }
        }
    }

}
