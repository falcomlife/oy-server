package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.InStorageAo;
import com.cotte.estate.bean.pojo.ao.storage.query.assoc.QAssocOutStorageAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for InStorageAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QInStorageAo extends TQRootBean<InStorageAo,QInStorageAo> {

  private static final QInStorageAo _alias = new QInStorageAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QInStorageAo alias() {
    return _alias;
  }

  public PString<QInStorageAo> id;
  public PString<QInStorageAo> orderId;
  public PString<QInStorageAo> orderCode;
  public PString<QInStorageAo> outStorageId;
  public PString<QInStorageAo> outStorageCode;
  public PString<QInStorageAo> code;
  public PString<QInStorageAo> customerName;
  public PString<QInStorageAo> customerNameId;
  public PString<QInStorageAo> image;
  public PString<QInStorageAo> name;
  public PString<QInStorageAo> poNum;
  public PString<QInStorageAo> item;
  public PString<QInStorageAo> part;
  public PString<QInStorageAo> color;
  public PString<QInStorageAo> colorId;
  public PString<QInStorageAo> orderColor;
  public PString<QInStorageAo> orderColorId;
  public PBigDecimal<QInStorageAo> count;
  public PBigDecimal<QInStorageAo> partSumCount;
  public PBigDecimal<QInStorageAo> bunchCount;
  public PBigDecimal<QInStorageAo> remainCount;
  public PInteger<QInStorageAo> stayDays;
  public PString<QInStorageAo> bake;
  public PString<QInStorageAo> bakeId;
  public PString<QInStorageAo> inCount;
  public PString<QInStorageAo> unit;
  public PString<QInStorageAo> unitId;
  public PBigDecimal<QInStorageAo> price;
  public PBigDecimal<QInStorageAo> sum;
  public PString<QInStorageAo> incomingType;
  public PString<QInStorageAo> badReason;
  public PString<QInStorageAo> incomingTypeId;
  public PString<QInStorageAo> incomingReason;
  public PString<QInStorageAo> expandType;
  public QAssocOutStorageAo<QInStorageAo> outStorageList;
  public PUtilDate<QInStorageAo> createTime;
  public PUtilDate<QInStorageAo> modifiedTime;
  public PInteger<QInStorageAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QInStorageAo(EbeanServer server) {
    super(InStorageAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QInStorageAo() {
    super(InStorageAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QInStorageAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QInStorageAo> id = _alias.id;
    public static PString<QInStorageAo> orderId = _alias.orderId;
    public static PString<QInStorageAo> orderCode = _alias.orderCode;
    public static PString<QInStorageAo> outStorageId = _alias.outStorageId;
    public static PString<QInStorageAo> outStorageCode = _alias.outStorageCode;
    public static PString<QInStorageAo> code = _alias.code;
    public static PString<QInStorageAo> customerName = _alias.customerName;
    public static PString<QInStorageAo> customerNameId = _alias.customerNameId;
    public static PString<QInStorageAo> image = _alias.image;
    public static PString<QInStorageAo> name = _alias.name;
    public static PString<QInStorageAo> poNum = _alias.poNum;
    public static PString<QInStorageAo> item = _alias.item;
    public static PString<QInStorageAo> part = _alias.part;
    public static PString<QInStorageAo> color = _alias.color;
    public static PString<QInStorageAo> colorId = _alias.colorId;
    public static PString<QInStorageAo> orderColor = _alias.orderColor;
    public static PString<QInStorageAo> orderColorId = _alias.orderColorId;
    public static PBigDecimal<QInStorageAo> count = _alias.count;
    public static PBigDecimal<QInStorageAo> partSumCount = _alias.partSumCount;
    public static PBigDecimal<QInStorageAo> bunchCount = _alias.bunchCount;
    public static PBigDecimal<QInStorageAo> remainCount = _alias.remainCount;
    public static PInteger<QInStorageAo> stayDays = _alias.stayDays;
    public static PString<QInStorageAo> bake = _alias.bake;
    public static PString<QInStorageAo> bakeId = _alias.bakeId;
    public static PString<QInStorageAo> inCount = _alias.inCount;
    public static PString<QInStorageAo> unit = _alias.unit;
    public static PString<QInStorageAo> unitId = _alias.unitId;
    public static PBigDecimal<QInStorageAo> price = _alias.price;
    public static PBigDecimal<QInStorageAo> sum = _alias.sum;
    public static PString<QInStorageAo> incomingType = _alias.incomingType;
    public static PString<QInStorageAo> badReason = _alias.badReason;
    public static PString<QInStorageAo> incomingTypeId = _alias.incomingTypeId;
    public static PString<QInStorageAo> incomingReason = _alias.incomingReason;
    public static PString<QInStorageAo> expandType = _alias.expandType;
    public static QAssocOutStorageAo<QInStorageAo> outStorageList = _alias.outStorageList;
    public static PUtilDate<QInStorageAo> createTime = _alias.createTime;
    public static PUtilDate<QInStorageAo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QInStorageAo> isDelete = _alias.isDelete;
  }
}
