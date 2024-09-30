package com.example.MyFirstApp.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {
    private ArrayList<String> arayList = new ArrayList<>();
    private HashMap<Integer, String> hashMap = new HashMap<>();
    private int mapIndex = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello, %s", name);

    }

    @GetMapping("/updste-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        arayList.add(s);
        return "элемент добавлен в ArrayList:" + s;
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return ArrayList.toString();
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        hashMap.put(mapIndex++, s);
        return "Элемент добавлен в HashMap: " + s;
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return hashMap.toString();
    }

    @GetMapping("/show-all-lenght")
    public String showAllLength() {
        return String.format("ArrayList length: %d, HashMap length: %d", arayList.size(), hashMap.size());
    }
}


