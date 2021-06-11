package com.interview.paymentservice;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentRequestTests {

    private DateFormat DATE_FORMAT = new SimpleDateFormat("YYYYMM");

    @Test
    public void testConstructorAmount() throws ParseException {
        PaymentRequest request = new PaymentRequest("a", "b", "12.12", "EUR",
        "VISA", "1234343", "Joe Doe", "22", "06", "123");
        assertThat(request, notNullValue());
        assertThat(request.getAmount(), is(12.12));
    }

    @Test
    public void testConstructorExpiryDate() throws ParseException {
        PaymentRequest request = new PaymentRequest("a", "b", "12.12", "EUR",
                "VISA", "1234343", "Joe Doe", "22", "06", "123");
        assertThat(request, notNullValue());
        assertThat(DATE_FORMAT.format(request.getCardExpiryDate()),
                is(DATE_FORMAT.format(new Date(2022 - 1900, 06, 0))));
    }
}
