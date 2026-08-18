package com.cotte.estate.bean.pojo.eto.query.assoc;

import com.cotte.estate.bean.pojo.eto.InStorageEto;
import com.cotte.estate.bean.pojo.eto.query.QInStorageEto;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocInStorageEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocInStorageEto<R> extends TQAssocBean<InStorageEto,R> {

  public PString<R> customerName;
  public PString<R> code;
  public PString<R> item;
  public PString<R> poNum;
  public PString<R> part;
  public PString<R> orderColor;
  public PString<R> bake;
  public PBigDecimal<R> count;
  public PInteger<R> orderPartSumCount;
  public PBigDecimal<R> bunchCount;
  public PString<R> unit;
  public PString<R> inCount;
  public PString<R> incomingType;
  public PString<R> badReason;
  public PString<R> time;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QInStorageEto>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QInStorageEto>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QInStorageEto>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocInStorageEto(String name, R root) {
    super(name, root);
  }
}
