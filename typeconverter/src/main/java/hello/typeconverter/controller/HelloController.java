package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String datta = request.getParameter("data");
        Integer intValue = Integer.valueOf(datta);
        log.info("intValue = {}", intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        log.info("intValue = {} ", data);
        return "ok";
    }
    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort data) {
        log.info("ipPort IP = {} ", data.getIp());
        log.info("ipPort Port = {} ", data.getPort());
        return "ok";
    }
}
