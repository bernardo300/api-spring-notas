package com.kennag.notas.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nota  implements Serializable{

  @Id
  @GeneratedValue
  private Long id;
  private String titulo;

  public Long getId() {
    return id;
  }
  public String getTitulo() {
    return titulo;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
