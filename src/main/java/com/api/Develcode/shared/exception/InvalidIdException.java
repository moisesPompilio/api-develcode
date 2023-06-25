package com.api.Develcode.shared.exception;

public class InvalidIdException extends GenericException {
    private static final long serialVersionUID = 1L;

    public static final String idInvalido = "Esse id é invalido: ";

    public InvalidIdException(String id) {
		super(idInvalido + id);
	}
}
