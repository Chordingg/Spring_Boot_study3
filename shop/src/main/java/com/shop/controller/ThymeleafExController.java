package com.shop.controller;

import com.shop.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {

    @GetMapping(value = "/ex01")
    public String ex01(Model model) {
        model.addAttribute("data", "타임리프 예제 입니다.");
        return "thymeleaf/thymeleafEx01";
    }

    @GetMapping(value = "/ex02")
    public String ex02(Model model) {
        ItemDto itemDTO = ItemDto.builder()
                .itemNm("테스트 상품1")
                .itemDetail("상품 상세 설명")
                .price(10000)
                .regTime(LocalDateTime.now())
                .build();
        model.addAttribute("itemDto", itemDTO);

        return "thymeleaf/thymeleafEx02";
    }

    @GetMapping(value = "/ex03")
    public String ex03(Model model) {

        List<ItemDto> itemDTOList = new ArrayList<>();

        for(int i=0; i<10; i++){
        ItemDto itemDTO = ItemDto.builder()
                .itemNm("테스트 상품" + i)
                .itemDetail("상품 상세 설명" +i)
                .price(1000 * i)
                .regTime(LocalDateTime.now())
                .build();
            itemDTOList.add(itemDTO);
        }

        model.addAttribute("itemDTOList", itemDTOList);

        return "thymeleaf/thymeleafEx03";
    }

    @GetMapping(value = "/ex04")
    public String ex04(Model model) {

        List<ItemDto> itemDTOList = new ArrayList<>();

        for(int i=0; i<10; i++){
            ItemDto itemDTO = ItemDto.builder()
                    .itemNm("테스트 상품" + i)
                    .itemDetail("상품 상세 설명" +i)
                    .price(1000 * i)
                    .regTime(LocalDateTime.now())
                    .build();
            itemDTOList.add(itemDTO);
        }

        model.addAttribute("itemDTOList", itemDTOList);

        return "thymeleaf/thymeleafEx04";
    }

    @GetMapping("/ex05")
    public String ex05(Model model) {

        return "thymeleaf/thymeleafEx05";
    }

    @GetMapping("/ex06")
    public String ex06(@RequestParam("param1") String param1, @RequestParam("param2") String param2, Model model) {

        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);

        return "thymeleaf/thymeleafEx06";
    }

    @GetMapping("/ex07")
    public String ex07(Model model) {

        model.addAttribute("data", "<b>String Boot</b>");
        return "thymeleaf/thymeleafEx07";
    }

    @GetMapping("/ex07_")
    public String ex07_(Model model) {

        model.addAttribute("data", "<b>String Boot</b>");
        return "thymeleaf/thymeleafEx07_";
    }

    @GetMapping("/ex08")
    public String ex08(@RequestParam("param2") String param2, Model model) {

        log.info("--------------------------------------");
        log.info(param2);
        log.info("--------------------------------------");
        return null;
    }

    @GetMapping("/ex09")
    public String ex09(Model model) {
        model.addAttribute("data", "spring!!!");
        model.addAttribute("num", 10);
        return "thymeleaf/thymeleafEx09";
    }
}
