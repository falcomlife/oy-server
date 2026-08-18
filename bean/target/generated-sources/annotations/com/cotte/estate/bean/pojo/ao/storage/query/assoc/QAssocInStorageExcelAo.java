package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.InStorageExcelAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QInStorageExcelAo;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocInStorageExcelAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocInStorageExcelAo<R> extends TQAssocBean<InStorageExcelAo,R> {

  public PString<R> customerNameItem;
  public PString<R> incomingType;
  public PString<R> code;
  public PString<R> item;
  public PString<R> poNum;
  public PString<R> starttime;
  public PString<R> endtime;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QInStorageExcelAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QInStorageExcelAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QInStorageExcelAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocInStorageExcelAo(String name, R root) {
    super(name, root);
  }
}
