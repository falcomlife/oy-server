package com.cotte.estate.bean.pojo.eto.query;

import com.cotte.estate.bean.pojo.eto.OutStorageEto;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OutStorageEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOutStorageEto extends TQRootBean<OutStorageEto,QOutStorageEto> {

  private static final QOutStorageEto _alias = new QOutStorageEto(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOutStorageEto alias() {
    return _alias;
  }

  public PString<QOutStorageEto> code;
  public PString<QOutStorageEto> orderCode;
  public PString<QOutStorageEto> customerName;
  public PString<QOutStorageEto> poNum;
  public PString<QOutStorageEto> item;
  public PString<QOutStorageEto> part;
  public PString<QOutStorageEto> color;
  public PString<QOutStorageEto> bake;
  public PString<QOutStorageEto> count;
  public PInteger<QOutStorageEto> orderPartSumCount;
  public PString<QOutStorageEto> inCount;
  public PString<QOutStorageEto> outCount;
  public PBigDecimal<QOutStorageEto> bunchCount;
  public PInteger<QOutStorageEto> leftPartSumCount;
  public PString<QOutStorageEto> outType;
  public PString<QOutStorageEto> time;


  /**
   * Construct with a given EbeanServer.
   */
  public QOutStorageEto(EbeanServer server) {
    super(OutStorageEto.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOutStorageEto() {
    super(OutStorageEto.class);
  }

  /**
   * Construct for Alias.
   */
  private QOutStorageEto(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOutStorageEto> code = _alias.code;
    public static PString<QOutStorageEto> orderCode = _alias.orderCode;
    public static PString<QOutStorageEto> customerName = _alias.customerName;
    public static PString<QOutStorageEto> poNum = _alias.poNum;
    public static PString<QOutStorageEto> item = _alias.item;
    public static PString<QOutStorageEto> part = _alias.part;
    public static PString<QOutStorageEto> color = _alias.color;
    public static PString<QOutStorageEto> bake = _alias.bake;
    public static PString<QOutStorageEto> count = _alias.count;
    public static PInteger<QOutStorageEto> orderPartSumCount = _alias.orderPartSumCount;
    public static PString<QOutStorageEto> inCount = _alias.inCount;
    public static PString<QOutStorageEto> outCount = _alias.outCount;
    public static PBigDecimal<QOutStorageEto> bunchCount = _alias.bunchCount;
    public static PInteger<QOutStorageEto> leftPartSumCount = _alias.leftPartSumCount;
    public static PString<QOutStorageEto> outType = _alias.outType;
    public static PString<QOutStorageEto> time = _alias.time;
  }
}
