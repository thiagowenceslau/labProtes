package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela SERVICO
 * @generated
 */
@Entity
@Table(name = "\"SERVICO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Servico")
public class Servico implements Serializable {

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
  @Column(name = "Descricao", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String descricao;

  /**
  * @generated
  */
  @Column(name = "DiasUteis", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer diasUteis;

  /**
  * @generated
  */
  @Column(name = "Preco1", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco1;

  /**
  * @generated
  */
  @Column(name = "Preco2", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco2;

  /**
  * @generated
  */
  @Column(name = "Preco3", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco3;

  /**
  * @generated
  */
  @Column(name = "Preco4", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco4;

  /**
  * @generated
  */
  @Column(name = "Preco5", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco5;

  /**
  * @generated
  */
  @Column(name = "Preco6", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco6;

  /**
  * @generated
  */
  @Column(name = "Preco7", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco7;

  /**
  * @generated
  */
  @Column(name = "Preco8", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco8;

  /**
  * @generated
  */
  @Column(name = "Preco9", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco9;

  /**
  * @generated
  */
  @Column(name = "Preco10", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco10;

  /**
  * @generated
  */
  @Column(name = "Preco11", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco11;

  /**
  * @generated
  */
  @Column(name = "Preco12", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double preco12;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean ativo;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_tipoTrabalho", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private TipoTrabalho tipoTrabalho;

  /**
   * Construtor
   * @generated
   */
  public Servico(){
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
  public Servico setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém descricao
   * return descricao
   * @generated
   */
  
  public java.lang.String getDescricao(){
    return this.descricao;
  }

  /**
   * Define descricao
   * @param descricao descricao
   * @generated
   */
  public Servico setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * Obtém diasUteis
   * return diasUteis
   * @generated
   */
  
  public java.lang.Integer getDiasUteis(){
    return this.diasUteis;
  }

  /**
   * Define diasUteis
   * @param diasUteis diasUteis
   * @generated
   */
  public Servico setDiasUteis(java.lang.Integer diasUteis){
    this.diasUteis = diasUteis;
    return this;
  }

  /**
   * Obtém preco1
   * return preco1
   * @generated
   */
  
  public java.lang.Double getPreco1(){
    return this.preco1;
  }

  /**
   * Define preco1
   * @param preco1 preco1
   * @generated
   */
  public Servico setPreco1(java.lang.Double preco1){
    this.preco1 = preco1;
    return this;
  }

  /**
   * Obtém preco2
   * return preco2
   * @generated
   */
  
  public java.lang.Double getPreco2(){
    return this.preco2;
  }

  /**
   * Define preco2
   * @param preco2 preco2
   * @generated
   */
  public Servico setPreco2(java.lang.Double preco2){
    this.preco2 = preco2;
    return this;
  }

  /**
   * Obtém preco3
   * return preco3
   * @generated
   */
  
  public java.lang.Double getPreco3(){
    return this.preco3;
  }

  /**
   * Define preco3
   * @param preco3 preco3
   * @generated
   */
  public Servico setPreco3(java.lang.Double preco3){
    this.preco3 = preco3;
    return this;
  }

  /**
   * Obtém preco4
   * return preco4
   * @generated
   */
  
  public java.lang.Double getPreco4(){
    return this.preco4;
  }

  /**
   * Define preco4
   * @param preco4 preco4
   * @generated
   */
  public Servico setPreco4(java.lang.Double preco4){
    this.preco4 = preco4;
    return this;
  }

  /**
   * Obtém preco5
   * return preco5
   * @generated
   */
  
  public java.lang.Double getPreco5(){
    return this.preco5;
  }

  /**
   * Define preco5
   * @param preco5 preco5
   * @generated
   */
  public Servico setPreco5(java.lang.Double preco5){
    this.preco5 = preco5;
    return this;
  }

  /**
   * Obtém preco6
   * return preco6
   * @generated
   */
  
  public java.lang.Double getPreco6(){
    return this.preco6;
  }

  /**
   * Define preco6
   * @param preco6 preco6
   * @generated
   */
  public Servico setPreco6(java.lang.Double preco6){
    this.preco6 = preco6;
    return this;
  }

  /**
   * Obtém preco7
   * return preco7
   * @generated
   */
  
  public java.lang.Double getPreco7(){
    return this.preco7;
  }

  /**
   * Define preco7
   * @param preco7 preco7
   * @generated
   */
  public Servico setPreco7(java.lang.Double preco7){
    this.preco7 = preco7;
    return this;
  }

  /**
   * Obtém preco8
   * return preco8
   * @generated
   */
  
  public java.lang.Double getPreco8(){
    return this.preco8;
  }

  /**
   * Define preco8
   * @param preco8 preco8
   * @generated
   */
  public Servico setPreco8(java.lang.Double preco8){
    this.preco8 = preco8;
    return this;
  }

  /**
   * Obtém preco9
   * return preco9
   * @generated
   */
  
  public java.lang.Double getPreco9(){
    return this.preco9;
  }

  /**
   * Define preco9
   * @param preco9 preco9
   * @generated
   */
  public Servico setPreco9(java.lang.Double preco9){
    this.preco9 = preco9;
    return this;
  }

  /**
   * Obtém preco10
   * return preco10
   * @generated
   */
  
  public java.lang.Double getPreco10(){
    return this.preco10;
  }

  /**
   * Define preco10
   * @param preco10 preco10
   * @generated
   */
  public Servico setPreco10(java.lang.Double preco10){
    this.preco10 = preco10;
    return this;
  }

  /**
   * Obtém preco11
   * return preco11
   * @generated
   */
  
  public java.lang.Double getPreco11(){
    return this.preco11;
  }

  /**
   * Define preco11
   * @param preco11 preco11
   * @generated
   */
  public Servico setPreco11(java.lang.Double preco11){
    this.preco11 = preco11;
    return this;
  }

  /**
   * Obtém preco12
   * return preco12
   * @generated
   */
  
  public java.lang.Double getPreco12(){
    return this.preco12;
  }

  /**
   * Define preco12
   * @param preco12 preco12
   * @generated
   */
  public Servico setPreco12(java.lang.Double preco12){
    this.preco12 = preco12;
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
  public Servico setAtivo(java.lang.Boolean ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém tipoTrabalho
   * return tipoTrabalho
   * @generated
   */
  
  public TipoTrabalho getTipoTrabalho(){
    return this.tipoTrabalho;
  }

  /**
   * Define tipoTrabalho
   * @param tipoTrabalho tipoTrabalho
   * @generated
   */
  public Servico setTipoTrabalho(TipoTrabalho tipoTrabalho){
    this.tipoTrabalho = tipoTrabalho;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Servico object = (Servico)obj;
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
