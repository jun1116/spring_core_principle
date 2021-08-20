package hello.core.autowired.lifecycle;

import org.springframework.context.annotation.Bean;

public class NetworkClient{
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
        connect();
        call("생성자 초기화 call Method");}
    public void setUrl(String url) {this.url = url;}
    public void connect(){System.out.println("Connect : " + url);}
    public void call(String message){System.out.println("call :  " + url+",  message : "+message);}
    public void disConnect(){System.out.println("Close : " + url);}
    public void init() {
        connect();
        call("init() 통한 초기화 연결메시지");}
    public void close() {
        System.out.println("close() 을 통한 종료");
        disConnect();}
}
