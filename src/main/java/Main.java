
public class Main {
    public static void main(String[] args) {
        AdviseClient adviseClient = new AdviseClient();
        Slip slip = adviseClient.fetchRandomAdvise();
        System.out.println(slip.getAdvice());
    }
}
