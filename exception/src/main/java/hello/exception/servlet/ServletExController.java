package hello.exception.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ServletExController {

    @GetMapping("/error-ex")
    public void errorEx() {
        throw new RuntimeException("exception  !!");
    }
//
    //404 에러
    @GetMapping("/error-404")
    public void error404(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(404, "404 error!!");
    }

    //400 에러
    @GetMapping("/error-400")
    public void error400(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(400, "404 error!!");
    }

    // 505 error 화면
    @GetMapping("/error-500")
    public void error500(HttpServletResponse httpServletResponse) throws IOException {

        httpServletResponse.sendError(500);
    }

}
