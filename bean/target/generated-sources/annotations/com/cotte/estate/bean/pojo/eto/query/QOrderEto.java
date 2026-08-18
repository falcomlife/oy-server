package com.cotte.estate.bean.pojo.eto.query;

import com.cotte.estate.bean.pojo.eto.OrderEto;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OrderEto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOrderEto extends TQRootBean<OrderEto,QOrderEto> {

  private static final QOrderEto _alias = new QOrderEto(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOrderEto alias() {
    return _alias;
  }

  public PString<QOrderEto> code;
  public PString<QOrderEto> customerName;
  public PString<QOrderEto> poNum;
  public PString<QOrderEto> item;
  public PString<QOrderEto> part;
  public PString<QOrderEto> color;
  public PString<QOrderEto> bake;
  public PBigDecimal<QOrderEto> count;
  public PBigDecimal<QOrderEto> price;
  public PBigDecimal<QOrderEto> sum;
  public PBigDecimal<QOrderEto> partSumCount;
  public PInteger<QOrderEto> partSumCountCal;
  public PInteger<QOrderEto> outStroageGoodsSumCount;
  public PInteger<QOrderEto> partSumCountSubOutStroageGoodsSumCount;
  public PInteger<QOrderEto> overPartSumCount;
  public PInteger<QOrderEto> replatCount;
  public PBigDecimal<QOrderEto> replatRatio;
  public PInteger<QOrderEto> incomingCount;
  public PBigDecimal<QOrderEto> incomingRatio;
  public PInteger<QOrderEto> outStroagePrimingSumCount;
  public PBigDecimal<QOrderEto> outStroagePrimingSumCountRatio;
  public PString<QOrderEto> delTime;
  public PUtilDate<QOrderEto> deliveryTime;
  public PString<QOrderEto> time;


  /**
   * Construct with a given EbeanServer.
   */
  public QOrderEto(EbeanServer server) {
    super(OrderEto.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOrderEto() {
    super(OrderEto.class);
  }

  /**
   * Construct for Alias.
   */
  private QOrderEto(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOrderEto> code = _alias.code;
    public static PString<QOrderEto> customerName = _alias.customerName;
    public static PString<QOrderEto> poNum = _alias.poNum;
    public static PString<QOrderEto> item = _alias.item;
    public static PString<QOrderEto> part = _alias.part;
    public static PString<QOrderEto> color = _alias.color;
    public static PString<QOrderEto> bake = _alias.bake;
    public static PBigDecimal<QOrderEto> count = _alias.count;
    public static PBigDecimal<QOrderEto> price = _alias.price;
    public static PBigDecimal<QOrderEto> sum = _alias.sum;
    public static PBigDecimal<QOrderEto> partSumCount = _alias.partSumCount;
    public static PInteger<QOrderEto> partSumCountCal = _alias.partSumCountCal;
    public static PInteger<QOrderEto> outStroageGoodsSumCount = _alias.outStroageGoodsSumCount;
    public static PInteger<QOrderEto> partSumCountSubOutStroageGoodsSumCount = _alias.partSumCountSubOutStroageGoodsSumCount;
    public static PInteger<QOrderEto> overPartSumCount = _alias.overPartSumCount;
    public static PInteger<QOrderEto> replatCount = _alias.replatCount;
    public static PBigDecimal<QOrderEto> replatRatio = _alias.replatRatio;
    public static PInteger<QOrderEto> incomingCount = _alias.incomingCount;
    public static PBigDecimal<QOrderEto> incomingRatio = _alias.incomingRatio;
    public static PInteger<QOrderEto> outStroagePrimingSumCount = _alias.outStroagePrimingSumCount;
    public static PBigDecimal<QOrderEto> outStroagePrimingSumCountRatio = _alias.outStroagePrimingSumCountRatio;
    public static PString<QOrderEto> delTime = _alias.delTime;
    public static PUtilDate<QOrderEto> deliveryTime = _alias.deliveryTime;
    public static PString<QOrderEto> time = _alias.time;
  }
}
