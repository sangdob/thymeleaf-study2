package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemUpdateForm {

    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min=1000, max = 1000000)
    private Long price;

    //수정에서는 수량은 자유롭게 변경이 가능하다.
    @NotNull
    private Integer quantity;
}
