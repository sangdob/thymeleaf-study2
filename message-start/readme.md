### 스프링 부트 메시지 소스 설정

스프링 부트를 이용하면 간편하게 국제화 사용 할 수 있다.

application.properties에 간단하게 작성하게 되면 경로를 지정 할 수 있다.

    spring.messages.basename=messages ##message 기본경로
    spring.messages.basename=messages, config.i18n.messages

---------------------

