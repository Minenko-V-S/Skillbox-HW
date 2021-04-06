package main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/")
public class DefaultController {


@GetMapping
    public static double generateRandomInt(){
        Random random = new Random();
        return random.nextInt();
    }





}
