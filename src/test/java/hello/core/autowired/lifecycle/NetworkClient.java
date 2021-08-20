package hello.core.autowired.lifecycle;

public class NetworkClient {
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
//        this.url = url;
        connect();
        call("생성자 초기화 call Method");
    }
    public void setUrl(String url) {this.url = url;}
    public void connect(){System.out.println("Connect : " + url);}
    public void call(String message){System.out.println("call :  " + url+",  message : "+message);}
    public void disConnect(){System.out.println("Close : " + url);}
}
