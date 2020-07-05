import database.HibernateUtil;
import database.Slip;
import http.SlipResponse;
import http.HttpClient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.RollbackException;

public class AdviceService {
    private  static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();

    public Slip getRandomAdvice(){
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }

    public void saveAdvise(Slip slip){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();


            transaction.commit();
        } catch (IllegalStateException | RollbackException ise) {
            System.err.println("Błąd wstawiania rekordu.");
            ise.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
