package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.Services.OrderService;
import com.madauto.madautobackend.dto.OrdersDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class OrdersController {
    private   final OrderService orderService;
    @PostMapping
    public ResponseEntity<OrdersDto> createorder(@RequestBody OrdersDto orderdto){

        orderService.submitorder(orderdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderdto);
    }

    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity<List<OrdersDto>> getclientorder(@RequestParam String email){
        System.out.println(email);
        System.out.println(orderService.getordersbyclient(email).size());
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getordersbyclient(email));
    }

    @DeleteMapping
    public HttpStatus deleteorder(@RequestParam Long id){
        orderService.RemoveOrder(id);
        return HttpStatus.OK;
    }
}
