package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.OrderAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QOrderAo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOrderAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOrderAo<R> extends TQAssocBean<OrderAo,R> {

  public PString<R> id;
  public PString<R> orderGroupId;
  public PString<R> orderGroupCode;
  public PString<R> code;
  public PString<R> customerName;
  public PString<R> customerNameId;
  public PString<R> image;
  public PString<R> poNum;
  public PString<R> item;
  public PString<R> part;
  public PString<R> productNo;
  public PString<R> color;
  public PString<R> bake;
  public PString<R> bakeId;
  public PString<R> colorId;
  public PBigDecimal<R> count;
  public PBigDecimal<R> partSumCount;
  public PInteger<R> partSumCountCal;
  public PInteger<R> outStroageGoodsSumCount;
  public PInteger<R> outStroagePrimingSumCount;
  public PBigDecimal<R> outStroagePrimingSumCountRatio;
  public PBigDecimal<R> outStroageSumCount;
  public PInteger<R> partSumCountSubOutStroageGoodsSumCount;
  public PInteger<R> overPartSumCount;
  public PInteger<R> replatCount;
  public PBigDecimal<R> replatRatio;
  public PInteger<R> incomingCount;
  public PBigDecimal<R> incomingRatio;
  public PBoolean<R> incomingBigger;
  public PBoolean<R> outStorageBigger;
  public PUtilDate<R> deliveryTime;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOrderAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOrderAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOrderAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOrderAo(String name, R root) {
    super(name, root);
  }
}
