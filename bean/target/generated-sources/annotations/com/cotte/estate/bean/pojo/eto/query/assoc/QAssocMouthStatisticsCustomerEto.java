package com.cotte.estate.bean.pojo.eto.query.assoc;

import com.cotte.estate.bean.pojo.eto.MouthStatisticsCustomerEto;
import com.cotte.estate.bean.pojo.eto.query.QMouthStatisticsCustomerEto;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocMouthStatisticsCustomerEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocMouthStatisticsCustomerEto<R> extends TQAssocBean<MouthStatisticsCustomerEto,R> {

  public PString<R> name;
  public PBigDecimal<R> count;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QMouthStatisticsCustomerEto>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QMouthStatisticsCustomerEto>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QMouthStatisticsCustomerEto>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocMouthStatisticsCustomerEto(String name, R root) {
    super(name, root);
  }
}
