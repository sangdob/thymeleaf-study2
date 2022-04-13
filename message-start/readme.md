### 스프링 부트 메시지 소스 설정

스프링 부트를 이용하면 간편하게 국제화 사용 할 수 있다.

application.properties에 간단하게 작성하게 되면 경로를 지정 할 수 있다.

    spring.messages.basename=messages ##message 기본경로
    spring.messages.basename=messages, config.i18n.messages

---------------------

### 스프링 부트 메시지 국제화

#### 1. LocaleResolver - 스프링에서 Locale을 선택하여 변경할 수 있도록 Interface로 지원해준다.

스프링에서 언어를 확인할 수 있는 **Accept-Language**를 활용하는 **AcceptHeaderLocaleResolver**를 사용하여 자동으로 인식하도록 해준다.

