package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ETAPAITEMPEDIDO
 * @generated
 */
@Entity
@Table(name = "\"ETAPAITEMPEDIDO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.EtapaItemPedido")
public class EtapaItemPedido implements Serializable {

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
  @JoinColumn(name="fk_itemPedido", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private ItemPedido itemPedido;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_etapa", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Etapa etapa;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_funcionario", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Funcionario funcionario;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataPrevisaoEntrega", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPrevisaoEntrega;

  /**
  * @generated
  */
  @Temporal(TemporalType.TIME)
  @Column(name = "horaPrevisaoEntega", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date horaPrevisaoEntrega;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataFinalizado", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataFinalizado;

  /**
  * @generated
  */
  @Temporal(TemporalType.TIME)
  @Column(name = "horaFinalzada", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date horaFinalzada;

  /**
  * @generated
  */
  @Column(name = "situacao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String situacao;

  /**
   * Construtor
   * @generated
   */
  public EtapaItemPedido(){
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
  public EtapaItemPedido setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém itemPedido
   * return itemPedido
   * @generated
   */
  
  public ItemPedido getItemPedido(){
    return this.itemPedido;
  }

  /**
   * Define itemPedido
   * @param itemPedido itemPedido
   * @generated
   */
  public EtapaItemPedido setItemPedido(ItemPedido itemPedido){
    this.itemPedido = itemPedido;
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
  public EtapaItemPedido setEtapa(Etapa etapa){
    this.etapa = etapa;
    return this;
  }

  /**
   * Obtém funcionario
   * return funcionario
   * @generated
   */
  
  public Funcionario getFuncionario(){
    return this.funcionario;
  }

  /**
   * Define funcionario
   * @param funcionario funcionario
   * @generated
   */
  public EtapaItemPedido setFuncionario(Funcionario funcionario){
    this.funcionario = funcionario;
    return this;
  }

  /**
   * Obtém dataPrevisaoEntrega
   * return dataPrevisaoEntrega
   * @generated
   */
  
  public java.util.Date getDataPrevisaoEntrega(){
    return this.dataPrevisaoEntrega;
  }

  /**
   * Define dataPrevisaoEntrega
   * @param dataPrevisaoEntrega dataPrevisaoEntrega
   * @generated
   */
  public EtapaItemPedido setDataPrevisaoEntrega(java.util.Date dataPrevisaoEntrega){
    this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    return this;
  }

  /**
   * Obtém horaPrevisaoEntrega
   * return horaPrevisaoEntrega
   * @generated
   */
  
  public java.util.Date getHoraPrevisaoEntrega(){
    return this.horaPrevisaoEntrega;
  }

  /**
   * Define horaPrevisaoEntrega
   * @param horaPrevisaoEntrega horaPrevisaoEntrega
   * @generated
   */
  public EtapaItemPedido setHoraPrevisaoEntrega(java.util.Date horaPrevisaoEntrega){
    this.horaPrevisaoEntrega = horaPrevisaoEntrega;
    return this;
  }

  /**
   * Obtém dataFinalizado
   * return dataFinalizado
   * @generated
   */
  
  public java.util.Date getDataFinalizado(){
    return this.dataFinalizado;
  }

  /**
   * Define dataFinalizado
   * @param dataFinalizado dataFinalizado
   * @generated
   */
  public EtapaItemPedido setDataFinalizado(java.util.Date dataFinalizado){
    this.dataFinalizado = dataFinalizado;
    return this;
  }

  /**
   * Obtém horaFinalzada
   * return horaFinalzada
   * @generated
   */
  
  public java.util.Date getHoraFinalzada(){
    return this.horaFinalzada;
  }

  /**
   * Define horaFinalzada
   * @param horaFinalzada horaFinalzada
   * @generated
   */
  public EtapaItemPedido setHoraFinalzada(java.util.Date horaFinalzada){
    this.horaFinalzada = horaFinalzada;
    return this;
  }

  /**
   * Obtém situacao
   * return situacao
   * @generated
   */
  
  public java.lang.String getSituacao(){
    return this.situacao;
  }

  /**
   * Define situacao
   * @param situacao situacao
   * @generated
   */
  public EtapaItemPedido setSituacao(java.lang.String situacao){
    this.situacao = situacao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    EtapaItemPedido object = (EtapaItemPedido)obj;
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
