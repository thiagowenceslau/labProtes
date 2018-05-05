package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ETAPACOMISSAO
 * @generated
 */
@Entity
@Table(name = "\"ETAPACOMISSAO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.EtapaComissao")
public class EtapaComissao implements Serializable {

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
  @JoinColumn(name="fk_etapa", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Etapa etapa;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_secao", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Secao secao;

  /**
  * @generated
  */
  @Column(name = "tipo", nullable = true, unique = false, length=1, insertable=true, updatable=true)
  
  private java.lang.String tipo;

  /**
  * @generated
  */
  @Column(name = "Valor", nullable = false, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double valor;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean ativo;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_servico", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Servico servico;

  /**
   * Construtor
   * @generated
   */
  public EtapaComissao(){
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
  public EtapaComissao setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém etapa
   * return etapa
   * @generated
   */
  
  public Etapa getEtapa(){
    return this.etapa;
  }

  /**
   * Define etapa
   * @param etapa etapa
   * @generated
   */
  public EtapaComissao setEtapa(Etapa etapa){
    this.etapa = etapa;
    return this;
  }

  /**
   * Obtém secao
   * return secao
   * @generated
   */
  
  public Secao getSecao(){
    return this.secao;
  }

  /**
   * Define secao
   * @param secao secao
   * @generated
   */
  public EtapaComissao setSecao(Secao secao){
    this.secao = secao;
    return this;
  }

  /**
   * Obtém tipo
   * return tipo
   * @generated
   */
  
  public java.lang.String getTipo(){
    return this.tipo;
  }

  /**
   * Define tipo
   * @param tipo tipo
   * @generated
   */
  public EtapaComissao setTipo(java.lang.String tipo){
    this.tipo = tipo;
    return this;
  }

  /**
   * Obtém valor
   * return valor
   * @generated
   */
  
  public java.lang.Double getValor(){
    return this.valor;
  }

  /**
   * Define valor
   * @param valor valor
   * @generated
   */
  public EtapaComissao setValor(java.lang.Double valor){
    this.valor = valor;
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
  public EtapaComissao setAtivo(java.lang.Boolean ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém servico
   * return servico
   * @generated
   */
  
  public Servico getServico(){
    return this.servico;
  }

  /**
   * Define servico
   * @param servico servico
   * @generated
   */
  public EtapaComissao setServico(Servico servico){
    this.servico = servico;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    EtapaComissao object = (EtapaComissao)obj;
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
