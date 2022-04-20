package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/*
*   @validated에서 anntation의 등록에 따라 자동으로 동작한다
* */
@Data
public class Item {

    private Long id;

    @NotBlank(message = "공백 X`")
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Long price;

    @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Long price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
