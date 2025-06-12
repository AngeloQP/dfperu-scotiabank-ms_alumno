package com.dfperu.scotiabank.ms_alumno.model.enums;

/**
 * Enumeración que representa el estado de un alumno.
 * Puede ser ACTIVO (0) o INACTIVO (1).
 */
public enum EstadoAlumno {

    /**
     * Estado que indica que el alumno está activo.
     */
    ACTIVO(0),

    /**
     * Estado que indica que el alumno está inactivo.
     */
    INACTIVO(1);

    /**
     * Valor entero asociado al estado.
     */
    private final int valor;

    /**
     * Constructor que asocia un valor entero a cada estado.
     *
     * @param valor valor entero del estado
     */
    EstadoAlumno(int valor) {
        this.valor = valor;
    }

    /**
     * Devuelve el valor entero asociado al estado.
     *
     * @return el valor del estado
     */
    public int getValor() {
        return valor;
    }
}
