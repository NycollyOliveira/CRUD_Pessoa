/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.telasprojeto.service;

import com.mycompany.telasprojeto.entity.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nycol
 */

@Stateless
@LocalBean
public class PessoaService {
    @PersistenceContext
    private EntityManager em; 
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar (Pessoa pessoa){
        em.merge(pessoa);
        
    }
    
    public List<Pessoa> listarTodos(){
        List<Pessoa> resultado = new ArrayList<>();
        try{
            em.getTransaction().begin();
            String queryL = "SELECT DISTINCT p FROM Pessoa p" +
                    "LEFT JOIN FETCH P.documento p_d";
                    Query qrl = em.createQuery(queryL);
                    resultado =qrl.getResultList();
                    em.getTransaction().commit();
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                        
                    }
                    finally{
                    em.close();
        }
        return resultado;
        
    }
    public Pessoa buscarId(Integer id){
        Pessoa result = null;
        try{
            em.getTransaction().begin();
            String queryB = "SELECT p FROM Pessoa p" + "LEFT JOIN p.documento p_d"+
                    "WHERE p.id = "+id;
                        Query qrb= em.createQuery(queryB);
                        
                        result = (Pessoa) qrb.getSingleResult();
        }
        catch(Exception ex){
            
        }
        finally{
            em.close();
        }
        return result;
    
    
    }

    public Pessoa buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

   
    
    
    
    
    
    
    
    

