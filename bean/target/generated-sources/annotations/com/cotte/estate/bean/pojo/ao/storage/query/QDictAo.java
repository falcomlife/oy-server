package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.DictAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for DictAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QDictAo extends TQRootBean<DictAo,QDictAo> {

  private static final QDictAo _alias = new QDictAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QDictAo alias() {
    return _alias;
  }

  public PString<QDictAo> id;
  public PString<QDictAo> type;
  public PString<QDictAo> typeName;
  public PString<QDictAo> item;
  public PString<QDictAo> itemName;


  /**
   * Construct with a given EbeanServer.
   */
  public QDictAo(EbeanServer server) {
    super(DictAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QDictAo() {
    super(DictAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QDictAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QDictAo> id = _alias.id;
    public static PString<QDictAo> type = _alias.type;
    public static PString<QDictAo> typeName = _alias.typeName;
    public static PString<QDictAo> item = _alias.item;
    public static PString<QDictAo> itemName = _alias.itemName;
  }
}
