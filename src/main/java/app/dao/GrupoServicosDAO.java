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
@Repository("GrupoServicosDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface GrupoServicosDAO extends JpaRepository<GrupoServicos, java.lang.String> {

  /**
   * Obtém a instância de GrupoServicos utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM GrupoServicos entity WHERE entity.id = :id")
  public GrupoServicos findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de GrupoServicos utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM GrupoServicos entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Servico entity WHERE entity.grupoServicos.id = :id")
  public Page<Servico> findServico(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.secao FROM Servico entity WHERE entity.grupoServicos.id = :id AND (entity.secao.descricao like concat('%',coalesce(:search,''),'%'))")
  public Page<Secao> listSecaoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.secao FROM Servico entity WHERE entity.grupoServicos.id = :id AND (:descricao is null OR entity.secao.descricao like concat('%',:descricao,'%'))")
  public Page<Secao> listSecaoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="descricao") java.lang.String descricao, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.secao FROM Servico entity WHERE entity.grupoServicos.id = :id")
  public Page<Secao> listSecao(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Servico entity WHERE entity.grupoServicos.id = :instanceId AND entity.secao.id = :relationId")
  public int deleteSecao(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

}
