package com.mycompany.telasprojeto.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, Integer> idade;
	public static volatile SingularAttribute<Pessoa, Documento> documento;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, Integer> id;
	public static volatile SingularAttribute<Pessoa, String> sexo;

}

