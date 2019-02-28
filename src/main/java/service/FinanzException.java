package service;

import javax.ws.rs.core.Response;

public class FinanzException extends RuntimeException {

    private Response.Status status;

    public FinanzException(Response.Status status, String message) {
        super(message);
        this.status = status;
    }
}
