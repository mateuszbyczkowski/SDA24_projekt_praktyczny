import database.Slip;
import database.SlipDao;

import http.SlipDTo;
import http.SlipResponse;
import http.HttpClient;

import java.util.List;

public class AdviceService {
    private  static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();

    public SlipDTo getRandomAdvice(){
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }

    public void saveAdvise(SlipDTo slip){
        Slip slipToSave = new Slip(slip);
        SlipDao slipDao = new SlipDao();
        slipDao.insertOrUpdate(slipToSave);
    }

    public List<Slip> getAllAdvice(){
        SlipDao slipDao = new SlipDao();
        List<Slip> slips = slipDao.getAll();
        return slips;
    }

    public void deleteID(Long Id) {
        SlipDao slipDao = new SlipDao();
        System.out.println("Succes: " + slipDao.deleteId(Id));
    }

}
