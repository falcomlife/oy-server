package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.RoleAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QRoleAo;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocRoleAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocRoleAo<R> extends TQAssocBean<RoleAo,R> {

  public PString<R> id;
  public PString<R> name;
  public PString<R> companyId;
  public PString<R> authorityId;
  public PBoolean<R> inUser;
  public PBoolean<R> authorityFlag;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PBoolean<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QRoleAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QRoleAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QRoleAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocRoleAo(String name, R root) {
    super(name, root);
  }
}
