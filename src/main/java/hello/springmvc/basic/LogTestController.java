package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "String";

        log.trace("trace ="+ name);//이렇게 쓰면 안된다.
        //실제적으로 연산이 trace =String 으로 치환하는 로직이 돌아가버린다.
        //하지만 밑의 방법처럼쓰면 연산전 로직 X

        log.trace("trace ={}",name);
        log.debug("debug ={}",name);
        log.info("info ={}",name);
        log.warn("warn ={}",name);
        log.error("error ={}",name);
        return  "ok";
    }

}
