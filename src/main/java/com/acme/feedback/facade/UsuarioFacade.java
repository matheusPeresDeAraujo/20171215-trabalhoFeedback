
package com.acme.feedback.facade;

import com.acme.feedback.model.Usuario;
import com.acme.feedback.util.Hash;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "feedback_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByCredenciais(String login, String senha){
        String jpql = "select u from Usuario u where u.senha = :senha "
                + "and u.login = :login";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("login", login);
        query.setParameter("senha", Hash.md5(senha));
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }
    
}
