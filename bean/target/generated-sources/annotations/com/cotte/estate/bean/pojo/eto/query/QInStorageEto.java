package com.cotte.estate.bean.pojo.eto.query;

import com.cotte.estate.bean.pojo.eto.InStorageEto;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for InStorageEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QInStorageEto extends TQRootBean<InStorageEto,QInStorageEto> {

  private static final QInStorageEto _alias = new QInStorageEto(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QInStorageEto alias() {
    return _alias;
  }

  public PString<QInStorageEto> customerName;
  public PString<QInStorageEto> code;
  public PString<QInStorageEto> item;
  public PString<QInStorageEto> poNum;
  public PString<QInStorageEto> part;
  public PString<QInStorageEto> orderColor;
  public PString<QInStorageEto> bake;
  public PBigDecimal<QInStorageEto> count;
  public PInteger<QInStorageEto> orderPartSumCount;
  public PBigDecimal<QInStorageEto> bunchCount;
  public PString<QInStorageEto> unit;
  public PString<QInStorageEto> inCount;
  public PString<QInStorageEto> incomingType;
  public PString<QInStorageEto> badReason;
  public PString<QInStorageEto> time;


  /**
   * Construct with a given EbeanServer.
   */
  public QInStorageEto(EbeanServer server) {
    super(InStorageEto.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QInStorageEto() {
    super(InStorageEto.class);
  }

  /**
   * Construct for Alias.
   */
  private QInStorageEto(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QInStorageEto> customerName = _alias.customerName;
    public static PString<QInStorageEto> code = _alias.code;
    public static PString<QInStorageEto> item = _alias.item;
    public static PString<QInStorageEto> poNum = _alias.poNum;
    public static PString<QInStorageEto> part = _alias.part;
    public static PString<QInStorageEto> orderColor = _alias.orderColor;
    public static PString<QInStorageEto> bake = _alias.bake;
    public static PBigDecimal<QInStorageEto> count = _alias.count;
    public static PInteger<QInStorageEto> orderPartSumCount = _alias.orderPartSumCount;
    public static PBigDecimal<QInStorageEto> bunchCount = _alias.bunchCount;
    public static PString<QInStorageEto> unit = _alias.unit;
    public static PString<QInStorageEto> inCount = _alias.inCount;
    public static PString<QInStorageEto> incomingType = _alias.incomingType;
    public static PString<QInStorageEto> badReason = _alias.badReason;
    public static PString<QInStorageEto> time = _alias.time;
  }
}
