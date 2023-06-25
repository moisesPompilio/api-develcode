package com.api.Develcode.shared.exception;

public class EntityNotFoundException extends GenericException {
    private static final long serialVersionUID = 1L;

	public static final String NAO_EXISTE = "Não existe registro";

	public static final String NAO_EXISTE_CODIGO
			= "Não existe registro de código %s";

	public static final String NAO_EXISTE_OBJETO
			= "Não existe registro do objeto %s";

	public static final String NAO_EXISTE_CADASTRO_COM_CODIGO
			= "Não existe registro do objeto %s com código %s";

	public EntityNotFoundException() {
		super(NAO_EXISTE);
	}

	public EntityNotFoundException(String codigo) {
		super(NAO_EXISTE_CODIGO + codigo);
	}

	public EntityNotFoundException(Class classe) {
		super(String.format(NAO_EXISTE_OBJETO, classe.getSimpleName()));
	}

	public EntityNotFoundException(Class classe, String codigo) {
		super(String.format(NAO_EXISTE_CADASTRO_COM_CODIGO, classe.getSimpleName(), codigo));
	}
}
