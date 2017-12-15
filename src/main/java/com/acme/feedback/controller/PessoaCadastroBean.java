package com.acme.feedback.controller;

import com.acme.feedback.facade.PessoaFacade;
import com.acme.feedback.model.Pessoa;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PessoaCadastroBean {
    
  private Pessoa pessoa = new Pessoa();
   private Long selectedId;
   @Inject
   private PessoaFacade facade;

   public Long getSelectedId() {
      return selectedId;
   }

   public void setSelectedId(Long selectedId) {
      this.pessoa = facade.find(selectedId);
      this.selectedId = selectedId;
   }

   public PessoaFacade getFacade() {
      return facade;
   }

   public void setFacade(PessoaFacade facade) {
      this.facade = facade;
   }

   public Pessoa getPessoa() {
      return pessoa;
   }

   public void setPessoa(Pessoa pessoa) {
      this.pessoa = pessoa;
   }

   public String salvar() {
      if (selectedId == null) {
         facade.create(pessoa);
      } else {
         facade.edit(pessoa);
      }
      return "/pessoas/listar";

   }
}
