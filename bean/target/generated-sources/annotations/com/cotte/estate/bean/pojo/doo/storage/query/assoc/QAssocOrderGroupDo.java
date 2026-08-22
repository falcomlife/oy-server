package com.cotte.estate.bean.pojo.doo.storage.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.OrderGroupDo;
import com.cotte.estate.bean.pojo.doo.storage.query.QOrderGroupDo;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocOrderGroupDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocOrderGroupDo<R> extends TQAssocBean<OrderGroupDo,R> {

  public PString<R> id;
  public PString<R> code;
  public PString<R> customerName;
  public PString<R> image;
  public PString<R> poNum;
  public PString<R> productNo;
  public PBigDecimal<R> count;
  public PBigDecimal<R> price;
  public PBigDecimal<R> sum;
  public PString<R> serialNo;
  public PUtilDate<R> createTime;
  public PUtilDate<R> modifiedTime;
  public PInteger<R> isDelete;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QOrderGroupDo>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QOrderGroupDo>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QOrderGroupDo>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocOrderGroupDo(String name, R root) {
    super(name, root);
  }
}
