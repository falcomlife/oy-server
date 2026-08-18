package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.InStorageAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QInStorageAo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocInStorageAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocInStorageAo<R> extends TQAssocBean<InStorageAo,R> {

  public PString<R> id;
  public PString<R> orderId;
  public PString<R> orderCode;
  public PString<R> outStorageId;
  public PString<R> outStorageCode;
  public PString<R> code;
  public PString<R> customerName;
  public PString<R> customerNameId;
  public PString<R> image;
  public PString<R> name;
  public PString<R> poNum;
  public PString<R> item;
  public PString<R> part;
  public PString<R> color;
  public PString<R> colorId;
  public PString<R> orderColor;
  public PString<R> orderColorId;
  public PBigDecimal<R> count;
  public PBigDecimal<R> partSumCount;
  public PBigDecimal<R> bunchCount;
  public PBigDecimal<R> remainCount;
  public PInteger<R> stayDays;
  public PString<R> bake;
  public PString<R> bakeId;
  public PString<R> inCount;
  public PString<R> unit;
  public PString<R> unitId;
  public PBigDecimal<R> price;
  public PBigDecimal<R> sum;
  public PString<R> incomingType;
  public PString<R> badReason;
  public PString<R> incomingTypeId;
  public PString<R> incomingReason;
  public PString<R> expandType;
  public QAssocOutStorageAo<R> outStorageList;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QInStorageAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QInStorageAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QInStorageAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocInStorageAo(String name, R root) {
    super(name, root);
  }
}
