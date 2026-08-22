package com.cotte.estate.bean.pojo.doo.storage.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import com.cotte.estate.bean.pojo.doo.storage.query.QOrderDo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOrderDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOrderDo<R> extends TQAssocBean<OrderDo,R> {

  public PString<R> id;
  public PString<R> orderGroupId;
  public PString<R> code;
  public PString<R> customerName;
  public PString<R> image;
  public PString<R> poNum;
  public PString<R> item;
  public PString<R> part;
  public PString<R> color;
  public PString<R> bake;
  public PBigDecimal<R> count;
  public PString<R> productNo;
  public PBigDecimal<R> partSumCount;
  public PUtilDate<R> deliveryTime;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOrderDo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOrderDo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOrderDo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOrderDo(String name, R root) {
    super(name, root);
  }
}
