package com.recibook.recibook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * The Class Excepcion.
 */
public class Excepcion extends HttpStatusCodeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2776897585862665153L;

    /**
     * Instantiates a new excepcion.
     *
     * @param status the status
     * @param reason the reason
     */
    public Excepcion(HttpStatus status, String reason) {
        super(status, reason);
    }
}
