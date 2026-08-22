package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.OrderAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OrderAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOrderAo extends TQRootBean<OrderAo,QOrderAo> {

  private static final QOrderAo _alias = new QOrderAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOrderAo alias() {
    return _alias;
  }

  public PString<QOrderAo> id;
  public PString<QOrderAo> orderGroupId;
  public PString<QOrderAo> orderGroupCode;
  public PString<QOrderAo> code;
  public PString<QOrderAo> customerName;
  public PString<QOrderAo> customerNameId;
  public PString<QOrderAo> image;
  public PString<QOrderAo> poNum;
  public PString<QOrderAo> item;
  public PString<QOrderAo> part;
  public PString<QOrderAo> productNo;
  public PString<QOrderAo> color;
  public PString<QOrderAo> bake;
  public PString<QOrderAo> bakeId;
  public PString<QOrderAo> colorId;
  public PBigDecimal<QOrderAo> count;
  public PBigDecimal<QOrderAo> partSumCount;
  public PInteger<QOrderAo> partSumCountCal;
  public PInteger<QOrderAo> outStroageGoodsSumCount;
  public PInteger<QOrderAo> outStroagePrimingSumCount;
  public PBigDecimal<QOrderAo> outStroagePrimingSumCountRatio;
  public PBigDecimal<QOrderAo> outStroageSumCount;
  public PInteger<QOrderAo> partSumCountSubOutStroageGoodsSumCount;
  public PInteger<QOrderAo> overPartSumCount;
  public PInteger<QOrderAo> replatCount;
  public PBigDecimal<QOrderAo> replatRatio;
  public PInteger<QOrderAo> incomingCount;
  public PBigDecimal<QOrderAo> incomingRatio;
  public PBoolean<QOrderAo> incomingBigger;
  public PBoolean<QOrderAo> outStorageBigger;
  public PUtilDate<QOrderAo> deliveryTime;
  public PUtilDate<QOrderAo> createTime;
  public PUtilDate<QOrderAo> modifiedTime;
  public PInteger<QOrderAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QOrderAo(EbeanServer server) {
    super(OrderAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOrderAo() {
    super(OrderAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOrderAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOrderAo> id = _alias.id;
    public static PString<QOrderAo> orderGroupId = _alias.orderGroupId;
    public static PString<QOrderAo> orderGroupCode = _alias.orderGroupCode;
    public static PString<QOrderAo> code = _alias.code;
    public static PString<QOrderAo> customerName = _alias.customerName;
    public static PString<QOrderAo> customerNameId = _alias.customerNameId;
    public static PString<QOrderAo> image = _alias.image;
    public static PString<QOrderAo> poNum = _alias.poNum;
    public static PString<QOrderAo> item = _alias.item;
    public static PString<QOrderAo> part = _alias.part;
    public static PString<QOrderAo> productNo = _alias.productNo;
    public static PString<QOrderAo> color = _alias.color;
    public static PString<QOrderAo> bake = _alias.bake;
    public static PString<QOrderAo> bakeId = _alias.bakeId;
    public static PString<QOrderAo> colorId = _alias.colorId;
    public static PBigDecimal<QOrderAo> count = _alias.count;
    public static PBigDecimal<QOrderAo> partSumCount = _alias.partSumCount;
    public static PInteger<QOrderAo> partSumCountCal = _alias.partSumCountCal;
    public static PInteger<QOrderAo> outStroageGoodsSumCount = _alias.outStroageGoodsSumCount;
    public static PInteger<QOrderAo> outStroagePrimingSumCount = _alias.outStroagePrimingSumCount;
    public static PBigDecimal<QOrderAo> outStroagePrimingSumCountRatio = _alias.outStroagePrimingSumCountRatio;
    public static PBigDecimal<QOrderAo> outStroageSumCount = _alias.outStroageSumCount;
    public static PInteger<QOrderAo> partSumCountSubOutStroageGoodsSumCount = _alias.partSumCountSubOutStroageGoodsSumCount;
    public static PInteger<QOrderAo> overPartSumCount = _alias.overPartSumCount;
    public static PInteger<QOrderAo> replatCount = _alias.replatCount;
    public static PBigDecimal<QOrderAo> replatRatio = _alias.replatRatio;
    public static PInteger<QOrderAo> incomingCount = _alias.incomingCount;
    public static PBigDecimal<QOrderAo> incomingRatio = _alias.incomingRatio;
    public static PBoolean<QOrderAo> incomingBigger = _alias.incomingBigger;
    public static PBoolean<QOrderAo> outStorageBigger = _alias.outStorageBigger;
    public static PUtilDate<QOrderAo> deliveryTime = _alias.deliveryTime;
    public static PUtilDate<QOrderAo> createTime = _alias.createTime;
    public static PUtilDate<QOrderAo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QOrderAo> isDelete = _alias.isDelete;
  }
}
