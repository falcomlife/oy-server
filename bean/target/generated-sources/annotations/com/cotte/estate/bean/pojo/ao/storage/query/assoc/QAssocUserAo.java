package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.UserAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QUserAo;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocUserAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocUserAo<R> extends TQAssocBean<UserAo,R> {

  public PString<R> id;
  public PString<R> companyId;
  public PString<R> roleId;
  public PString<R> companyCode;
  public PString<R> name;
  public PString<R> code;
  public PString<R> account;
  public PString<R> password;
  public PString<R> newPassword;
  public PBoolean<R> isLock;
  public PString<R> isLockName;
  public PBoolean<R> roleFlag;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PBoolean<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QUserAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QUserAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QUserAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocUserAo(String name, R root) {
    super(name, root);
  }
}
