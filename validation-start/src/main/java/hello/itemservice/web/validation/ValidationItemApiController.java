package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    /*
    * API의 경우 호출에 대한 케이스가 나뉘어있다.
    * success
    * error : api 검증에서 실패
    * validation error
    *
    * */


    //타입이 맞지 않을경우 JSON 자체를 만들지 못하고 Controller로 넘어오지도 못한다...

    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
        log.info("api COntroller request");

        if (bindingResult.hasErrors()) {
            log.info("validation errors = {}", bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("success logic go");
        return form;
    }
}
