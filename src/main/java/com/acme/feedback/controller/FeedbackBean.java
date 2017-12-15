
package com.acme.feedback.controller;

import com.acme.feedback.facade.FeedbackFacade;
import com.acme.feedback.facade.PessoaFacade;
import com.acme.feedback.model.Feedback;
import com.acme.feedback.model.Pessoa;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class FeedbackBean {

    private Feedback feedback = new Feedback();

    private Long selectedId;

    @Inject
    private FeedbackFacade feedbackFacade;

    @Inject
    private PessoaFacade pessoaFacade;

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public Pessoa findPeaple(Long id){
       Pessoa pessoa = pessoaFacade.find(id);
       return pessoa;
    }
    
    public String salvar() {
        feedback.setPessoa(findPeaple(selectedId));
        feedbackFacade.create(feedback);
        return "/feedback/buscar";
    }

    public Double mostraNota(Long id){

       return feedbackFacade.getMedia(id);
    }
}
