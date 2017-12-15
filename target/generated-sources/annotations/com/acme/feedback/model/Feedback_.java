package com.acme.feedback.model;

import com.acme.feedback.model.Pessoa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-14T08:59:15")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, String> texto;
    public static volatile SingularAttribute<Feedback, Pessoa> pessoa;
    public static volatile SingularAttribute<Feedback, Date> dataPublicacao;
    public static volatile SingularAttribute<Feedback, Long> id;
    public static volatile SingularAttribute<Feedback, Double> nota;

}