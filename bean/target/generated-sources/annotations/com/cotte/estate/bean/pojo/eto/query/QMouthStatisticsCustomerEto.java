package com.cotte.estate.bean.pojo.eto.query;

import com.cotte.estate.bean.pojo.eto.MouthStatisticsCustomerEto;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for MouthStatisticsCustomerEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QMouthStatisticsCustomerEto extends TQRootBean<MouthStatisticsCustomerEto,QMouthStatisticsCustomerEto> {

  private static final QMouthStatisticsCustomerEto _alias = new QMouthStatisticsCustomerEto(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QMouthStatisticsCustomerEto alias() {
    return _alias;
  }

  public PString<QMouthStatisticsCustomerEto> name;
  public PBigDecimal<QMouthStatisticsCustomerEto> count;


  /**
   * Construct with a given EbeanServer.
   */
  public QMouthStatisticsCustomerEto(EbeanServer server) {
    super(MouthStatisticsCustomerEto.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QMouthStatisticsCustomerEto() {
    super(MouthStatisticsCustomerEto.class);
  }

  /**
   * Construct for Alias.
   */
  private QMouthStatisticsCustomerEto(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QMouthStatisticsCustomerEto> name = _alias.name;
    public static PBigDecimal<QMouthStatisticsCustomerEto> count = _alias.count;
  }
}
