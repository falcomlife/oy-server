package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.DictDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for DictDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QDictDo extends TQRootBean<DictDo,QDictDo> {

  private static final QDictDo _alias = new QDictDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QDictDo alias() {
    return _alias;
  }

  public PString<QDictDo> id;
  public PString<QDictDo> type;
  public PString<QDictDo> typeName;
  public PString<QDictDo> item;
  public PString<QDictDo> itemName;


  /**
   * Construct with a given EbeanServer.
   */
  public QDictDo(EbeanServer server) {
    super(DictDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QDictDo() {
    super(DictDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QDictDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QDictDo> id = _alias.id;
    public static PString<QDictDo> type = _alias.type;
    public static PString<QDictDo> typeName = _alias.typeName;
    public static PString<QDictDo> item = _alias.item;
    public static PString<QDictDo> itemName = _alias.itemName;
  }
}
