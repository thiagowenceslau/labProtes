package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("ServicoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface ServicoDAO extends JpaRepository<Servico, java.lang.String> {

  /**
   * Obtém a instância de Servico utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Servico entity WHERE entity.id = :id")
  public Servico findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Servico utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Servico entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM EtapaComissao entity WHERE entity.servico.id = :id")
  public Page<EtapaComissao> findEtapaComissao(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ItemPedido entity WHERE entity.servico.id = :id")
  public Page<ItemPedido> findItemPedido(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.pedido FROM ItemPedido entity WHERE entity.servico.id = :id")
  public Page<Pedido> listPedido(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM ItemPedido entity WHERE entity.servico.id = :instanceId AND entity.pedido.id = :relationId")
  public int deletePedido(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * Foreign Key tipoTrabalho
   * @generated
   */
  @Query("SELECT entity FROM Servico entity WHERE entity.tipoTrabalho.id = :id")
  public Page<Servico> findServicosByTipoTrabalho(@Param(value="id") java.lang.String id, Pageable pageable);

}
