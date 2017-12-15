package com.acme.feedback.controller;

import com.acme.feedback.facade.PessoaFacade;
import com.acme.feedback.model.Pessoa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
@Named
@RequestScoped
public class PessoaListaBean {

   @Inject
   private PessoaFacade facade;

   private String nome;

   private List<Pessoa> pessoas;

   public List<Pessoa> getPessoas() {
      return pessoas;
   }

   public PessoaFacade getFacade() {
      return facade;
   }

   public void setFacade(PessoaFacade facade) {
      this.facade = facade;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setPessoas(List<Pessoa> pessoas) {
      this.pessoas = pessoas;
   }

   public void pesquisa() {
      pessoas = facade.findName(nome);
      if (nome.equals("")) {
         pessoas = facade.findAll();
      }

   }
   
   public Pessoa find(Long id){
      Pessoa pessoa = facade.findId(id);
      return pessoa;
   }

   public String excluir(Pessoa pessoa) {
      facade.remove(pessoa);
      return "/pessoas/listar?faces-redirect=true";
   }

   @PostConstruct
   public void init() {
      pessoas = facade.findAll();
   }
}
