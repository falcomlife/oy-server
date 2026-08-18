package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.DictAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QDictAo;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocDictAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocDictAo<R> extends TQAssocBean<DictAo,R> {

  public PString<R> id;
  public PString<R> type;
  public PString<R> typeName;
  public PString<R> item;
  public PString<R> itemName;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QDictAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QDictAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QDictAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocDictAo(String name, R root) {
    super(name, root);
  }
}
