package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.OrderDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OrderDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOrderDo extends TQRootBean<OrderDo,QOrderDo> {

  private static final QOrderDo _alias = new QOrderDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOrderDo alias() {
    return _alias;
  }

  public PString<QOrderDo> id;
  public PString<QOrderDo> orderGroupId;
  public PString<QOrderDo> code;
  public PString<QOrderDo> customerName;
  public PString<QOrderDo> image;
  public PString<QOrderDo> poNum;
  public PString<QOrderDo> item;
  public PString<QOrderDo> part;
  public PString<QOrderDo> color;
  public PString<QOrderDo> bake;
  public PBigDecimal<QOrderDo> count;
  public PBigDecimal<QOrderDo> partSumCount;
  public PBigDecimal<QOrderDo> price;
  public PBigDecimal<QOrderDo> sum;
  public PUtilDate<QOrderDo> deliveryTime;
  public PUtilDate<QOrderDo> createTime;
  public PUtilDate<QOrderDo> modifiedTime;
  public PInteger<QOrderDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QOrderDo(EbeanServer server) {
    super(OrderDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOrderDo() {
    super(OrderDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOrderDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOrderDo> id = _alias.id;
    public static PString<QOrderDo> orderGroupId = _alias.orderGroupId;
    public static PString<QOrderDo> code = _alias.code;
    public static PString<QOrderDo> customerName = _alias.customerName;
    public static PString<QOrderDo> image = _alias.image;
    public static PString<QOrderDo> poNum = _alias.poNum;
    public static PString<QOrderDo> item = _alias.item;
    public static PString<QOrderDo> part = _alias.part;
    public static PString<QOrderDo> color = _alias.color;
    public static PString<QOrderDo> bake = _alias.bake;
    public static PBigDecimal<QOrderDo> count = _alias.count;
    public static PBigDecimal<QOrderDo> partSumCount = _alias.partSumCount;
    public static PBigDecimal<QOrderDo> price = _alias.price;
    public static PBigDecimal<QOrderDo> sum = _alias.sum;
    public static PUtilDate<QOrderDo> deliveryTime = _alias.deliveryTime;
    public static PUtilDate<QOrderDo> createTime = _alias.createTime;
    public static PUtilDate<QOrderDo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QOrderDo> isDelete = _alias.isDelete;
  }
}
