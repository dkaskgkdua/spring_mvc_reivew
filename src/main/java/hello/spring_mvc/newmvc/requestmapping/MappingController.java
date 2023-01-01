package hello.spring_mvc.newmvc.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {
    @RequestMapping("/hello-basic")
    public String heeloBasic() {
        log.info("hello-basic");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers = "mode",
     * headers = "!mode",
     * headers = "mode=debug",
     * headers = "mode!=debug"
     *
     */
    @GetMapping(value = "/mapping-header", headers = {"mode=debug"})
    public String mappingHeader() {
        log.info("mapping-header");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 MediaType
     * consumes = "application/json"
     * consumes = "!application/json"
     * consumes = "application/*"
     * consumes = "*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    }

    /**
     * Accept 헤더 기반 MediaType
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produces", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
