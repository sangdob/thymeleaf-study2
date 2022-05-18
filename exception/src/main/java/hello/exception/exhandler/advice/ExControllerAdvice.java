package hello.exception.exhandler.advice;

import hello.exception.exexception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "hello.exception.api")
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.info("[ExceptionHandler] ex = ", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    //공통으로 처리된 에러들 상속을 받거나 exception으로 타게될경우
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) {
        log.error("[ExceptionHandler] ex = ",e);
        return new ErrorResult("EX", "내부 오류");
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExhandle(UserException e) {
        log.info("[ExceptionHandle] ex = ", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

}
