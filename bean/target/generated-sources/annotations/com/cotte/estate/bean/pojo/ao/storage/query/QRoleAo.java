package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.RoleAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for RoleAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QRoleAo extends TQRootBean<RoleAo,QRoleAo> {

  private static final QRoleAo _alias = new QRoleAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QRoleAo alias() {
    return _alias;
  }

  public PString<QRoleAo> id;
  public PString<QRoleAo> name;
  public PString<QRoleAo> companyId;
  public PString<QRoleAo> authorityId;
  public PBoolean<QRoleAo> inUser;
  public PBoolean<QRoleAo> authorityFlag;
  public PUtilDate<QRoleAo> createTime;
  public PUtilDate<QRoleAo> modifiedTime;
  public PBoolean<QRoleAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QRoleAo(EbeanServer server) {
    super(RoleAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QRoleAo() {
    super(RoleAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QRoleAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QRoleAo> id = _alias.id;
    public static PString<QRoleAo> name = _alias.name;
    public static PString<QRoleAo> companyId = _alias.companyId;
    public static PString<QRoleAo> authorityId = _alias.authorityId;
    public static PBoolean<QRoleAo> inUser = _alias.inUser;
    public static PBoolean<QRoleAo> authorityFlag = _alias.authorityFlag;
    public static PUtilDate<QRoleAo> createTime = _alias.createTime;
    public static PUtilDate<QRoleAo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QRoleAo> isDelete = _alias.isDelete;
  }
}
