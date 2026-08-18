package com.cotte.estate.bean.pojo.eto.query.assoc;

import com.cotte.estate.bean.pojo.eto.OutStorageEto;
import com.cotte.estate.bean.pojo.eto.query.QOutStorageEto;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOutStorageEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOutStorageEto<R> extends TQAssocBean<OutStorageEto,R> {

  public PString<R> code;
  public PString<R> orderCode;
  public PString<R> customerName;
  public PString<R> poNum;
  public PString<R> item;
  public PString<R> part;
  public PString<R> color;
  public PString<R> bake;
  public PString<R> count;
  public PInteger<R> orderPartSumCount;
  public PString<R> inCount;
  public PString<R> outCount;
  public PBigDecimal<R> bunchCount;
  public PInteger<R> leftPartSumCount;
  public PString<R> outType;
  public PString<R> time;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOutStorageEto>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOutStorageEto>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOutStorageEto>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOutStorageEto(String name, R root) {
    super(name, root);
  }
}
