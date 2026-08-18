package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.AuthorityAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for AuthorityAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAuthorityAo extends TQRootBean<AuthorityAo,QAuthorityAo> {

  private static final QAuthorityAo _alias = new QAuthorityAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QAuthorityAo alias() {
    return _alias;
  }

  public PString<QAuthorityAo> id;
  public PString<QAuthorityAo> name;
  public PInteger<QAuthorityAo> type;
  public PString<QAuthorityAo> code;
  public PInteger<QAuthorityAo> user;
  public PBoolean<QAuthorityAo> isEnable;
  public PBoolean<QAuthorityAo> inRole;
  public PUtilDate<QAuthorityAo> createTime;
  public PUtilDate<QAuthorityAo> modifiedTime;
  public PBoolean<QAuthorityAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QAuthorityAo(EbeanServer server) {
    super(AuthorityAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QAuthorityAo() {
    super(AuthorityAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QAuthorityAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QAuthorityAo> id = _alias.id;
    public static PString<QAuthorityAo> name = _alias.name;
    public static PInteger<QAuthorityAo> type = _alias.type;
    public static PString<QAuthorityAo> code = _alias.code;
    public static PInteger<QAuthorityAo> user = _alias.user;
    public static PBoolean<QAuthorityAo> isEnable = _alias.isEnable;
    public static PBoolean<QAuthorityAo> inRole = _alias.inRole;
    public static PUtilDate<QAuthorityAo> createTime = _alias.createTime;
    public static PUtilDate<QAuthorityAo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QAuthorityAo> isDelete = _alias.isDelete;
  }
}
