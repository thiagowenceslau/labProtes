package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela PEDIDO
 * @generated
 */
@Entity
@Table(name = "\"PEDIDO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Pedido")
public class Pedido implements Serializable {

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
  @Column(name = "Paciente", nullable = true, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String paciente;

  /**
  * @generated
  */
  @Column(name = "CodigoPaciente", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String codigoPaciente;

  /**
  * @generated
  */
  @Column(name = "Sexo", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String sexo;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataNascimentoPaciente", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimentoPaciente;

  /**
  * @generated
  */
  @Column(name = "IdadePaciente", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer idadePaciente;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataEntregaSolicitada", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataEntregaSolicitada;

  /**
  * @generated
  */
  @Column(name = "SituacaoPedido", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String situacaoPedido;

  /**
  * @generated
  */
  @Column(name = "Ativo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean ativo;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataEnvio", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataEnvio;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_cliente", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Cliente cliente;

  /**
  * @generated
  */
  @Column(name = "valor", nullable = true, unique = false, precision=2, insertable=true, updatable=true)
  
  private java.lang.Double valor;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DataFinalizado", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataFinalizado;

  /**
  * @generated
  */
  @Column(name = "observacoes", nullable = true, unique = false, length=150, insertable=true, updatable=true)
  
  private java.lang.String observacoes;

  /**
  * @generated
  */
  @Column(name = "protocolo", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String protocolo;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "dataPrevisao", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPrevisao;

  /**
   * Construtor
   * @generated
   */
  public Pedido(){
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
  public Pedido setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém paciente
   * return paciente
   * @generated
   */
  
  public java.lang.String getPaciente(){
    return this.paciente;
  }

  /**
   * Define paciente
   * @param paciente paciente
   * @generated
   */
  public Pedido setPaciente(java.lang.String paciente){
    this.paciente = paciente;
    return this;
  }

  /**
   * Obtém codigoPaciente
   * return codigoPaciente
   * @generated
   */
  
  public java.lang.String getCodigoPaciente(){
    return this.codigoPaciente;
  }

  /**
   * Define codigoPaciente
   * @param codigoPaciente codigoPaciente
   * @generated
   */
  public Pedido setCodigoPaciente(java.lang.String codigoPaciente){
    this.codigoPaciente = codigoPaciente;
    return this;
  }

  /**
   * Obtém sexo
   * return sexo
   * @generated
   */
  
  public java.lang.String getSexo(){
    return this.sexo;
  }

  /**
   * Define sexo
   * @param sexo sexo
   * @generated
   */
  public Pedido setSexo(java.lang.String sexo){
    this.sexo = sexo;
    return this;
  }

  /**
   * Obtém dataNascimentoPaciente
   * return dataNascimentoPaciente
   * @generated
   */
  
  public java.util.Date getDataNascimentoPaciente(){
    return this.dataNascimentoPaciente;
  }

  /**
   * Define dataNascimentoPaciente
   * @param dataNascimentoPaciente dataNascimentoPaciente
   * @generated
   */
  public Pedido setDataNascimentoPaciente(java.util.Date dataNascimentoPaciente){
    this.dataNascimentoPaciente = dataNascimentoPaciente;
    return this;
  }

  /**
   * Obtém idadePaciente
   * return idadePaciente
   * @generated
   */
  
  public java.lang.Integer getIdadePaciente(){
    return this.idadePaciente;
  }

  /**
   * Define idadePaciente
   * @param idadePaciente idadePaciente
   * @generated
   */
  public Pedido setIdadePaciente(java.lang.Integer idadePaciente){
    this.idadePaciente = idadePaciente;
    return this;
  }

  /**
   * Obtém dataEntregaSolicitada
   * return dataEntregaSolicitada
   * @generated
   */
  
  public java.util.Date getDataEntregaSolicitada(){
    return this.dataEntregaSolicitada;
  }

  /**
   * Define dataEntregaSolicitada
   * @param dataEntregaSolicitada dataEntregaSolicitada
   * @generated
   */
  public Pedido setDataEntregaSolicitada(java.util.Date dataEntregaSolicitada){
    this.dataEntregaSolicitada = dataEntregaSolicitada;
    return this;
  }

  /**
   * Obtém situacaoPedido
   * return situacaoPedido
   * @generated
   */
  
  public java.lang.String getSituacaoPedido(){
    return this.situacaoPedido;
  }

  /**
   * Define situacaoPedido
   * @param situacaoPedido situacaoPedido
   * @generated
   */
  public Pedido setSituacaoPedido(java.lang.String situacaoPedido){
    this.situacaoPedido = situacaoPedido;
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
  public Pedido setAtivo(java.lang.Boolean ativo){
    this.ativo = ativo;
    return this;
  }

  /**
   * Obtém dataEnvio
   * return dataEnvio
   * @generated
   */
  
  public java.util.Date getDataEnvio(){
    return this.dataEnvio;
  }

  /**
   * Define dataEnvio
   * @param dataEnvio dataEnvio
   * @generated
   */
  public Pedido setDataEnvio(java.util.Date dataEnvio){
    this.dataEnvio = dataEnvio;
    return this;
  }

  /**
   * Obtém cliente
   * return cliente
   * @generated
   */
  
  public Cliente getCliente(){
    return this.cliente;
  }

  /**
   * Define cliente
   * @param cliente cliente
   * @generated
   */
  public Pedido setCliente(Cliente cliente){
    this.cliente = cliente;
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
  public Pedido setValor(java.lang.Double valor){
    this.valor = valor;
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
  public Pedido setDataFinalizado(java.util.Date dataFinalizado){
    this.dataFinalizado = dataFinalizado;
    return this;
  }

  /**
   * Obtém observacoes
   * return observacoes
   * @generated
   */
  
  public java.lang.String getObservacoes(){
    return this.observacoes;
  }

  /**
   * Define observacoes
   * @param observacoes observacoes
   * @generated
   */
  public Pedido setObservacoes(java.lang.String observacoes){
    this.observacoes = observacoes;
    return this;
  }

  /**
   * Obtém protocolo
   * return protocolo
   * @generated
   */
  
  public java.lang.String getProtocolo(){
    return this.protocolo;
  }

  /**
   * Define protocolo
   * @param protocolo protocolo
   * @generated
   */
  public Pedido setProtocolo(java.lang.String protocolo){
    this.protocolo = protocolo;
    return this;
  }

  /**
   * Obtém dataPrevisao
   * return dataPrevisao
   * @generated
   */
  
  public java.util.Date getDataPrevisao(){
    return this.dataPrevisao;
  }

  /**
   * Define dataPrevisao
   * @param dataPrevisao dataPrevisao
   * @generated
   */
  public Pedido setDataPrevisao(java.util.Date dataPrevisao){
    this.dataPrevisao = dataPrevisao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pedido object = (Pedido)obj;
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
