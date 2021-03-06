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
        String numStr = ""; //????????? ????????? ??????
        for(int i=0;i<len;i++) {
            //0~9 ?????? ?????? ??????
            String ran = Integer.toString(rand.nextInt(10));
            if(dupCd==1) {
                //?????? ????????? numStr??? append
                numStr += ran;
            }else if(dupCd==2) {
                //????????? ???????????? ????????? ????????? ?????? ????????? ????????????
                if(!numStr.contains(ran)) {
                    //????????? ?????? ????????? numStr??? append
                    numStr += ran;
                }else {
                    //????????? ????????? ???????????? ????????? ?????? ????????????
                    i-=1;
                }
            }
        }
        return numStr;
    }

    //???????????????????????????
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

    //?????????????????????????????????
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

    //????????????
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

    //????????????
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
        params.put("DractOtlt", "(???)????????????");

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
