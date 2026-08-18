package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.OutStorageAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OutStorageAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOutStorageAo extends TQRootBean<OutStorageAo,QOutStorageAo> {

  private static final QOutStorageAo _alias = new QOutStorageAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOutStorageAo alias() {
    return _alias;
  }

  public PString<QOutStorageAo> id;
  public PString<QOutStorageAo> orderId;
  public PInteger<QOutStorageAo> orderPartSumCount;
  public PInteger<QOutStorageAo> leftPartSumCount;
  public PString<QOutStorageAo> inStorageId;
  public PString<QOutStorageAo> inStorageCode;
  public PString<QOutStorageAo> customerName;
  public PString<QOutStorageAo> customerNameId;
  public PString<QOutStorageAo> image;
  public PString<QOutStorageAo> otimage;
  public PString<QOutStorageAo> code;
  public PString<QOutStorageAo> orderCode;
  public PString<QOutStorageAo> name;
  public PString<QOutStorageAo> poNum;
  public PString<QOutStorageAo> item;
  public PString<QOutStorageAo> part;
  public PString<QOutStorageAo> color;
  public PString<QOutStorageAo> colorId;
  public PString<QOutStorageAo> count;
  public PBigDecimal<QOutStorageAo> partSumCount;
  public PBigDecimal<QOutStorageAo> bunchCount;
  public PString<QOutStorageAo> bake;
  public PString<QOutStorageAo> bakeId;
  public PString<QOutStorageAo> outCount;
  public PString<QOutStorageAo> outTypeId;
  public PString<QOutStorageAo> outType;
  public PString<QOutStorageAo> inCount;
  public PString<QOutStorageAo> time;
  public PUtilDate<QOutStorageAo> createTime;
  public PUtilDate<QOutStorageAo> modifiedTime;
  public PInteger<QOutStorageAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QOutStorageAo(EbeanServer server) {
    super(OutStorageAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOutStorageAo() {
    super(OutStorageAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOutStorageAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOutStorageAo> id = _alias.id;
    public static PString<QOutStorageAo> orderId = _alias.orderId;
    public static PInteger<QOutStorageAo> orderPartSumCount = _alias.orderPartSumCount;
    public static PInteger<QOutStorageAo> leftPartSumCount = _alias.leftPartSumCount;
    public static PString<QOutStorageAo> inStorageId = _alias.inStorageId;
    public static PString<QOutStorageAo> inStorageCode = _alias.inStorageCode;
    public static PString<QOutStorageAo> customerName = _alias.customerName;
    public static PString<QOutStorageAo> customerNameId = _alias.customerNameId;
    public static PString<QOutStorageAo> image = _alias.image;
    public static PString<QOutStorageAo> otimage = _alias.otimage;
    public static PString<QOutStorageAo> code = _alias.code;
    public static PString<QOutStorageAo> orderCode = _alias.orderCode;
    public static PString<QOutStorageAo> name = _alias.name;
    public static PString<QOutStorageAo> poNum = _alias.poNum;
    public static PString<QOutStorageAo> item = _alias.item;
    public static PString<QOutStorageAo> part = _alias.part;
    public static PString<QOutStorageAo> color = _alias.color;
    public static PString<QOutStorageAo> colorId = _alias.colorId;
    public static PString<QOutStorageAo> count = _alias.count;
    public static PBigDecimal<QOutStorageAo> partSumCount = _alias.partSumCount;
    public static PBigDecimal<QOutStorageAo> bunchCount = _alias.bunchCount;
    public static PString<QOutStorageAo> bake = _alias.bake;
    public static PString<QOutStorageAo> bakeId = _alias.bakeId;
    public static PString<QOutStorageAo> outCount = _alias.outCount;
    public static PString<QOutStorageAo> outTypeId = _alias.outTypeId;
    public static PString<QOutStorageAo> outType = _alias.outType;
    public static PString<QOutStorageAo> inCount = _alias.inCount;
    public static PString<QOutStorageAo> time = _alias.time;
    public static PUtilDate<QOutStorageAo> createTime = _alias.createTime;
    public static PUtilDate<QOutStorageAo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QOutStorageAo> isDelete = _alias.isDelete;
  }
}
