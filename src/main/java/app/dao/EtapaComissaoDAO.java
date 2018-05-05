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
@Repository("EtapaComissaoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface EtapaComissaoDAO extends JpaRepository<EtapaComissao, java.lang.String> {

  /**
   * Obtém a instância de EtapaComissao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM EtapaComissao entity WHERE entity.id = :id")
  public EtapaComissao findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de EtapaComissao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM EtapaComissao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key etapa
   * @generated
   */
  @Query("SELECT entity FROM EtapaComissao entity WHERE entity.etapa.id = :id")
  public Page<EtapaComissao> findEtapaComissaosByEtapa(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key secao
   * @generated
   */
  @Query("SELECT entity FROM EtapaComissao entity WHERE entity.secao.id = :id")
  public Page<EtapaComissao> findEtapaComissaosBySecao(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key servico
   * @generated
   */
  @Query("SELECT entity FROM EtapaComissao entity WHERE entity.servico.id = :id")
  public Page<EtapaComissao> findEtapaComissaosByServico(@Param(value="id") java.lang.String id, Pageable pageable);

}
