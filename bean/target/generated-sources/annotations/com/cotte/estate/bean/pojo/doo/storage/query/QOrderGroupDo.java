package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.OrderGroupDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OrderGroupDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOrderGroupDo extends TQRootBean<OrderGroupDo,QOrderGroupDo> {

  private static final QOrderGroupDo _alias = new QOrderGroupDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOrderGroupDo alias() {
    return _alias;
  }

  public PString<QOrderGroupDo> id;
  public PString<QOrderGroupDo> code;
  public PString<QOrderGroupDo> customerName;
  public PString<QOrderGroupDo> image;
  public PString<QOrderGroupDo> poNum;
  public PBigDecimal<QOrderGroupDo> count;
  public PUtilDate<QOrderGroupDo> createTime;
  public PUtilDate<QOrderGroupDo> modifiedTime;
  public PInteger<QOrderGroupDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QOrderGroupDo(EbeanServer server) {
    super(OrderGroupDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOrderGroupDo() {
    super(OrderGroupDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOrderGroupDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOrderGroupDo> id = _alias.id;
    public static PString<QOrderGroupDo> code = _alias.code;
    public static PString<QOrderGroupDo> customerName = _alias.customerName;
    public static PString<QOrderGroupDo> image = _alias.image;
    public static PString<QOrderGroupDo> poNum = _alias.poNum;
    public static PBigDecimal<QOrderGroupDo> count = _alias.count;
    public static PUtilDate<QOrderGroupDo> createTime = _alias.createTime;
    public static PUtilDate<QOrderGroupDo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QOrderGroupDo> isDelete = _alias.isDelete;
  }
}
