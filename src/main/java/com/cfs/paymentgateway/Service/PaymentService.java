package com.cfs.paymentgateway.Service;


import com.cfs.paymentgateway.entity.PaymentOrder;
import com.cfs.paymentgateway.repo.PaymentRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Value ("${rzp_key_id}")
    private String keyId;

    @Value ("${rzp_key_secret}")
    private String keySecret;

    @Autowired
    private PaymentRepo paymentRepo;

    public String createOrder(PaymentOrder paymentOrderDetails) throws RazorpayException {

        RazorpayClient razorpayClient  = new RazorpayClient(keyId , keySecret);
        JSONObject paymentOrderJson = new JSONObject();
        paymentOrderJson.put("amount"   ,  (int) (paymentOrderDetails.getAmount() * 100));
        paymentOrderJson.put("currency" , "INR");
        paymentOrderJson.put("receipt"  , UUID.randomUUID().toString());

        Order razorpayOrder = new Order(paymentOrderJson);

        System.out.println(razorpayOrder.toString());
        paymentOrderDetails.setOrderId(razorpayOrder.get("id"));
        paymentOrderDetails.setStatus("Created");
        paymentOrderDetails.setCratedAt(LocalDateTime.now());
        paymentRepo.save(paymentOrderDetails);

        return razorpayOrder.toString();

    }

    public void updateOrderStaus(String orderId, String paymentId, String status) {
        PaymentOrder order = paymentRepo.findByPaymentOrderId(orderId);
        order.setStatus(status);
        paymentRepo.save(order);
        paymentRepo.save(order);
    }
}
