package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela CLIENTE
 * @generated
 */
@Entity
@Table(name = "\"CLIENTE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Cliente")
public class Cliente implements Serializable {

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
  @Column(name = "CRO", nullable = false, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String crO;

  /**
  * @generated
  */
  @Column(name = "Especialidade", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String especialidade;

  /**
  * @generated
  */
  @Column(name = "RG", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String rg;

  /**
  * @generated
  */
  @Column(name = "CPF", nullable = true, unique = false, length=12, insertable=true, updatable=true)
  
  private java.lang.String cpF;

  /**
  * @generated
  */
  @Column(name = "Telefone1", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String telefone1;

  /**
  * @generated
  */
  @Column(name = "Telefone2", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String telefone2;

  /**
  * @generated
  */
  @Column(name = "CEP", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String ceP;

  /**
  * @generated
  */
  @Column(name = "Endereco", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String endereco;

  /**
  * @generated
  */
  @Column(name = "Bairro", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
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
  @Temporal(TemporalType.DATE)
  @Column(name = "DataNascimento", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean ativo;

  /**
  * @generated
  */
  @OneToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
  * @generated
  */
  @Column(name = "RazaoSocial", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String razaoSocial;

  /**
  * @generated
  */
  @Column(name = "CNPJ", nullable = true, unique = false, length=20, insertable=true, updatable=true)
  
  private java.lang.String cnPJ;

  /**
  * @generated
  */
  @Column(name = "InscricaoEstadual", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String inscricaoEstadual;

  /**
  * @generated
  */
  @Column(name = "InscricaoMunicipal", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String inscricaoMunicipal;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_listaPreco", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private ListaPreco listaPreco;

  /**
   * Construtor
   * @generated
   */
  public Cliente(){
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
  public Cliente setId(java.lang.String id){
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
  public Cliente setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém crO
   * return crO
   * @generated
   */
  
  public java.lang.String getCrO(){
    return this.crO;
  }

  /**
   * Define crO
   * @param crO crO
   * @generated
   */
  public Cliente setCrO(java.lang.String crO){
    this.crO = crO;
    return this;
  }

  /**
   * Obtém especialidade
   * return especialidade
   * @generated
   */
  
  public java.lang.String getEspecialidade(){
    return this.especialidade;
  }

  /**
   * Define especialidade
   * @param especialidade especialidade
   * @generated
   */
  public Cliente setEspecialidade(java.lang.String especialidade){
    this.especialidade = especialidade;
    return this;
  }

  /**
   * Obtém rg
   * return rg
   * @generated
   */
  
  public java.lang.String getRg(){
    return this.rg;
  }

  /**
   * Define rg
   * @param rg rg
   * @generated
   */
  public Cliente setRg(java.lang.String rg){
    this.rg = rg;
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
  public Cliente setCpF(java.lang.String cpF){
    this.cpF = cpF;
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
  public Cliente setTelefone1(java.lang.String telefone1){
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
  public Cliente setTelefone2(java.lang.String telefone2){
    this.telefone2 = telefone2;
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
  public Cliente setCeP(java.lang.String ceP){
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
  public Cliente setEndereco(java.lang.String endereco){
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
  public Cliente setBairro(java.lang.String bairro){
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
  public Cliente setCidade(java.lang.String cidade){
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
  public Cliente setEstado(java.lang.String estado){
    this.estado = estado;
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
  public Cliente setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
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
  public Cliente setAtivo(java.lang.Boolean ativo){
    this.ativo = ativo;
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
  public Cliente setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * Obtém razaoSocial
   * return razaoSocial
   * @generated
   */
  
  public java.lang.String getRazaoSocial(){
    return this.razaoSocial;
  }

  /**
   * Define razaoSocial
   * @param razaoSocial razaoSocial
   * @generated
   */
  public Cliente setRazaoSocial(java.lang.String razaoSocial){
    this.razaoSocial = razaoSocial;
    return this;
  }

  /**
   * Obtém cnPJ
   * return cnPJ
   * @generated
   */
  
  public java.lang.String getCnPJ(){
    return this.cnPJ;
  }

  /**
   * Define cnPJ
   * @param cnPJ cnPJ
   * @generated
   */
  public Cliente setCnPJ(java.lang.String cnPJ){
    this.cnPJ = cnPJ;
    return this;
  }

  /**
   * Obtém inscricaoEstadual
   * return inscricaoEstadual
   * @generated
   */
  
  public java.lang.String getInscricaoEstadual(){
    return this.inscricaoEstadual;
  }

  /**
   * Define inscricaoEstadual
   * @param inscricaoEstadual inscricaoEstadual
   * @generated
   */
  public Cliente setInscricaoEstadual(java.lang.String inscricaoEstadual){
    this.inscricaoEstadual = inscricaoEstadual;
    return this;
  }

  /**
   * Obtém inscricaoMunicipal
   * return inscricaoMunicipal
   * @generated
   */
  
  public java.lang.String getInscricaoMunicipal(){
    return this.inscricaoMunicipal;
  }

  /**
   * Define inscricaoMunicipal
   * @param inscricaoMunicipal inscricaoMunicipal
   * @generated
   */
  public Cliente setInscricaoMunicipal(java.lang.String inscricaoMunicipal){
    this.inscricaoMunicipal = inscricaoMunicipal;
    return this;
  }

  /**
   * Obtém listaPreco
   * return listaPreco
   * @generated
   */
  
  public ListaPreco getListaPreco(){
    return this.listaPreco;
  }

  /**
   * Define listaPreco
   * @param listaPreco listaPreco
   * @generated
   */
  public Cliente setListaPreco(ListaPreco listaPreco){
    this.listaPreco = listaPreco;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Cliente object = (Cliente)obj;
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
