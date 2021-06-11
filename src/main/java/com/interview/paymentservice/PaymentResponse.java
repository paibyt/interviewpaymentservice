package com.interview.paymentservice;

public class PaymentResponse {
    private String id;
    private String status;
    private String description;

    public PaymentResponse(String id, String status, String description) {
        this.id = id;
        this.status = status;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PaymentResponse {" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
