package com.acme.feedback.model;

import com.acme.feedback.model.Cargo;
import com.acme.feedback.model.Feedback;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-14T08:59:15")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> fotoUrl;
    public static volatile SingularAttribute<Pessoa, Date> nascimento;
    public static volatile CollectionAttribute<Pessoa, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Pessoa, String> bio;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Long> id;
    public static volatile SingularAttribute<Pessoa, String> sobrenome;
    public static volatile SingularAttribute<Pessoa, Cargo> cargo;
    public static volatile SingularAttribute<Pessoa, String> email;

}