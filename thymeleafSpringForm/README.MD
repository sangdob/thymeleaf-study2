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

### 타임리프 - 체크 박스 멀티

여러개의 체크박스가 있을 경우 List형식으로 데이터를 담아 반복하며 ${#ids.prev('items')} 형식을 사용한다. 데이터가 담겨져 있는 형태를 볼 수 있다.

@ModelAttribute('regions') 형식을 메소드단에 사용하게 되면 메소드를 model의 attribute로 삽입하여 주도록 되어있다. == model.attribute(
regions)[method name] 형식이다.

-------------------

### 타임리프 - 라디오 버튼

타임리프를 활용하여 라디오 버튼을 생성할 경우 Enum을 활용하여 배열객체로 만들어 주면 가용성이 더욱 편하게 매핑할 수 있다.

객체에 직접적으로 Enum을 담아 전달하면 타임리프에서 자바 객체에 직접 접근이 가능하다.

    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
      return ItemType.values();
    }

* 자바 객체에 직접 접근하는 방식 (추천하지 않는 방식)

`<div th:each="type : ${T(hello.itemservice.domain.item.ItemType).values()}">`

--------------------

### 타임리프 - 선택 버튼

타임리프의 object문법을 활용하여 Select버튼을 생성할 경우 Option을 객체나 List형식으로 반복하여 넣을 수 있다.

    <div>
     <div>배송 방식</div>
     <select th:field="*{deliveryCode}" class="form-select">
     <option value="">==배송 방식 선택==</option>
     <option th:each="deliveryCode : ${deliveryCodes}" th:value="$
    {deliveryCode.code}"
     th:text="${deliveryCode.displayName}">FAST</option>
     </select>
    </div>

이와 같은 방식으로 반복을 통해 option을 작성하게 되면 한가지 선택을 통해 값을 전달 할 수 있다.

----------------------

