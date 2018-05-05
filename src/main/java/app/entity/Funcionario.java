package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela FUNCIONARIO
 * @generated
 */
@Entity
@Table(name = "\"FUNCIONARIO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Funcionario")
public class Funcionario implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "Nome", nullable = false, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "CPF", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String cpF;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataNascimento", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataAdmissao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAdmissao;

  /**
  * @generated
  */
  @Column(name = "Email", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String email;

  /**
  * @generated
  */
  @Column(name = "Cep", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String ceP;

  /**
  * @generated
  */
  @Column(name = "Endereco", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String endereco;

  /**
  * @generated
  */
  @Column(name = "Bairro", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String bairro;

  /**
  * @generated
  */
  @Column(name = "Cidade", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String cidade;

  /**
  * @generated
  */
  @Column(name = "Estado", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String estado;

  /**
  * @generated
  */
  @Column(name = "Telefone1", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String telefone1;

  /**
  * @generated
  */
  @Column(name = "Telefone2", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String telefone2;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean ativo;

  /**
  * @generated
  */
  @Column(name = "Meta", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer meta;

  /**
  * @generated
  */
  @OneToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
   * Construtor
   * @generated
   */
  public Funcionario(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Funcionario setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome
   * return nome
   * @generated
   */
  
  public java.lang.String getNome(){
    return this.nome;
  }

  /**
   * Define nome
   * @param nome nome
   * @generated
   */
  public Funcionario setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém cpF
   * return cpF
   * @generated
   */
  
  public java.lang.String getCpF(){
    return this.cpF;
  }

  /**
   * Define cpF
   * @param cpF cpF
   * @generated
   */
  public Funcionario setCpF(java.lang.String cpF){
    this.cpF = cpF;
    return this;
  }

  /**
   * Obtém dataNascimento
   * return dataNascimento
   * @generated
   */
  
  public java.util.Date getDataNascimento(){
    return this.dataNascimento;
  }

  /**
   * Define dataNascimento
   * @param dataNascimento dataNascimento
   * @generated
   */
  public Funcionario setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Obtém dataAdmissao
   * return dataAdmissao
   * @generated
   */
  
  public java.util.Date getDataAdmissao(){
    return this.dataAdmissao;
  }

  /**
   * Define dataAdmissao
   * @param dataAdmissao dataAdmissao
   * @generated
   */
  public Funcionario setDataAdmissao(java.util.Date dataAdmissao){
    this.dataAdmissao = dataAdmissao;
    return this;
  }

  /**
   * Obtém email
   * return email
   * @generated
   */
  
  public java.lang.String getEmail(){
    return this.email;
  }

  /**
   * Define email
   * @param email email
   * @generated
   */
  public Funcionario setEmail(java.lang.String email){
    this.email = email;
    return this;
  }

  /**
   * Obtém ceP
   * return ceP
   * @generated
   */
  
  public java.lang.String getCeP(){
    return this.ceP;
  }

  /**
   * Define ceP
   * @param ceP ceP
   * @generated
   */
  public Funcionario setCeP(java.lang.String ceP){
    this.ceP = ceP;
    return this;
  }

  /**
   * Obtém endereco
   * return endereco
   * @generated
   */
  
  public java.lang.String getEndereco(){
    return this.endereco;
  }

  /**
   * Define endereco
   * @param endereco endereco
   * @generated
   */
  public Funcionario setEndereco(java.lang.String endereco){
    this.endereco = endereco;
    return this;
  }

  /**
   * Obtém bairro
   * return bairro
   * @generated
   */
  
  public java.lang.String getBairro(){
    return this.bairro;
  }

  /**
   * Define bairro
   * @param bairro bairro
   * @generated
   */
  public Funcionario setBairro(java.lang.String bairro){
    this.bairro = bairro;
    return this;
  }

  /**
   * Obtém cidade
   * return cidade
   * @generated
   */
  
  public java.lang.String getCidade(){
    return this.cidade;
  }

  /**
   * Define cidade
   * @param cidade cidade
   * @generated
   */
  public Funcionario setCidade(java.lang.String cidade){
    this.cidade = cidade;
    return this;
  }

  /**
   * Obtém estado
   * return estado
   * @generated
   */
  
  public java.lang.String getEstado(){
    return this.estado;
  }

  /**
   * Define estado
   * @param estado estado
   * @generated
   */
  public Funcionario setEstado(java.lang.String estado){
    this.estado = estado;
    return this;
  }

  /**
   * Obtém telefone1
   * return telefone1
   * @generated
   */
  
  public java.lang.String getTelefone1(){
    return this.telefone1;
  }

  /**
   * Define telefone1
   * @param telefone1 telefone1
   * @generated
   */
  public Funcionario setTelefone1(java.lang.String telefone1){
    this.telefone1 = telefone1;
    return this;
  }

  /**
   * Obtém telefone2
   * return telefone2
   * @generated
   */
  
  public java.lang.String getTelefone2(){
    return this.telefone2;
  }

  /**
   * Define telefone2
   * @param telefone2 telefone2
   * @generated
   */
  public Funcionario setTelefone2(java.lang.String telefone2){
    this.telefone2 = telefone2;
    return this;
  }

  /**
   * Obtém ativo
   * return ativo
   * @generated
   */
  
  public java.lang.Boolean getAtivo(){
    return this.ativo;
  }

  /**
   * Define ativo
   * @param ativo ativo
   * @generated
   */
  public Funcionario setAtivo(java.lang.Boolean ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém meta
   * return meta
   * @generated
   */
  
  public java.lang.Integer getMeta(){
    return this.meta;
  }

  /**
   * Define meta
   * @param meta meta
   * @generated
   */
  public Funcionario setMeta(java.lang.Integer meta){
    this.meta = meta;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public Funcionario setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Funcionario object = (Funcionario)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
