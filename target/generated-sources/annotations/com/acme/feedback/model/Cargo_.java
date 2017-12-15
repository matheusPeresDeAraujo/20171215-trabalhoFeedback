package com.acme.feedback.model;

import com.acme.feedback.model.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-14T08:59:15")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile CollectionAttribute<Cargo, Pessoa> pessoaCollection;
    public static volatile SingularAttribute<Cargo, String> nome;
    public static volatile SingularAttribute<Cargo, Long> id;

}