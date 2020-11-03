package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.Services.ClientService;
import com.madauto.madautobackend.Services.OrderService;
import com.madauto.madautobackend.Services.ProductService;
import com.madauto.madautobackend.dto.ClientDto;
import com.madauto.madautobackend.dto.OrdersDto;
import com.madauto.madautobackend.dto.Productdto;
import com.madauto.madautobackend.entities.Category;
import com.madauto.madautobackend.entities.Product;
import com.madauto.madautobackend.entities.Roles;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/backoffice")

public class ModerateurController {
private final ClientService clientService;
private final OrderService orderService;
private  final ProductService productService;

@GetMapping("/client/getallclients")
    public ResponseEntity<List<ClientDto>> getallclient(){
    List<ClientDto> la = new ArrayList<>();
    clientService.getallclient().forEach(client -> {
        if(client.getRole().equals(Roles.client))
        la.add(client.clientodto());
    });
    return ResponseEntity.status(HttpStatus.OK).body(la);
}


@PutMapping("/client/updateclient")
    public ResponseEntity<String> updateclient(@RequestBody ClientDto client){
    System.out.println(client.getEmail());
    try {
        clientService.updateclient(client.dtotoclient());
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }catch (Exception ex){

        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("error");
    }


}

@DeleteMapping("/client/deleteclient")
    public ResponseEntity<String> Deleteclient(@RequestParam String email){
    try {
        clientService.deleteclient(clientService.findbyemail(email));
        return ResponseEntity.status(HttpStatus.OK).body("deleted");

    }catch (Exception cp){
        System.out.println(email);
        cp.printStackTrace();
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("error");


    }

}

@GetMapping("/orders/getallorders")
    public ResponseEntity<List<OrdersDto>> getallorders(){
    List<OrdersDto> listorders = new ArrayList<>();
    orderService.getallorders().forEach(order -> {
        listorders.add(order.makedto());

    });
    return ResponseEntity.status(HttpStatus.OK).body(listorders);

}

@PutMapping("/orders/updateorders")
public ResponseEntity<String> updateorder(@RequestBody OrdersDto ordersDto){
    try {
        orderService.updateorder(ordersDto);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }catch (Exception cp){
        cp.printStackTrace();
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("error");


    }

}



@PostMapping("/products/addproduct")
    public ResponseEntity<String> addproduct(@RequestBody Productdto productdto){
        try{
            productService.addproduct(productdto);
            return ResponseEntity.status(HttpStatus.OK).body("added ! ");

        } catch (Exception e ){

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("error ! ");

        }


}


@PutMapping("/products/updateproduct")
    public  ResponseEntity<String> updateproduct(@RequestBody Productdto productdto){
    try{

        productService.editproduct(productdto);
        return ResponseEntity.status(HttpStatus.OK).body("updated");

    } catch (Error er){
        er.printStackTrace();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Oops error");


    }

}

@DeleteMapping("/products/Deleteproduct")
    public ResponseEntity<String> DeleteProduct(@RequestBody Productdto productdto){
    try {
        productService.deleteproduct(productdto);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");


    } catch(Error err){
        err.printStackTrace();
        return ResponseEntity.status(HttpStatus.OK).body("Oops something went wrong");
    }


}

//makeDto//////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/categories/addcategory")
    public  ResponseEntity<String> AddCategorie(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.OK).body("updated");

    }


    @DeleteMapping("/categories/Removecategorie")
    public ResponseEntity<String> Removecategorie(@RequestBody int id ){
        return ResponseEntity.status(HttpStatus.OK).body("updated");

    }

    @PutMapping("/categories/updatecategorie")
    public  ResponseEntity<String> updatecategorie(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.OK).body("updated");

    }




}
