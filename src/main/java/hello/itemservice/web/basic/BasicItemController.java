package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // 생성자 주입 (Autowired)를 생략할 수 있다. Lombok임
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);

        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
//    public String addItemV1(@RequestParam String itemName,
//                       @RequestParam int price,
//                       @RequestParam int quantity,
//                       Model model) {
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);
//        itemRepository.save(item);
//
//        model.addAttribute("item", item);
//
//        return "basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
//        // @ModelAttribute("item")의 비밀 model.addAttribute를 안 해도
//        // "item"이라는 이림으로 자동으로 addAttribute해준다.
//
//        /*
//        @ModelAttribute("hello") Item item 이름을 hello 로 지정
//        model.addAttribute("hello", item); 모델에 hello 이름으로 저장
//         */
//        itemRepository.save(item);
//
////        model.addAttribute("item", item); // 생략 가능
//
//        return "basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV3(@ModelAttribute Item item, Model model) {
//       itemRepository.save(item);
//       // @ModelAttribute name을 지정하지 않으면 클래스 명의 앞에만 소문자로 바꾸고 model.addAttribute에 넣어준다.
//
////       model.addAttribute("item", item);
//       return "basic/item";
//    }
//    @PostMapping("/add")
//    public String addItemV4(Item item) {
//       itemRepository.save(item);
//       // @ModelAttribute name을 지정하지 않으면 클래스 명의 앞에만 소문자로 바꾸고 model.addAttribute에 넣어준다.
//       // 생략 가능
//
////       model.addAttribute("item", item);
//       return "basic/item";
//    }
//    @PostMapping("/add")
//    public String addItemV5(Item item) {
//       itemRepository.save(item);
//       // @ModelAttribute name을 지정하지 않으면 클래스 명의 앞에만 소문자로 바꾸고 model.addAttribute에 넣어준다.
//       // 생략 가능
//
////       model.addAttribute("item", item);
//       return "redirect:/basic/items/" + item.getId();
//    }
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
       itemRepository.save(item);
       redirectAttributes.addAttribute("itemId", item.getId());
       // 치환을 다 해주고, url 인코딩도 다 해줌
       redirectAttributes.addAttribute("status", true);
       return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable long itemId,
                       @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        // redirect를 활용함
        return "redirect:/basic/items/{itemId}";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }
}
