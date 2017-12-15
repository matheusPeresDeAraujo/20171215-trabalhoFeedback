
package com.acme.feedback.facade;

import com.acme.feedback.model.Feedback;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class FeedbackFacade extends AbstractFacade<Feedback> {

   @PersistenceContext(unitName = "feedback_pu")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public FeedbackFacade() {
      super(Feedback.class);
   }

   public Double getMedia(Long id) {
      TypedQuery<Double> query = getEntityManager().createQuery("SELECT AVG(f.nota) FROM Feedback f"
        + " WHERE f.pessoa.id = :id", Double.class);
      query.setParameter("id", id);
      Double avaliacao = query.getSingleResult();

      return avaliacao;
   }

}
