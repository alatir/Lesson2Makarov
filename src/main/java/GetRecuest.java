import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRecuest {
    static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) throws ParseException {
        CloseableHttpResponse respOne = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=правильно+или+нет");
            respOne = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(respOne.getEntity()));
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                respOne.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}