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
    private final MyLogger myLogger; // @Autowired가 붙어있는 것과 같음
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();
        myLogger.setRequestURL(requestURL);
//        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.log("Controller Test");
        logDemoService.logic("TestId");
        return "OK";
    }
}
