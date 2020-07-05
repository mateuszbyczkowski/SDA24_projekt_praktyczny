import database.HibernateUtil;
import database.Slip;
import http.SlipDTo;
import http.SlipResponse;
import http.HttpClient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.RollbackException;

public class AdviceService {
    private  static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();

    public SlipDTo getRandomAdvice(){
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }

    public void saveAdvise(SlipDTo slip){
        Slip slipToSave = new Slip(slip);
    }
}
