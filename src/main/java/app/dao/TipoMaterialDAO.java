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
@Repository("TipoMaterialDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface TipoMaterialDAO extends JpaRepository<TipoMaterial, java.lang.String> {

  /**
   * Obtém a instância de TipoMaterial utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM TipoMaterial entity WHERE entity.id = :id")
  public TipoMaterial findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de TipoMaterial utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM TipoMaterial entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);


    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM ModoDesign entity WHERE entity.tipoMaterial.id = :id AND (entity.nome like concat('%',coalesce(:search,''),'%'))")
  public Page<ModoDesign> findModoDesignGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM ModoDesign entity WHERE entity.tipoMaterial.id = :id AND (:nome is null OR entity.nome like concat('%',:nome,'%'))")
  public Page<ModoDesign> findModoDesignSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ModoDesign entity WHERE entity.tipoMaterial.id = :id")
  public Page<ModoDesign> findModoDesign(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key tipoTrabalho
   * @generated
   */
  @Query("SELECT entity FROM TipoMaterial entity WHERE entity.tipoTrabalho.id = :id")
  public Page<TipoMaterial> findTipoMaterialsByTipoTrabalho(@Param(value="id") java.lang.String id, Pageable pageable);

}
