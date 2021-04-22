package com.demo.assets.exception;

public class QuoteNotFoundException extends NoResultException {

    public QuoteNotFoundException(String ticker) {
        super(String.format("Cotação não encontrada: Ticket[%s]", ticker));
    }
}
