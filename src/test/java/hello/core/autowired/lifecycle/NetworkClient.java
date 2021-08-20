package hello.core.autowired.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean , DisposableBean {
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
        connect();
        call("생성자 초기화 call Method");
    }
    public void setUrl(String url) {this.url = url;}
    public void connect(){System.out.println("Connect : " + url);}
    public void call(String message){System.out.println("call :  " + url+",  message : "+message);}
    public void disConnect(){System.out.println("Close : " + url);}

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("Initializion Bean을 통한 초기화 연결메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 을 통한 종료");
        disConnect();
    }
}
