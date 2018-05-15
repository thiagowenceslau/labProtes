package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ITEMPEDIDO
 * @generated
 */
@Entity
@Table(name = "\"ITEMPEDIDO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ItemPedido")
public class ItemPedido implements Serializable {

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
  @ManyToOne
  @JoinColumn(name="fk_pedido", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Pedido pedido;

  /**
  * @generated
  */
  @Column(name = "tipoTrabalho", nullable = false, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String tipoTrabalho;

  /**
  * @generated
  */
  @Column(name = "dente", nullable = true, unique = false, length=5, insertable=true, updatable=true)
  
  private java.lang.String dente;

  /**
  * @generated
  */
  @Column(name = "servico", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String servico;

  /**
  * @generated
  */
  @Column(name = "cor", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String cor;

  /**
  * @generated
  */
  @Column(name = "situacaoEtapa", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String situacaoEtapa;

  /**
  * @generated
  */
  @Column(name = "valorServico", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Double valorServico;

  /**
   * Construtor
   * @generated
   */
  public ItemPedido(){
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
  public ItemPedido setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém pedido
   * return pedido
   * @generated
   */
  
  public Pedido getPedido(){
    return this.pedido;
  }

  /**
   * Define pedido
   * @param pedido pedido
   * @generated
   */
  public ItemPedido setPedido(Pedido pedido){
    this.pedido = pedido;
    return this;
  }

  /**
   * Obtém tipoTrabalho
   * return tipoTrabalho
   * @generated
   */
  
  public java.lang.String getTipoTrabalho(){
    return this.tipoTrabalho;
  }

  /**
   * Define tipoTrabalho
   * @param tipoTrabalho tipoTrabalho
   * @generated
   */
  public ItemPedido setTipoTrabalho(java.lang.String tipoTrabalho){
    this.tipoTrabalho = tipoTrabalho;
    return this;
  }

  /**
   * Obtém dente
   * return dente
   * @generated
   */
  
  public java.lang.String getDente(){
    return this.dente;
  }

  /**
   * Define dente
   * @param dente dente
   * @generated
   */
  public ItemPedido setDente(java.lang.String dente){
    this.dente = dente;
    return this;
  }

  /**
   * Obtém servico
   * return servico
   * @generated
   */
  
  public java.lang.String getServico(){
    return this.servico;
  }

  /**
   * Define servico
   * @param servico servico
   * @generated
   */
  public ItemPedido setServico(java.lang.String servico){
    this.servico = servico;
    return this;
  }

  /**
   * Obtém cor
   * return cor
   * @generated
   */
  
  public java.lang.String getCor(){
    return this.cor;
  }

  /**
   * Define cor
   * @param cor cor
   * @generated
   */
  public ItemPedido setCor(java.lang.String cor){
    this.cor = cor;
    return this;
  }

  /**
   * Obtém situacaoEtapa
   * return situacaoEtapa
   * @generated
   */
  
  public java.lang.String getSituacaoEtapa(){
    return this.situacaoEtapa;
  }

  /**
   * Define situacaoEtapa
   * @param situacaoEtapa situacaoEtapa
   * @generated
   */
  public ItemPedido setSituacaoEtapa(java.lang.String situacaoEtapa){
    this.situacaoEtapa = situacaoEtapa;
    return this;
  }

  /**
   * Obtém valorServico
   * return valorServico
   * @generated
   */
  
  public java.lang.Double getValorServico(){
    return this.valorServico;
  }

  /**
   * Define valorServico
   * @param valorServico valorServico
   * @generated
   */
  public ItemPedido setValorServico(java.lang.Double valorServico){
    this.valorServico = valorServico;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ItemPedido object = (ItemPedido)obj;
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
