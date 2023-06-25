package com.api.Develcode.shared.exception;

public class UniqueConstraintViolationException extends GenericException {
    private static final long serialVersionUID = 1L;
    public static final String VIOLAÇAO_DE_ELEMENTO_UNICO
			= "Esse %s já foi registrado";
    public UniqueConstraintViolationException(Class classe) {
		super(String.format(VIOLAÇAO_DE_ELEMENTO_UNICO, classe.getSimpleName()));
	}
}
