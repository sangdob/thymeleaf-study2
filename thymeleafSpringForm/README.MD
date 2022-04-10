### 타임리프 - 입력 폼 처리

타임리프에는 자바의 model 데이터를 받아 사용 할 수 있도록 해주는 <th:object>가 있다.

th:object에는 html 태그 내부에 종속되어 사용할 수 있고 form형태 태그에 사용하기 간편하다.

form 내부의 데이터를 object로 인하여 <th:field>를 활용하게 되면 object에 선언된 key의 value값을 활용한다.

* 예제

    <form th:object="${item}">
        <input th:field="*{name}">
        <input th:field="*{price}">
    </form>

형식으로 사용하고, 속성값에 데이터를 매핑한다.

field의 경우 속성값 id, name, value에 매핑되어 데이터를 나타낼 수 있다.

데이터 변경에 유의하고 여러 관점에서 사용이 가능하다.

---------------

### 타임리프 - 체크 박스 형태

타임리프에서는 체크박스의 value값이 false일 경우 받아들이지 못하는 형태가 있다.

이를 해결하기 위해 check박스 타입일 경우 <th:field>를 사용할 경우 같이 보여준다.

타임리프에서는 자동적으로 hidden field를 만들어 데이터를 넘겨주므로 false값도 자동으로 넘어가게 된다.

--------------------

###     