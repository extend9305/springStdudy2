package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic",method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    //@RequestMapping(value = "/mpping-get-v1",method = RequestMethod.GET)
    @GetMapping(value = "/mapping-get-v2")
    public String mappifngGetV1(){
        log.info("mappifngGetV1");
        return "ok";
    }
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId")String data){
        log.info("mappingPath userId={}",data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId,@PathVariable Long orderId){
        log.info("mappingPath userId={} orderId={}",userId,orderId);
        return "ok";
    }
    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String mappingParam(@PathVariable String userId,@PathVariable Long orderId){
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-param",headers = "mode=debug")
    public String mappingHeaders(@PathVariable String userId,@PathVariable Long orderId){
        log.info("mappingHeaders");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(@PathVariable String userId,@PathVariable Long orderId){
        log.info("mappingConsumes");
        return "ok";
    }
    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}























