package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela GRUPOPEDIDO
 * @generated
 */
@Entity
@Table(name = "\"GRUPOPEDIDO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.GrupoPedido")
public class GrupoPedido implements Serializable {

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
  @Column(name = "nome", nullable = false, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_tipoTrabalho", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private TipoTrabalho tipoTrabalho;

  /**
  * @generated
  */
  @Column(name = "idGrupo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String idGrupo;

  /**
   * Construtor
   * @generated
   */
  public GrupoPedido(){
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
  public GrupoPedido setId(java.lang.String id){
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
  public GrupoPedido setNome(java.lang.String nome){
    this.nome = nome;
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
  public GrupoPedido setTipoTrabalho(TipoTrabalho tipoTrabalho){
    this.tipoTrabalho = tipoTrabalho;
    return this;
  }

  /**
   * Obtém idGrupo
   * return idGrupo
   * @generated
   */
  
  public java.lang.String getIdGrupo(){
    return this.idGrupo;
  }

  /**
   * Define idGrupo
   * @param idGrupo idGrupo
   * @generated
   */
  public GrupoPedido setIdGrupo(java.lang.String idGrupo){
    this.idGrupo = idGrupo;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    GrupoPedido object = (GrupoPedido)obj;
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
