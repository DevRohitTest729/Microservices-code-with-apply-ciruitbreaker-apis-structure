package com.movie.ticket.booking.system.service.impl;

import com.movie.ticket.booking.system.enums.PaymentStatus;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StripePaymentGateway {

    @Value("${stripe.secretKye}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public PaymentStatus makePayment(Double paymentAmount) {

        try {
            PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder()
                    .setAmount(paymentAmount.longValue()*100)
                    .setCurrency("inr")
                    .setPaymentMethod("pm_card_in")
                    .build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return PaymentStatus.APPROVED;
        } catch (StripeException e) {
            log.error("payment fail at the gateway level with exception::" + e.getMessage());
            return PaymentStatus.FAILED;
        }

    }


}
