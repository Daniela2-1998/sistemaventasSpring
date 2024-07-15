package com.daniela.RegistrosSistemaVentas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "proveedores")
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String empresa;

    private String identificacion;

    private String mail;

    private String telefono;

    private String direccion;

    private String contacto;

    private TipoProveedor tipo;

    private String descripcion;

    private LocalDate fechaRegistro;


    public enum TipoProveedor {
        PRODUCTOS, SERVICIOS, MIXTO
    }


    // Constructor
    public Proveedores(String empresa, String identificacion, String mail, String telefono, String direccion, String contacto, TipoProveedor tipo, String descripcion, LocalDate fechaRegistro) {
        this.empresa = empresa;
        this.identificacion = identificacion;
        this.mail = mail;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contacto = contacto;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public TipoProveedor getTipo() {
        return tipo;
    }

    public void setTipo(TipoProveedor tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
