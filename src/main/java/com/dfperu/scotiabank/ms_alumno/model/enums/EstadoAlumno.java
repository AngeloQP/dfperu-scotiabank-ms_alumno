package com.dfperu.scotiabank.ms_alumno.model.enums;

public enum EstadoAlumno {
    ACTIVO(0),
    INACTIVO(1);

    private final int valor;

    EstadoAlumno(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static EstadoAlumno fromValor(int valor) {
        for (EstadoAlumno estado : EstadoAlumno.values()) {
            if (estado.valor == valor) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Valor de estado no válido: " + valor);
    }
}
