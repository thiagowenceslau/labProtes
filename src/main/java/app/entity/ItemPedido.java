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
  @Column(name = "tipoMaterial", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String tipoMaterial;

  /**
  * @generated
  */
  @Column(name = "cor", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String cor;

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
   * Obtém tipoMaterial
   * return tipoMaterial
   * @generated
   */
  
  public java.lang.String getTipoMaterial(){
    return this.tipoMaterial;
  }

  /**
   * Define tipoMaterial
   * @param tipoMaterial tipoMaterial
   * @generated
   */
  public ItemPedido setTipoMaterial(java.lang.String tipoMaterial){
    this.tipoMaterial = tipoMaterial;
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
