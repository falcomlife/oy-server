package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.OutStorageExcelAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QOutStorageExcelAo;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOutStorageExcelAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOutStorageExcelAo<R> extends TQAssocBean<OutStorageExcelAo,R> {

  public PString<R> customerNameItem;
  public PString<R> code;
  public PString<R> item;
  public PString<R> poNum;
  public PString<R> starttime;
  public PString<R> endtime;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOutStorageExcelAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOutStorageExcelAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOutStorageExcelAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOutStorageExcelAo(String name, R root) {
    super(name, root);
  }
}
