package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.OrderExcelAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OrderExcelAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOrderExcelAo extends TQRootBean<OrderExcelAo,QOrderExcelAo> {

  private static final QOrderExcelAo _alias = new QOrderExcelAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOrderExcelAo alias() {
    return _alias;
  }

  public PString<QOrderExcelAo> customerNameItem;
  public PString<QOrderExcelAo> code;
  public PString<QOrderExcelAo> inCode;
  public PString<QOrderExcelAo> incomingType;
  public PString<QOrderExcelAo> outCode;
  public PString<QOrderExcelAo> po;
  public PString<QOrderExcelAo> item;
  public PString<QOrderExcelAo> starttime;
  public PString<QOrderExcelAo> endtime;
  public PString<QOrderExcelAo> inStarttime;
  public PString<QOrderExcelAo> inEndtime;
  public PString<QOrderExcelAo> outStarttime;
  public PString<QOrderExcelAo> outEndtime;
  public PString<QOrderExcelAo> deliveryStarttime;
  public PString<QOrderExcelAo> deliveryEndtime;


  /**
   * Construct with a given EbeanServer.
   */
  public QOrderExcelAo(EbeanServer server) {
    super(OrderExcelAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOrderExcelAo() {
    super(OrderExcelAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOrderExcelAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOrderExcelAo> customerNameItem = _alias.customerNameItem;
    public static PString<QOrderExcelAo> code = _alias.code;
    public static PString<QOrderExcelAo> inCode = _alias.inCode;
    public static PString<QOrderExcelAo> incomingType = _alias.incomingType;
    public static PString<QOrderExcelAo> outCode = _alias.outCode;
    public static PString<QOrderExcelAo> po = _alias.po;
    public static PString<QOrderExcelAo> item = _alias.item;
    public static PString<QOrderExcelAo> starttime = _alias.starttime;
    public static PString<QOrderExcelAo> endtime = _alias.endtime;
    public static PString<QOrderExcelAo> inStarttime = _alias.inStarttime;
    public static PString<QOrderExcelAo> inEndtime = _alias.inEndtime;
    public static PString<QOrderExcelAo> outStarttime = _alias.outStarttime;
    public static PString<QOrderExcelAo> outEndtime = _alias.outEndtime;
    public static PString<QOrderExcelAo> deliveryStarttime = _alias.deliveryStarttime;
    public static PString<QOrderExcelAo> deliveryEndtime = _alias.deliveryEndtime;
  }
}
