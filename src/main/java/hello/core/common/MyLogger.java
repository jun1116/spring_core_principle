package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request")//request가 들어왔을 때 생성되는 스코프를 가졌어
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {this.requestURL = requestURL;}
    public void log(String message) {System.out.println("["+uuid + "]" +"["+ requestURL+"] "+message);}

    @PostConstruct
    public void init(){
        this.uuid = UUID.randomUUID().toString();
        System.out.println("["+this.uuid + "] request scope bean created :  "+this);
    }
    @PreDestroy
    public void close() {System.out.println("["+this.uuid + "] request scope bean closed :  "+this);}
}
