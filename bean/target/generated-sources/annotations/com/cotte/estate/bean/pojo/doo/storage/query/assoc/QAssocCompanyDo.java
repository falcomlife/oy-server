package com.cotte.estate.bean.pojo.doo.storage.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.CompanyDo;
import com.cotte.estate.bean.pojo.doo.storage.query.QCompanyDo;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocCompanyDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocCompanyDo<R> extends TQAssocBean<CompanyDo,R> {

  public PString<R> id;
  public PString<R> name;
  public PString<R> code;
  public PBoolean<R> isEnable;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PBoolean<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QCompanyDo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QCompanyDo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QCompanyDo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocCompanyDo(String name, R root) {
    super(name, root);
  }
}
