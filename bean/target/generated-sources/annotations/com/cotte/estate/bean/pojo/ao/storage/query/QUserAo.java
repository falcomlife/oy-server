package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.UserAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for UserAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QUserAo extends TQRootBean<UserAo,QUserAo> {

  private static final QUserAo _alias = new QUserAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QUserAo alias() {
    return _alias;
  }

  public PString<QUserAo> id;
  public PString<QUserAo> companyId;
  public PString<QUserAo> roleId;
  public PString<QUserAo> companyCode;
  public PString<QUserAo> name;
  public PString<QUserAo> code;
  public PString<QUserAo> account;
  public PString<QUserAo> password;
  public PString<QUserAo> newPassword;
  public PBoolean<QUserAo> isLock;
  public PString<QUserAo> isLockName;
  public PBoolean<QUserAo> roleFlag;
  public PUtilDate<QUserAo> createTime;
  public PUtilDate<QUserAo> modifiedTime;
  public PBoolean<QUserAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QUserAo(EbeanServer server) {
    super(UserAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QUserAo() {
    super(UserAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QUserAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QUserAo> id = _alias.id;
    public static PString<QUserAo> companyId = _alias.companyId;
    public static PString<QUserAo> roleId = _alias.roleId;
    public static PString<QUserAo> companyCode = _alias.companyCode;
    public static PString<QUserAo> name = _alias.name;
    public static PString<QUserAo> code = _alias.code;
    public static PString<QUserAo> account = _alias.account;
    public static PString<QUserAo> password = _alias.password;
    public static PString<QUserAo> newPassword = _alias.newPassword;
    public static PBoolean<QUserAo> isLock = _alias.isLock;
    public static PString<QUserAo> isLockName = _alias.isLockName;
    public static PBoolean<QUserAo> roleFlag = _alias.roleFlag;
    public static PUtilDate<QUserAo> createTime = _alias.createTime;
    public static PUtilDate<QUserAo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QUserAo> isDelete = _alias.isDelete;
  }
}
