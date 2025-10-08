package com.cfs.paymentgateway.Controller;


import com.cfs.paymentgateway.Service.PaymentService;
import com.cfs.paymentgateway.entity.PaymentOrder;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(@RequestBody PaymentOrder order) {
        try {
            String response = paymentService.createOrder(order);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Creating Order");
        }
    }

    public ResponseEntity<String> updateStatus(@RequestParam String orderId , @RequestParam String paymentId ,@RequestParam String status){

        paymentService.updateOrderStaus(orderId , paymentId , status);
        System.out.println("Email send Successfully");
        return ResponseEntity.ok("Email send Successfully and order successfully");
    }

}
