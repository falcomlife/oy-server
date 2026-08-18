package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.OutStorageExcelAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OutStorageExcelAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOutStorageExcelAo extends TQRootBean<OutStorageExcelAo,QOutStorageExcelAo> {

  private static final QOutStorageExcelAo _alias = new QOutStorageExcelAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOutStorageExcelAo alias() {
    return _alias;
  }

  public PString<QOutStorageExcelAo> customerNameItem;
  public PString<QOutStorageExcelAo> code;
  public PString<QOutStorageExcelAo> item;
  public PString<QOutStorageExcelAo> poNum;
  public PString<QOutStorageExcelAo> starttime;
  public PString<QOutStorageExcelAo> endtime;


  /**
   * Construct with a given EbeanServer.
   */
  public QOutStorageExcelAo(EbeanServer server) {
    super(OutStorageExcelAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOutStorageExcelAo() {
    super(OutStorageExcelAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOutStorageExcelAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOutStorageExcelAo> customerNameItem = _alias.customerNameItem;
    public static PString<QOutStorageExcelAo> code = _alias.code;
    public static PString<QOutStorageExcelAo> item = _alias.item;
    public static PString<QOutStorageExcelAo> poNum = _alias.poNum;
    public static PString<QOutStorageExcelAo> starttime = _alias.starttime;
    public static PString<QOutStorageExcelAo> endtime = _alias.endtime;
  }
}
