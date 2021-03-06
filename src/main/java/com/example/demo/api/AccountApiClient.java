package com.example.demo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class AccountApiClient {
    private final RestTemplate restTemplate;
    ObjectMapper objectMapper = new ObjectMapper();

    private final String OpenFinAccountDirect = "OpenFinAccountDirect";
    private final String CheckOpenFinAccountDirect = "CheckOpenFinAccountDirect";
    private final String InquireBalance = "InquireBalance";
    private final String DrawingTransfer = "DrawingTransfer";

    private final String DrawingTransferA = "DrawingTransferA";
    private final String ReceivedTransferA = "ReceivedTransferA";


    private final String AccessToken = "45d02fdd0348dfad616c87bbfdcc2c6476e26c07ac72037f746471dfa0773d4b";
    private final String NHApiUrl_finAccount = "https://developers.nonghyup.com/OpenFinAccountDirect.nh";
    private final String NHApiUrl_confirmAccount = "https://developers.nonghyup.com/CheckOpenFinAccountDirect.nh";
    private final String NHApiUrl_inquireBalance = "https://developers.nonghyup.com/InquireBalance.nhh";
    private final String NHApiUrl_drawingTransfer = "https://developers.nonghyup.com/DrawingTransfer.nh";


    SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat format2 = new SimpleDateFormat("HHmmss");
    Calendar today = Calendar.getInstance();
    private final String Tsymd = format1.format(today.getTime());
    private final String Trtm = format2.format(today.getTime());

    private final String Iscd = "001066";
    private final String FintechApsno = "001";

    public static String numberGen(int len, int dupCd ) {
        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수
        for(int i=0;i<len;i++) {
            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));
            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }

    //핀어카운트직접발급
    public String requestFinAccount(Map<String, String> param) {

        Map<String, String> header = new HashMap<>();
        header.put("ApiNm", OpenFinAccountDirect);
        header.put("Tsymd", Tsymd);
        header.put("Trtm", Trtm);
        header.put("Iscd", Iscd);
        header.put("FintechApsno", FintechApsno);
        header.put("ApiSvcCd", DrawingTransferA);
        header.put("IsTuno", numberGen(10,2));
        header.put("AccessToken", AccessToken);

        Map<String, Object> params = new HashMap<>();
        params.put("Header", header);
        params.put("DrtrRgyn", "Y");
        params.put("BrdtBrno", param.get("BrdtBrno"));
        params.put("Bncd", param.get("Bncd"));
        params.put("Acno", param.get("Acno"));

        String body = null;
        try {
            body = objectMapper.writeValueAsString(params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        HttpEntity entity = new HttpEntity(body, headers);
        String result = restTemplate.postForEntity(NHApiUrl_finAccount, entity, String.class).getBody();
        return result;
    }

    //핀어카운트직접발급확인
    public String confirmFinAcoount(Map<String, String> param){
        Map<String, String> header = new HashMap<>();
        header.put("ApiNm", CheckOpenFinAccountDirect);
        header.put("Tsymd", Tsymd);
        header.put("Trtm", Trtm);
        header.put("Iscd", Iscd);
        header.put("FintechApsno", FintechApsno);
        header.put("ApiSvcCd", DrawingTransferA);
        header.put("IsTuno", numberGen(10,2));
        header.put("AccessToken", AccessToken);

        Map<String, Object> params = new HashMap<>();
        params.put("Header", header);
        params.put("BrdtBrno", param.get("BrdtBrno"));
        params.put("Rgno", param.get("Rgno"));

        String body = null;
        try {
            body = objectMapper.writeValueAsString(params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        HttpEntity entity = new HttpEntity(body, headers);
        String result = restTemplate.postForEntity(NHApiUrl_confirmAccount, entity, String.class).getBody();
        JSONObject jObject = new JSONObject(result);
        String FinAcno = jObject.getString("FinAcno");
        return FinAcno;
    }

    //잔액조회
    public String inquireBalance(Map<String, String> param) {

        Map<String, String> header = new HashMap<>();
        header.put("ApiNm", "InquireBalance");
        header.put("Tsymd", Tsymd);
        header.put("Trtm", Trtm);
        header.put("Iscd", Iscd);
        header.put("FintechApsno", FintechApsno);
        header.put("ApiSvcCd", ReceivedTransferA);
        header.put("IsTuno", numberGen(10,2));
        header.put("AccessToken", AccessToken);

        Map<String, Object> params = new HashMap<>();
        params.put("Header", header);
        params.put("FinAcno", param.get("FinAcno"));

        String body = null;
        try {
            body = objectMapper.writeValueAsString(params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        HttpEntity entity = new HttpEntity(body, headers);
        String result = restTemplate.postForEntity(NHApiUrl_inquireBalance, entity, String.class).getBody();
        return result;
    }

    //출금이체
    public String drawingTransfer(Map<String, String> param, String finAcno) {
        Map<String, String> header = new HashMap<>();
        header.put("ApiNm", DrawingTransfer);
        header.put("Tsymd", Tsymd);
        header.put("Trtm", Trtm);
        header.put("Iscd", Iscd);
        header.put("FintechApsno", FintechApsno);
        header.put("ApiSvcCd", DrawingTransferA);
        header.put("IsTuno", numberGen(10,2));
        header.put("AccessToken", AccessToken);

        Map<String, Object> params = new HashMap<>();
        params.put("Header", header);
        params.put("FinAcno", finAcno);
        params.put("Tram", param.get("Tram"));
        params.put("DractOtlt", "(주)놀아보새");

        String body = null;
        try {
            body = objectMapper.writeValueAsString(params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(body);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        HttpEntity entity = new HttpEntity(body, headers);
        String result = restTemplate.postForEntity(NHApiUrl_drawingTransfer, entity, String.class).getBody();
        return result;
    }
}
