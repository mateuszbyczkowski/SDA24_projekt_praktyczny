public class AdviceService {
    private  static final String URL = "https://api.adviceslip.com/";
    private final HttpClient  httpClient = new HttpClient();

    public Slip getRandomAdvice(){
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }
}
