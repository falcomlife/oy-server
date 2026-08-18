package com.cotte.estate.bean.pojo.doo.storage.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.UserDo;
import com.cotte.estate.bean.pojo.doo.storage.query.QUserDo;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocUserDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocUserDo<R> extends TQAssocBean<UserDo,R> {

  public PString<R> id;
  public PString<R> companyId;
  public PString<R> name;
  public PString<R> account;
  public PString<R> code;
  public PString<R> password;
  public PBoolean<R> isLock;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PBoolean<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QUserDo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QUserDo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QUserDo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocUserDo(String name, R root) {
    super(name, root);
  }
}
