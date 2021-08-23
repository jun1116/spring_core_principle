package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService; //@Autowired 가 붙어있는것과 같음
    private final ObjectProvider<MyLogger> myLoggerProvider; //MyLogger를 주입받는게 아니라, 그걸 찾을 수 있는 DL이 주입된다 -> 주입시점에 주입받을 수 있다

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);
        myLogger.log("Controller Test");
        logDemoService.logic("TestId");
        return "OK";
    }
}
