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
@Repository("EtapaItemPedidoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface EtapaItemPedidoDAO extends JpaRepository<EtapaItemPedido, java.lang.String> {

  /**
   * Obtém a instância de EtapaItemPedido utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM EtapaItemPedido entity WHERE entity.id = :id")
  public EtapaItemPedido findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de EtapaItemPedido utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM EtapaItemPedido entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key itemPedido
   * @generated
   */
  @Query("SELECT entity FROM EtapaItemPedido entity WHERE entity.itemPedido.id = :id")
  public Page<EtapaItemPedido> findEtapaItemPedidosByItemPedido(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key etapa
   * @generated
   */
  @Query("SELECT entity FROM EtapaItemPedido entity WHERE entity.etapa.id = :id")
  public Page<EtapaItemPedido> findEtapaItemPedidosByEtapa(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key funcionario
   * @generated
   */
  @Query("SELECT entity FROM EtapaItemPedido entity WHERE entity.funcionario.id = :id")
  public Page<EtapaItemPedido> findEtapaItemPedidosByFuncionario(@Param(value="id") java.lang.String id, Pageable pageable);

}
