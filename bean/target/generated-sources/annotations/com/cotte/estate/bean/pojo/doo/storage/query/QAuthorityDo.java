package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.AuthorityDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for AuthorityDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAuthorityDo extends TQRootBean<AuthorityDo,QAuthorityDo> {

  private static final QAuthorityDo _alias = new QAuthorityDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QAuthorityDo alias() {
    return _alias;
  }

  public PString<QAuthorityDo> id;
  public PString<QAuthorityDo> name;
  public PInteger<QAuthorityDo> type;
  public PString<QAuthorityDo> code;
  public PInteger<QAuthorityDo> user;
  public PBoolean<QAuthorityDo> isEnable;
  public PUtilDate<QAuthorityDo> createTime;
  public PUtilDate<QAuthorityDo> modifiedTime;
  public PBoolean<QAuthorityDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QAuthorityDo(EbeanServer server) {
    super(AuthorityDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QAuthorityDo() {
    super(AuthorityDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QAuthorityDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QAuthorityDo> id = _alias.id;
    public static PString<QAuthorityDo> name = _alias.name;
    public static PInteger<QAuthorityDo> type = _alias.type;
    public static PString<QAuthorityDo> code = _alias.code;
    public static PInteger<QAuthorityDo> user = _alias.user;
    public static PBoolean<QAuthorityDo> isEnable = _alias.isEnable;
    public static PUtilDate<QAuthorityDo> createTime = _alias.createTime;
    public static PUtilDate<QAuthorityDo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QAuthorityDo> isDelete = _alias.isDelete;
  }
}
