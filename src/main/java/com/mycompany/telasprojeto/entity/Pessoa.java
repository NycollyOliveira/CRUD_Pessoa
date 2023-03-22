/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.telasprojeto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author Nycol
 */
@Entity
@Table (name= "pessoa")
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
   @Column(name="nome")
  private  String nome;
   @Column (name= "idade")
  private Integer idade;
   @Column (name="sexo")
  private String sexo;
   @JoinColumn(name= "documento_id", referencedColumnName="id")
   @OneToOne(fetch = FetchType.LAZY)
  private Documento documento;
  
  public Pessoa (){
      this.documento = new Documento();
  }
  public Pessoa (String nome, Integer idade, String sexo,Documento documento ){
      this.nome= nome;
      this.idade= idade;
      this.sexo= sexo;
      this.documento= documento;
  }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  
  
}
