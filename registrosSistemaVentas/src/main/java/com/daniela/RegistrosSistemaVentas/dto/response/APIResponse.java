package com.daniela.RegistrosSistemaVentas.dto.response;

public class APIResponse<T> {

    private boolean éxito;

    private String mensaje;

    private T data;


    // Constructor
    public APIResponse(boolean éxito, String mensaje, T data) {
        this.éxito = éxito;
        this.mensaje = mensaje;
        this.data = data;
    }

    // Getters y setters
    public boolean isÉxito() {
        return éxito;
    }

    public void setÉxito(boolean éxito) {
        this.éxito = éxito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
