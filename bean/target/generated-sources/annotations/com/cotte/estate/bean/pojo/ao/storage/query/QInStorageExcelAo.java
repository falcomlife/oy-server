package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.InStorageExcelAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for InStorageExcelAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QInStorageExcelAo extends TQRootBean<InStorageExcelAo,QInStorageExcelAo> {

  private static final QInStorageExcelAo _alias = new QInStorageExcelAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QInStorageExcelAo alias() {
    return _alias;
  }

  public PString<QInStorageExcelAo> customerNameItem;
  public PString<QInStorageExcelAo> incomingType;
  public PString<QInStorageExcelAo> code;
  public PString<QInStorageExcelAo> item;
  public PString<QInStorageExcelAo> poNum;
  public PString<QInStorageExcelAo> starttime;
  public PString<QInStorageExcelAo> endtime;


  /**
   * Construct with a given EbeanServer.
   */
  public QInStorageExcelAo(EbeanServer server) {
    super(InStorageExcelAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QInStorageExcelAo() {
    super(InStorageExcelAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QInStorageExcelAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QInStorageExcelAo> customerNameItem = _alias.customerNameItem;
    public static PString<QInStorageExcelAo> incomingType = _alias.incomingType;
    public static PString<QInStorageExcelAo> code = _alias.code;
    public static PString<QInStorageExcelAo> item = _alias.item;
    public static PString<QInStorageExcelAo> poNum = _alias.poNum;
    public static PString<QInStorageExcelAo> starttime = _alias.starttime;
    public static PString<QInStorageExcelAo> endtime = _alias.endtime;
  }
}
