package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.OutStorageDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBigDecimal;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for OutStorageDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QOutStorageDo extends TQRootBean<OutStorageDo,QOutStorageDo> {

  private static final QOutStorageDo _alias = new QOutStorageDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QOutStorageDo alias() {
    return _alias;
  }

  public PString<QOutStorageDo> id;
  public PString<QOutStorageDo> inStorageId;
  public PString<QOutStorageDo> image;
  public PString<QOutStorageDo> code;
  public PBigDecimal<QOutStorageDo> bunchCount;
  public PString<QOutStorageDo> outCount;
  public PString<QOutStorageDo> outType;
  public PUtilDate<QOutStorageDo> createTime;
  public PUtilDate<QOutStorageDo> modifiedTime;
  public PInteger<QOutStorageDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QOutStorageDo(EbeanServer server) {
    super(OutStorageDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QOutStorageDo() {
    super(OutStorageDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QOutStorageDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QOutStorageDo> id = _alias.id;
    public static PString<QOutStorageDo> inStorageId = _alias.inStorageId;
    public static PString<QOutStorageDo> image = _alias.image;
    public static PString<QOutStorageDo> code = _alias.code;
    public static PBigDecimal<QOutStorageDo> bunchCount = _alias.bunchCount;
    public static PString<QOutStorageDo> outCount = _alias.outCount;
    public static PString<QOutStorageDo> outType = _alias.outType;
    public static PUtilDate<QOutStorageDo> createTime = _alias.createTime;
    public static PUtilDate<QOutStorageDo> modifiedTime = _alias.modifiedTime;
    public static PInteger<QOutStorageDo> isDelete = _alias.isDelete;
  }
}
