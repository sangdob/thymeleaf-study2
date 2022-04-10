package remote.thymeleafspringform.domain.item;

import lombok.Data;

import java.util.List;

@Data
public class Item {

	private Long id;
	private String itemName;
	private Integer price;
	private Integer quantity;

	private Boolean open; //판매 여부
	private List<String> regisons; //등록지역 서울,울산 등등
	private ItemType itemType;
	private DeliveryCode deliveryCode;

	public Item() {
	}

	public Item(String itemName, Integer price, Integer quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
}
