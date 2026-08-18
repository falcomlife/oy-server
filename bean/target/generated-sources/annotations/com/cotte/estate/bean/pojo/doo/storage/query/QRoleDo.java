package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.RoleDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for RoleDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QRoleDo extends TQRootBean<RoleDo,QRoleDo> {

  private static final QRoleDo _alias = new QRoleDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QRoleDo alias() {
    return _alias;
  }

  public PString<QRoleDo> id;
  public PString<QRoleDo> name;
  public PString<QRoleDo> companyId;
  public PUtilDate<QRoleDo> createTime;
  public PUtilDate<QRoleDo> modifiedTime;
  public PBoolean<QRoleDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QRoleDo(EbeanServer server) {
    super(RoleDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QRoleDo() {
    super(RoleDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QRoleDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QRoleDo> id = _alias.id;
    public static PString<QRoleDo> name = _alias.name;
    public static PString<QRoleDo> companyId = _alias.companyId;
    public static PUtilDate<QRoleDo> createTime = _alias.createTime;
    public static PUtilDate<QRoleDo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QRoleDo> isDelete = _alias.isDelete;
  }
}
