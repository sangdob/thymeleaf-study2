package hello.itemservice.domain.item;

import hello.itemservice.web.validation.form.ItemSaveForm;
import hello.itemservice.web.validation.form.ItemUpdateForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/*
*   @validated에서 anntation의 등록에 따라 자동으로 동작한다
* */
@Data
@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000이상 이어야 합니다.")
public class Item {

//    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
    private Long id;
    /*
    * @NotBlank
    * NotBlank.item.itemName
    * NotBlank.itemName
    * NotBlank
    *
    * */
//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Long price;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Max(Integer.MAX_VALUE) //max값 제한 요구사항 추가
    private Integer quantity;

    public Item() {
    }

    public Item of(ItemSaveForm form){
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setPrice(form.getPrice());
        item.setQuantity(form.getQuantity());
        return item;
    }

    public Item of(ItemUpdateForm form){
        Item item = new Item();
        item.setId(form.getId());
        item.setItemName(form.getItemName());
        item.setPrice(form.getPrice());
        item.setQuantity(form.getQuantity());
        return item;
    }

    public Item(String itemName, Long price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
