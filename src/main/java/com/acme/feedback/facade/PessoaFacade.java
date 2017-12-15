
package com.acme.feedback.facade;

import com.acme.feedback.model.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class PessoaFacade extends AbstractFacade<Pessoa> {

   @PersistenceContext(unitName = "feedback_pu")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public PessoaFacade() {
      super(Pessoa.class);
   }

    public List<Pessoa> findName(String nome) {
        TypedQuery<Pessoa> query = getEntityManager().createQuery("SELECT p FROM Pessoa p"
                + " WHERE ((p.nome LIKE :nome) OR (p.sobrenome LIKE :nome))", Pessoa.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    public Pessoa findId (Long id) {
        TypedQuery<Pessoa> query = getEntityManager().createQuery("SELECT p FROM Pessoa p"
                + " WHERE p.id = :id", Pessoa.class);
        query.setParameter("id", id);
        return (Pessoa) query.getResultList();
    }

}
