package com.cotte.estate.bean.pojo.eto.query.assoc;

import com.cotte.estate.bean.pojo.eto.OrderEto;
import com.cotte.estate.bean.pojo.eto.query.QOrderEto;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOrderEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOrderEto<R> extends TQAssocBean<OrderEto,R> {

  public PString<R> code;
  public PString<R> customerName;
  public PString<R> poNum;
  public PString<R> item;
  public PString<R> part;
  public PString<R> color;
  public PString<R> bake;
  public PBigDecimal<R> count;
  public PBigDecimal<R> price;
  public PBigDecimal<R> sum;
  public PBigDecimal<R> partSumCount;
  public PInteger<R> partSumCountCal;
  public PInteger<R> outStroageGoodsSumCount;
  public PInteger<R> partSumCountSubOutStroageGoodsSumCount;
  public PInteger<R> overPartSumCount;
  public PInteger<R> replatCount;
  public PBigDecimal<R> replatRatio;
  public PInteger<R> incomingCount;
  public PBigDecimal<R> incomingRatio;
  public PInteger<R> outStroagePrimingSumCount;
  public PBigDecimal<R> outStroagePrimingSumCountRatio;
  public PString<R> delTime;
  public PUtilDate<R> deliveryTime;
  public PString<R> time;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOrderEto>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOrderEto>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOrderEto>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOrderEto(String name, R root) {
    super(name, root);
  }
}
