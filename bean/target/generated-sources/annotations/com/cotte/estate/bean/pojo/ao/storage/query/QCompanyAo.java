package com.cotte.estate.bean.pojo.ao.storage.query;

import com.cotte.estate.bean.pojo.ao.storage.CompanyAo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for CompanyAo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QCompanyAo extends TQRootBean<CompanyAo,QCompanyAo> {

  private static final QCompanyAo _alias = new QCompanyAo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QCompanyAo alias() {
    return _alias;
  }

  public PString<QCompanyAo> id;
  public PString<QCompanyAo> name;
  public PString<QCompanyAo> code;
  public PBoolean<QCompanyAo> isEnable;
  public PUtilDate<QCompanyAo> createTime;
  public PUtilDate<QCompanyAo> modifiedTime;
  public PBoolean<QCompanyAo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QCompanyAo(EbeanServer server) {
    super(CompanyAo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QCompanyAo() {
    super(CompanyAo.class);
  }

  /**
   * Construct for Alias.
   */
  private QCompanyAo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QCompanyAo> id = _alias.id;
    public static PString<QCompanyAo> name = _alias.name;
    public static PString<QCompanyAo> code = _alias.code;
    public static PBoolean<QCompanyAo> isEnable = _alias.isEnable;
    public static PUtilDate<QCompanyAo> createTime = _alias.createTime;
    public static PUtilDate<QCompanyAo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QCompanyAo> isDelete = _alias.isDelete;
  }
}
