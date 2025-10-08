package com.cfs.paymentgateway.repo;


import com.cfs.paymentgateway.entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo  extends JpaRepository<PaymentOrder, Long> {

        PaymentOrder findByPaymentOrderId(Long paymentOrderId);

}
