package sa.com.stc.demo1.adapter.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import sa.com.stc.demo1.config.Subject;

import java.util.*;


@Repository
public class Repository1 {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Lazy
    @Autowired
    private RestTemplate temp;
    static final String url = "http://localhost:7090/subjects/";
    public List<Subject> display() {
        Subject[] result = temp.getForObject(url+"display",Subject[].class);
        return Arrays.asList(result);
    }
    public String add(Subject sub) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Subject> entity = new HttpEntity<Subject>(sub,headers);

        return temp.exchange("http://localhost:7090/subjects/add", HttpMethod.POST, entity, String.class).getBody();
    }
    public String update(Subject sub,String id) {
        HttpHeaders  headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Subject> entity = new HttpEntity<Subject>(sub,headers);
        return temp.exchange(
                "http://localhost:7090/subjects/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }
    public String delete(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Subject> entity = new HttpEntity<Subject>(headers);

        return temp.exchange(
                "http://localhost:7090/subjects/delete/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    public Subject displayById(String id) {
        Map<String,String> param = new HashMap<>();
        //param.put("id","1");
        Subject k = temp.getForObject(url+"/display/"+id,Subject.class,param);
        return k;
    }
}

