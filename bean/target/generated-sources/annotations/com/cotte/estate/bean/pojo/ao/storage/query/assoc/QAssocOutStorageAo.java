package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.OutStorageAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QOutStorageAo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOutStorageAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOutStorageAo<R> extends TQAssocBean<OutStorageAo,R> {

  public PString<R> id;
  public PString<R> orderId;
  public PInteger<R> orderPartSumCount;
  public PInteger<R> leftPartSumCount;
  public PString<R> inStorageId;
  public PString<R> inStorageCode;
  public PString<R> customerName;
  public PString<R> customerNameId;
  public PString<R> image;
  public PString<R> otimage;
  public PString<R> code;
  public PString<R> orderCode;
  public PString<R> name;
  public PString<R> poNum;
  public PString<R> item;
  public PString<R> part;
  public PString<R> color;
  public PString<R> colorId;
  public PString<R> count;
  public PBigDecimal<R> partSumCount;
  public PBigDecimal<R> bunchCount;
  public PString<R> bake;
  public PString<R> bakeId;
  public PString<R> outCount;
  public PString<R> outTypeId;
  public PString<R> outType;
  public PString<R> inCount;
  public PString<R> time;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOutStorageAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOutStorageAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOutStorageAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOutStorageAo(String name, R root) {
    super(name, root);
  }
}
