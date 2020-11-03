package com.madauto.madautobackend.Services;

import com.madauto.madautobackend.dao.ClientRepository;
import com.madauto.madautobackend.dao.OrderItemsRepository;
import com.madauto.madautobackend.dao.OrderRepository;
import com.madauto.madautobackend.dao.ProductRepository;
import com.madauto.madautobackend.dto.Orderitemdto;
import com.madauto.madautobackend.dto.OrdersDto;
import com.madauto.madautobackend.entities.*;
import com.madauto.madautobackend.exceptions.Excep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderItemsRepository orderItemsRepository;
@Transactional
    public void submitorder(OrdersDto orderdto) {
    Order order = new Order();
    System.out.println(orderdto.getTelephone());
//    System.out.println(clientRepository.findByEmail(orderdto.getClientid()));
    System.out.println(clientRepository.findByEmail(orderdto.getClientid()).getId());
     order.setCustomer(clientRepository.findByEmail(orderdto.getClientid()));
//    System.out.println(order.getCustomer().getId());
     order.setShipToAddress(orderdto.getShipToAddress());
    order.setOrderDate(LocalDate.now());
    order.setRecordStatus(Status.created);
    order.setGouvernorat(orderdto.getGouvernorat());
    order.setCompany(orderdto.getCompany());
    order.setTelephone(orderdto.getTelephone());
    order.setZipcode(orderdto.getZipcode());


    order = orderRepository.save(order);


    for (Orderitemdto ot : orderdto.getOrderItems()
    ) {
        OrderItems ort = new OrderItems();
        ort.setProduct(productRepository.findProductById(Long.parseLong(ot.getProductid())));
        ort.setQuantity(Integer.parseInt(ot.getQuantity()));
        ort.setOrders(order);
        orderItemsRepository.save(ort);

    }
}
    @Transactional
   public List<OrdersDto> getordersbyclient(String email ){
        Client c = clientRepository.findClientByEmail(email).get();
        System.out.println(c.getId());
        System.out.println("Service"+ orderRepository.findByCustomer(c).size());
        List<OrdersDto> orderList= new ArrayList<>();
       orderRepository.findByCustomer(c).forEach(order -> {

           OrdersDto dt = new OrdersDto();
           dt=order.makedto();
           orderList.add(dt);

        });

        return orderList;
    }

    public void RemoveOrder(Long id){
        orderRepository.delete(orderRepository.findById(id).get());
    }

    public List<Order> getallorders(){
    return orderRepository.findAll();
    }

    @Transactional
    public void updateorder(OrdersDto ordersDto){


            Order or = orderRepository.findById(Long.valueOf(ordersDto.getId())).orElseThrow(() -> {
                return new Excep("erro");
            });


            or.setZipcode(ordersDto.getZipcode());
            or.setTelephone(ordersDto.getTelephone());
            or.setGouvernorat(ordersDto.getGouvernorat());
            or.setCompany(ordersDto.getCompany());
            or.setRecordStatus(Status.valueOf(ordersDto.getStatus()));
            or.setShipToAddress(ordersDto.getShipToAddress());

            orderRepository.save(or);

    }


}
