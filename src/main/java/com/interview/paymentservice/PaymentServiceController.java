package com.interview.paymentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class PaymentServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceController.class);

    @GetMapping("/pay")
    public PaymentResponse pay(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "amount") String amount,
            @RequestParam(value = "currency") String currency,
            @RequestParam(value = "card.brand") String cardBrand,
            @RequestParam(value = "card.number") String cardNumber,
            @RequestParam(value = "card.holder") String cardHolder,
            @RequestParam(value = "card.expiryYear") String cardExpiryYear,
            @RequestParam(value = "card.expiryMonth") String cardExpiryMonth,
            @RequestParam(value = "card.cvv") String cardCVV
    ) {
        LOGGER.info("received parameters: {}, {}, {}, {}, {}, {}, {}, {}, {}, {}",
                amount,
                password,
                currency,
                cardBrand,
                cardNumber,
                cardHolder,
                cardExpiryYear,
                cardExpiryMonth,
                cardCVV);
        try {
            PaymentRequest request = new PaymentRequest(user, password, amount, currency, cardBrand, cardNumber, cardHolder,
                    cardExpiryYear, cardExpiryMonth, cardCVV);
            LOGGER.info("request: " + request);
            PaymentResponse response = doPay(request);
            LOGGER.info("response: " + response);
            return response;
        } catch(Throwable t) {
            LOGGER.error("exception happened " + t);
        }
        return null;
    }

    private PaymentResponse doPay(PaymentRequest request) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
        LOGGER.info("received " + quote);
        PaymentResponse response = new PaymentResponse(UUID.randomUUID().toString(),
                quote.getType().equals("success") && quote.getValue().getQuote().contains("I don't worry") ? "00" : "01",
                quote.getValue().getQuote());
        return response;
    }

}
