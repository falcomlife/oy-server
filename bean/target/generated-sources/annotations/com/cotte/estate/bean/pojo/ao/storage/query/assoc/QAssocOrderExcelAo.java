package com.cotte.estate.bean.pojo.ao.storage.query.assoc;

import com.cotte.estate.bean.pojo.ao.storage.OrderExcelAo;
import com.cotte.estate.bean.pojo.ao.storage.query.QOrderExcelAo;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOrderExcelAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOrderExcelAo<R> extends TQAssocBean<OrderExcelAo,R> {

  public PString<R> customerNameItem;
  public PString<R> code;
  public PString<R> inCode;
  public PString<R> incomingType;
  public PString<R> outCode;
  public PString<R> po;
  public PString<R> item;
  public PString<R> starttime;
  public PString<R> endtime;
  public PString<R> inStarttime;
  public PString<R> inEndtime;
  public PString<R> outStarttime;
  public PString<R> outEndtime;
  public PString<R> deliveryStarttime;
  public PString<R> deliveryEndtime;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOrderExcelAo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOrderExcelAo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOrderExcelAo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOrderExcelAo(String name, R root) {
    super(name, root);
  }
}
