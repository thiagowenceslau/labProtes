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
@Repository("SecaoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface SecaoDAO extends JpaRepository<Secao, java.lang.String> {

  /**
   * Obtém a instância de Secao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Secao entity WHERE entity.id = :id")
  public Secao findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Secao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Secao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Servico entity WHERE entity.secao.id = :id")
  public Page<Servico> findServico(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM EtapaComissao entity WHERE entity.secao.id = :id")
  public Page<EtapaComissao> findEtapaComissao(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.grupoServicos FROM Servico entity WHERE entity.secao.id = :id")
  public Page<GrupoServicos> listGrupoServicos(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Servico entity WHERE entity.secao.id = :instanceId AND entity.grupoServicos.id = :relationId")
  public int deleteGrupoServicos(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Secao entity WHERE entity.descricao like concat('%',coalesce(:search,''),'%')")
  public Page<Secao> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Secao entity WHERE (:descricao is null OR entity.descricao like concat('%',:descricao,'%'))")
  public Page<Secao> specificSearch(@Param(value="descricao") java.lang.String descricao, Pageable pageable);
  
}
