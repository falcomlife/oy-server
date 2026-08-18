package com.cotte.estate.bean.pojo.doo.storage.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.AuthorityDo;
import com.cotte.estate.bean.pojo.doo.storage.query.QAuthorityDo;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocAuthorityDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocAuthorityDo<R> extends TQAssocBean<AuthorityDo,R> {

  public PString<R> id;
  public PString<R> name;
  public PInteger<R> type;
  public PString<R> code;
  public PInteger<R> user;
  public PBoolean<R> isEnable;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PBoolean<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QAuthorityDo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QAuthorityDo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QAuthorityDo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocAuthorityDo(String name, R root) {
    super(name, root);
  }
}
