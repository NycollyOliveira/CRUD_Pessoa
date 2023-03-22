/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.telasprojeto.face;

import com.mycompany.telasprojeto.entity.Documento;
import com.mycompany.telasprojeto.entity.Pessoa;
import com.mycompany.telasprojeto.service.PessoaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Nycol
 */
@Named("ControlePessoa")
@SessionScoped
public class ControlePessoa implements Serializable {
    
     @Inject
    private PessoaService pessoaSrv;
   private List<Pessoa> pessoaList;
   private Pessoa pessoa;
   private String statusTela;
   
   public ControlePessoa(){
       
   }
   @PostConstruct
   public void iniciar(){
          pessoaList = pessoaSrv.listarTodos();
        statusTela = "lista"; 
     
   }
   public void voltar(){
       statusTela= "lista";
       pessoa = new Pessoa();
       
   }
   public void adicionar(){
       statusTela= "editando";
       pessoa = new Pessoa();
   }
   
   public void salvar(){
       pessoaList.add(pessoa);
       voltar();
   }
   public void consultar(Pessoa pessoaItens){
     this.pessoa = pessoaSrv.buscarPorId(pessoa.getId());
        statusTela = "V";
       
   }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getStatusTela() {
        return statusTela;
    }

    public void setStatusTela(String statusTela) {
        this.statusTela = statusTela;
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
