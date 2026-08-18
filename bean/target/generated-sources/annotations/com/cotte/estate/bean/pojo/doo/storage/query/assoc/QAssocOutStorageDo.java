package com.cotte.estate.bean.pojo.doo.storage.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import com.cotte.estate.bean.pojo.doo.storage.query.QOutStorageDo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOutStorageDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOutStorageDo<R> extends TQAssocBean<OutStorageDo,R> {

  public PString<R> id;
  public PString<R> inStorageId;
  public PString<R> image;
  public PString<R> code;
  public PBigDecimal<R> bunchCount;
  public PString<R> outCount;
  public PString<R> outType;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOutStorageDo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOutStorageDo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOutStorageDo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOutStorageDo(String name, R root) {
    super(name, root);
  }
}
