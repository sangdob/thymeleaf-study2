package remote.thymeleafspringform.web.form;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import remote.thymeleafspringform.domain.item.Item;
import remote.thymeleafspringform.domain.item.ItemRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/form/items")
@RequiredArgsConstructor
public class FormItemController {

	private final ItemRepository itemRepository;

	//클래스 호출 시 데이터 자동 생성
	@ModelAttribute("regions")
	private Map<String, String> regions() {
		Map<String, String> regionsMap = new LinkedHashMap<>();
		regionsMap.put("SEOUL", "서울");
		regionsMap.put("BUSAN", "부산");
		regionsMap.put("JEJU", "제주");
		return regionsMap;
	}

	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "form/items";
	}

	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "form/item";
	}

	@GetMapping("/add")
	public String addForm(Model model) {
		log.info("item = {}", regions());
		model.addAttribute("item", new Item());
		return "form/addForm";
	}

	@PostMapping("/add")
	public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {

		log.info("add log = {}", item.getOpen());

		Item savedItem = itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getId());
		redirectAttributes.addAttribute("status", true);
		return "redirect:/form/items/{itemId}";
	}

	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "form/editForm";
	}

	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
		itemRepository.update(itemId, item);
		return "redirect:/form/items/{itemId}";
	}

}

