package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.UserDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for UserDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QUserDo extends TQRootBean<UserDo,QUserDo> {

  private static final QUserDo _alias = new QUserDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QUserDo alias() {
    return _alias;
  }

  public PString<QUserDo> id;
  public PString<QUserDo> companyId;
  public PString<QUserDo> name;
  public PString<QUserDo> account;
  public PString<QUserDo> code;
  public PString<QUserDo> password;
  public PBoolean<QUserDo> isLock;
  public PUtilDate<QUserDo> createTime;
  public PUtilDate<QUserDo> modifiedTime;
  public PBoolean<QUserDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QUserDo(EbeanServer server) {
    super(UserDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QUserDo() {
    super(UserDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QUserDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QUserDo> id = _alias.id;
    public static PString<QUserDo> companyId = _alias.companyId;
    public static PString<QUserDo> name = _alias.name;
    public static PString<QUserDo> account = _alias.account;
    public static PString<QUserDo> code = _alias.code;
    public static PString<QUserDo> password = _alias.password;
    public static PBoolean<QUserDo> isLock = _alias.isLock;
    public static PUtilDate<QUserDo> createTime = _alias.createTime;
    public static PUtilDate<QUserDo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QUserDo> isDelete = _alias.isDelete;
  }
}
