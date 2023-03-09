package kr.co.swiftER.controller.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.swiftER.vo.ErItemVO;
import kr.co.swiftER.vo.ErResultVO;

@Controller
public class ErRestController {

	@Value("${restApi.key}")
    private String restApiKey;
    
    @Value("${restApi.erbasisUrl}")
    private String erbasisUrl;
    
    @Value("${restApi.erdetailUrl}")
    private String erdetailUrl;
    
    @Value("${restApi.erlocationUrl}")
    private String erlocationUrl;
    
	@PostMapping("search/erSearch")
	@ResponseBody
	public Map<String, Object> erSearch(Model model, String city, String town) throws IOException{
		
        Map<String, Object> result = new HashMap<String, Object>();    
        HttpURLConnection connect = null;
        
        String [] arrUrl = {erbasisUrl, erdetailUrl, erlocationUrl};
        String [] arrName = {"BASIS", "DETAIL", "LOACTION"};

        String pageNo = "1";
        String numOfRows = "1000";
        
        try {
                String urlstr = arrUrl[0] + restApiKey + "&STAGE1=" + city + "&STAGE2=" + town 
                        + "&pageNo=" + pageNo + "&numOfRows=" + numOfRows ;
                        //GET방식으로 받게끔 되어있는 API라서 URL로 달 수 밖에 없다.
                        //returnType을 Json으로 받고 싶다면 "&_returnType=json"를 추가해주면 된다.
                URL url = new URL(urlstr); 
                
                connect = (HttpURLConnection) url.openConnection();
                connect.setRequestMethod("GET");
                
                JAXBContext jaxbContext = JAXBContext.newInstance(ErResultVO.class);
                Unmarshaller unmarsharller = jaxbContext.createUnmarshaller();
                ErResultVO ErResultVO = (ErResultVO) unmarsharller.unmarshal(url);
                
                if(ErResultVO.body.basisItems.basis != null && ErResultVO.header.resultCode.equals("00")) {
                    result.put(arrName[0], ErResultVO.body.basisItems.basis);
                    
                    for(int i = 1; i < arrUrl.length; i++) {
                        urlstr = arrUrl[i] + restApiKey + "&STAGE1=" + city + "&STAGE2=" + town 
                                + "&pageNo=" + pageNo + "&numOfRows=" + numOfRows ; 
                        url = new URL(urlstr); 
                        connect = (HttpURLConnection) url.openConnection();
                        connect.setRequestMethod("GET");                    
                        unmarsharller = jaxbContext.createUnmarshaller();
                        
                        ErResultVO = (ErResultVO) unmarsharller.unmarshal(url);
                        result.put(arrName[i], ErResultVO.body.basisItems.basis);                
                    }
                }else {
                    throw new Exception();
                }
            result.put("RESULT", "SUCCESS");
        } catch (Exception e) {
            result.put("RESULT", "FAILED");
        }
        return result;
        		
		
	}
	
	
}
