
package com.acme.feedback.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "PESSOA")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
   , @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id")
   , @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome")
   , @NamedQuery(name = "Pessoa.findBySobrenome", query = "SELECT p FROM Pessoa p WHERE p.sobrenome = :sobrenome")
   , @NamedQuery(name = "Pessoa.findByNascimento", query = "SELECT p FROM Pessoa p WHERE p.nascimento = :nascimento")
   , @NamedQuery(name = "Pessoa.findByFotoUrl", query = "SELECT p FROM Pessoa p WHERE p.fotoUrl = :fotoUrl")
   , @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email")})
public class Pessoa implements Serializable {

   @OneToMany(mappedBy = "pessoa")
   private Collection<Feedback> feedbackCollection;

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
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "SOBRENOME")
   private String sobrenome;
   @Basic(optional = false)
   @NotNull
   @Column(name = "NASCIMENTO")
   @Temporal(TemporalType.TIMESTAMP)
   private Date nascimento;
   @Size(max = 255)
   @Column(name = "FOTO_URL")
   private String fotoUrl;
   // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "EMAIL")
   private String email;
   @Lob
   @Size(max = 32700)
   @Column(name = "BIO")
   private String bio;
   @JoinColumn(name = "CARGO", referencedColumnName = "ID")
   @ManyToOne
   private Cargo cargo;

   public Pessoa() {
   }

   public Pessoa(Long id) {
      this.id = id;
   }

   public Pessoa(Long id, String nome, String sobrenome, Date nascimento, String email) {
      this.id = id;
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.nascimento = nascimento;
      this.email = email;
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

   public String getSobrenome() {
      return sobrenome;
   }

   public void setSobrenome(String sobrenome) {
      this.sobrenome = sobrenome;
   }

   public Date getNascimento() {
      return nascimento;
   }

   public void setNascimento(Date nascimento) {
      this.nascimento = nascimento;
   }

   public String getFotoUrl() {
      return fotoUrl;
   }

   public void setFotoUrl(String fotoUrl) {
      this.fotoUrl = fotoUrl;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getBio() {
      return bio;
   }

   public void setBio(String bio) {
      this.bio = bio;
   }

   public Cargo getCargo() {
      return cargo;
   }

   public void setCargo(Cargo cargo) {
      this.cargo = cargo;
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
      if (!(object instanceof Pessoa)) {
         return false;
      }
      Pessoa other = (Pessoa) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.acme.feedback.model.Pessoa[ id=" + id + " ]";
   }

   @XmlTransient
   public Collection<Feedback> getFeedbackCollection() {
      return feedbackCollection;
   }

   public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
      this.feedbackCollection = feedbackCollection;
   }
   
}
