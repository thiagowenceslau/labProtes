package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela TIPOMATERIAL
 * @generated
 */
@Entity
@Table(name = "\"TIPOMATERIAL\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.TipoMaterial")
public class TipoMaterial implements Serializable {

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
  @Column(name = "ativo", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String ativo;

  /**
  * @generated
  */
  @Column(name = "excluir", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean excluir;

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
  public TipoMaterial(){
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
  public TipoMaterial setId(java.lang.String id){
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
  public TipoMaterial setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém ativo
   * return ativo
   * @generated
   */
  
  public java.lang.String getAtivo(){
    return this.ativo;
  }

  /**
   * Define ativo
   * @param ativo ativo
   * @generated
   */
  public TipoMaterial setAtivo(java.lang.String ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém excluir
   * return excluir
   * @generated
   */
  
  public java.lang.Boolean getExcluir(){
    return this.excluir;
  }

  /**
   * Define excluir
   * @param excluir excluir
   * @generated
   */
  public TipoMaterial setExcluir(java.lang.Boolean excluir){
    this.excluir = excluir;
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
  public TipoMaterial setTipoTrabalho(TipoTrabalho tipoTrabalho){
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
    TipoMaterial object = (TipoMaterial)obj;
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
