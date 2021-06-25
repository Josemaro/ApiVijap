package com.vijap.api.models;

import javax.persistence.*;
import javax.websocket.Decoder.Text;


@Entity
@Table(name = "platillo")
public class PlatilloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(unique = true, nullable = false)
    private String nombre;
    private String tiempo_p;
    
    @Lob
    private String ingredientes;
    
    @Lob
    private String preparacion;

    private String calorias;
    private String carbohidratos;
    private String fibra_d;
    private String proteinas;
    private String grasa_total;
    private String grasa_saturada;
    private String grasa_trans;
    private String colesterol;
    private String sodio;
    private String img;

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTiempo_p() {
        return tiempo_p;
    }
    public void setTiempo_p(String tiempo_p) {
        this.tiempo_p = tiempo_p;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public String getPreparacion() {
        return preparacion;
    }
    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
    public String getCalorias() {
        return calorias;
    }
    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
    public String getCarbohidratos() {
        return carbohidratos;
    }
    public void setCarbohidratos(String carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    public String getFibra_d() {
        return fibra_d;
    }
    public void setFibra_d(String fibra_d) {
        this.fibra_d = fibra_d;
    }
    public String getProteinas() {
        return proteinas;
    }
    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }
    public String getGrasa_total() {
        return grasa_total;
    }
    public void setGrasa_total(String grasa_total) {
        this.grasa_total = grasa_total;
    }
    public String getGrasa_saturada() {
        return grasa_saturada;
    }
    public void setGrasa_saturada(String grasa_saturada) {
        this.grasa_saturada = grasa_saturada;
    }
    public String getGrasa_trans() {
        return grasa_trans;
    }
    public void setGrasa_trans(String grasa_trans) {
        this.grasa_trans = grasa_trans;
    }
    public String getColesterol() {
        return colesterol;
    }
    public void setColesterol(String colesterol) {
        this.colesterol = colesterol;
    }
    public String getSodio() {
        return sodio;
    }
    public void setSodio(String sodio) {
        this.sodio = sodio;
    }
    

    
}
