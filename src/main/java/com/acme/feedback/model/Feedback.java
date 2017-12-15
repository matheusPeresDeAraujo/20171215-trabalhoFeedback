
package com.acme.feedback.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "FEEDBACK")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
   , @NamedQuery(name = "Feedback.findById", query = "SELECT f FROM Feedback f WHERE f.id = :id")
   , @NamedQuery(name = "Feedback.findByDataPublicacao", query = "SELECT f FROM Feedback f WHERE f.dataPublicacao = :dataPublicacao")
   , @NamedQuery(name = "Feedback.findByNota", query = "SELECT f FROM Feedback f WHERE f.nota = :nota")})
public class Feedback implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "ID")
   private Long id;
   @Basic(optional = false)
   @NotNull
   @Column(name = "DATA_PUBLICACAO")
   @Temporal(TemporalType.DATE)
   private Date dataPublicacao = new Date();
   @Basic(optional = false)
   @NotNull
   @Lob
   @Size(min = 1, max = 32700)
   @Column(name = "TEXTO")
   private String texto;
   // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @Column(name = "NOTA")
   private Double nota;
   @JoinColumn(name = "PESSOA", referencedColumnName = "ID")
   @ManyToOne
   private Pessoa pessoa;

   public Feedback() {
   }

   public Feedback(Long id) {
      this.id = id;
   }

   public Feedback(Long id, Date dataPublicacao, String texto) {
      this.id = id;
      this.dataPublicacao = dataPublicacao;
      this.texto = texto;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getDataPublicacao() {
      return dataPublicacao;
   }

   public void setDataPublicacao(Date dataPublicacao) {
      this.dataPublicacao = dataPublicacao;
   }

   public String getTexto() {
      return texto;
   }

   public void setTexto(String texto) {
      this.texto = texto;
   }

   public Double getNota() {
      return nota;
   }

   public void setNota(Double nota) {
      this.nota = nota;
   }

   public Pessoa getPessoa() {
      return pessoa;
   }

   public void setPessoa(Pessoa pessoa) {
      this.pessoa = pessoa;
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
      if (!(object instanceof Feedback)) {
         return false;
      }
      Feedback other = (Feedback) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.acme.feedback.model.Feedback[ id=" + id + " ]";
   }
   
}
