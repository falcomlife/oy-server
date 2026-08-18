package com.cotte.estate.bean.pojo.doo.storage.query;

import com.cotte.estate.bean.pojo.doo.storage.CompanyDo;
import io.ebean.EbeanServer;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for CompanyDo.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QCompanyDo extends TQRootBean<CompanyDo,QCompanyDo> {

  private static final QCompanyDo _alias = new QCompanyDo(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QCompanyDo alias() {
    return _alias;
  }

  public PString<QCompanyDo> id;
  public PString<QCompanyDo> name;
  public PString<QCompanyDo> code;
  public PBoolean<QCompanyDo> isEnable;
  public PUtilDate<QCompanyDo> createTime;
  public PUtilDate<QCompanyDo> modifiedTime;
  public PBoolean<QCompanyDo> isDelete;


  /**
   * Construct with a given EbeanServer.
   */
  public QCompanyDo(EbeanServer server) {
    super(CompanyDo.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QCompanyDo() {
    super(CompanyDo.class);
  }

  /**
   * Construct for Alias.
   */
  private QCompanyDo(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QCompanyDo> id = _alias.id;
    public static PString<QCompanyDo> name = _alias.name;
    public static PString<QCompanyDo> code = _alias.code;
    public static PBoolean<QCompanyDo> isEnable = _alias.isEnable;
    public static PUtilDate<QCompanyDo> createTime = _alias.createTime;
    public static PUtilDate<QCompanyDo> modifiedTime = _alias.modifiedTime;
    public static PBoolean<QCompanyDo> isDelete = _alias.isDelete;
  }
}
