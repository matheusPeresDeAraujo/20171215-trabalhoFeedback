
package com.acme.feedback.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "CARGO")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
   , @NamedQuery(name = "Cargo.findById", query = "SELECT c FROM Cargo c WHERE c.id = :id")
   , @NamedQuery(name = "Cargo.findByNome", query = "SELECT c FROM Cargo c WHERE c.nome = :nome")})
public class Cargo implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "ID")
   private Long id;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "NOME")
   private String nome;
   @OneToMany(mappedBy = "cargo")
   private Collection<Pessoa> pessoaCollection;

   public Cargo() {
   }

   public Cargo(Long id) {
      this.id = id;
   }

   public Cargo(Long id, String nome) {
      this.id = id;
      this.nome = nome;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   @XmlTransient
   public Collection<Pessoa> getPessoaCollection() {
      return pessoaCollection;
   }

   public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
      this.pessoaCollection = pessoaCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Cargo)) {
         return false;
      }
      Cargo other = (Cargo) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.acme.feedback.model.Cargo[ id=" + id + " ]";
   }
   
}
