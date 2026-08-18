package com.cotte.estate.bean.pojo.bo.storage.query.assoc;

import com.cotte.estate.bean.pojo.bo.storage.InStorageBo;
import com.cotte.estate.bean.pojo.bo.storage.query.QInStorageBo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocInStorageBo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocInStorageBo<R> extends TQAssocBean<InStorageBo,R> {

  public PString<R> id;
  public PString<R> customerName;
  public PString<R> orderId;
  public PString<R> outStorageId;
  public PString<R> code;
  public PString<R> image;
  public PString<R> name;
  public PBigDecimal<R> bunchCount;
  public PString<R> unit;
  public PString<R> bake;
  public PString<R> inCount;
  public PString<R> color;
  public PString<R> orderColor;
  public PString<R> badReason;
  public PString<R> incomingType;
  public PString<R> incomingReason;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QInStorageBo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QInStorageBo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QInStorageBo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocInStorageBo(String name, R root) {
    super(name, root);
  }
}
