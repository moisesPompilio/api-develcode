package com.api.Develcode.shared.exception;

public class EntityInUseException extends GenericException {
    private static final long serialVersionUID = 1L;
	public static final String EM_USO = "Entidade em uso";

	public EntityInUseException(String mensagem) {super(mensagem);}

	public EntityInUseException() {
		super(EM_USO);
	}

	public EntityInUseException(Class classe, String codigo) {
		super(String.format("O objeto %s de código %d não pode ser removido, pois está em uso", classe.getSimpleName(), codigo));
	}
}
