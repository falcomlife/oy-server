package com.cotte.estate.bean.pojo.bo.storage.query;

import com.cotte.estate.bean.pojo.bo.storage.InStorageBo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for InStorageBo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QInStorageBo extends TQRootBean<InStorageBo,QInStorageBo> {

  private static final QInStorageBo _alias = new QInStorageBo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QInStorageBo alias() {
    return _alias;
  }

  public PString<QInStorageBo> id;
  public PString<QInStorageBo> customerName;
  public PString<QInStorageBo> orderId;
  public PString<QInStorageBo> outStorageId;
  public PString<QInStorageBo> code;
  public PString<QInStorageBo> image;
  public PString<QInStorageBo> name;
  public PBigDecimal<QInStorageBo> bunchCount;
  public PString<QInStorageBo> unit;
  public PString<QInStorageBo> bake;
  public PString<QInStorageBo> inCount;
  public PString<QInStorageBo> color;
  public PString<QInStorageBo> orderColor;
  public PString<QInStorageBo> badReason;
  public PString<QInStorageBo> incomingType;
  public PString<QInStorageBo> incomingReason;
  public PUtilDate<QInStorageBo> createTime;
  public PUtilDate<QInStorageBo> modifiedTime;
  public PInteger<QInStorageBo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QInStorageBo(EbeanServer server) {
    super(InStorageBo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QInStorageBo() {
    super(InStorageBo.class);
  }

  /**
   * Construct for Alias.
   */
  private QInStorageBo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QInStorageBo> id = _alias.id;
    public static PString<QInStorageBo> customerName = _alias.customerName;
    public static PString<QInStorageBo> orderId = _alias.orderId;
    public static PString<QInStorageBo> outStorageId = _alias.outStorageId;
    public static PString<QInStorageBo> code = _alias.code;
    public static PString<QInStorageBo> image = _alias.image;
    public static PString<QInStorageBo> name = _alias.name;
    public static PBigDecimal<QInStorageBo> bunchCount = _alias.bunchCount;
    public static PString<QInStorageBo> unit = _alias.unit;
    public static PString<QInStorageBo> bake = _alias.bake;
    public static PString<QInStorageBo> inCount = _alias.inCount;
    public static PString<QInStorageBo> color = _alias.color;
    public static PString<QInStorageBo> orderColor = _alias.orderColor;
    public static PString<QInStorageBo> badReason = _alias.badReason;
    public static PString<QInStorageBo> incomingType = _alias.incomingType;
    public static PString<QInStorageBo> incomingReason = _alias.incomingReason;
    public static PUtilDate<QInStorageBo> createTime = _alias.createTime;
    public static PUtilDate<QInStorageBo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QInStorageBo> isDelete = _alias.isDelete;
  }
}
