package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.InStorageDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for InStorageDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QInStorageDo extends TQRootBean<InStorageDo,QInStorageDo> {

  private static final QInStorageDo _alias = new QInStorageDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QInStorageDo alias() {
    return _alias;
  }

  public PString<QInStorageDo> id;
  public PString<QInStorageDo> orderId;
  public PString<QInStorageDo> outStorageId;
  public PString<QInStorageDo> code;
  public PString<QInStorageDo> image;
  public PString<QInStorageDo> name;
  public PBigDecimal<QInStorageDo> bunchCount;
  public PString<QInStorageDo> unit;
  public PString<QInStorageDo> inCount;
  public PString<QInStorageDo> color;
  public PString<QInStorageDo> bake;
  public PString<QInStorageDo> badReason;
  public PString<QInStorageDo> incomingType;
  public PString<QInStorageDo> incomingReason;
  public PUtilDate<QInStorageDo> createTime;
  public PUtilDate<QInStorageDo> modifiedTime;
  public PInteger<QInStorageDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QInStorageDo(EbeanServer server) {
    super(InStorageDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QInStorageDo() {
    super(InStorageDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QInStorageDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QInStorageDo> id = _alias.id;
    public static PString<QInStorageDo> orderId = _alias.orderId;
    public static PString<QInStorageDo> outStorageId = _alias.outStorageId;
    public static PString<QInStorageDo> code = _alias.code;
    public static PString<QInStorageDo> image = _alias.image;
    public static PString<QInStorageDo> name = _alias.name;
    public static PBigDecimal<QInStorageDo> bunchCount = _alias.bunchCount;
    public static PString<QInStorageDo> unit = _alias.unit;
    public static PString<QInStorageDo> inCount = _alias.inCount;
    public static PString<QInStorageDo> color = _alias.color;
    public static PString<QInStorageDo> bake = _alias.bake;
    public static PString<QInStorageDo> badReason = _alias.badReason;
    public static PString<QInStorageDo> incomingType = _alias.incomingType;
    public static PString<QInStorageDo> incomingReason = _alias.incomingReason;
    public static PUtilDate<QInStorageDo> createTime = _alias.createTime;
    public static PUtilDate<QInStorageDo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QInStorageDo> isDelete = _alias.isDelete;
  }
}
