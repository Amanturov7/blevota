package kg.monitoring.blevota.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/systems")
    public String getSystemData() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://blue-water.asia/api/systems/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        headers.set("Referer", "https://blue-water.asia/?page=system-page-14");

        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }


    @GetMapping("/sensors")
    public String getSensorData() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://blue-water.asia/api/sensors/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");

        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }



    @GetMapping("/hydroposts")
    public String getHydropostData() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://blue-water.asia/api/hydroposts/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }
}
