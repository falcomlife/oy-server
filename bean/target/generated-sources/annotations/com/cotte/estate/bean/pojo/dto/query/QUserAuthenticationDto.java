package com.cotte.estate.bean.pojo.dto.query;

import com.cotte.estate.bean.pojo.doo.storage.query.assoc.QAssocAuthorityDo;
import com.cotte.estate.bean.pojo.doo.storage.query.assoc.QAssocRoleDo;
import com.cotte.estate.bean.pojo.dto.UserAuthenticationDto;
import io.ebean.EbeanServer;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Query bean for UserAuthenticationDto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QUserAuthenticationDto extends TQRootBean<UserAuthenticationDto,QUserAuthenticationDto> {

  private static final QUserAuthenticationDto _alias = new QUserAuthenticationDto(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QUserAuthenticationDto alias() {
    return _alias;
  }

  public PString<QUserAuthenticationDto> id;
  public PString<QUserAuthenticationDto> companyName;
  public PString<QUserAuthenticationDto> companyCode;
  public PString<QUserAuthenticationDto> username;
  public PString<QUserAuthenticationDto> account;
  public PString<QUserAuthenticationDto> password;
  public QAssocRoleDo<QUserAuthenticationDto> roles;
  public QAssocAuthorityDo<QUserAuthenticationDto> authoritys;


  /**
   * Construct with a given EbeanServer.
   */
  public QUserAuthenticationDto(EbeanServer server) {
    super(UserAuthenticationDto.class, server);
  }

  /**
   * Construct using the default EbeanServer.
   */
  public QUserAuthenticationDto() {
    super(UserAuthenticationDto.class);
  }

  /**
   * Construct for Alias.
   */
  private QUserAuthenticationDto(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QUserAuthenticationDto> id = _alias.id;
    public static PString<QUserAuthenticationDto> companyName = _alias.companyName;
    public static PString<QUserAuthenticationDto> companyCode = _alias.companyCode;
    public static PString<QUserAuthenticationDto> username = _alias.username;
    public static PString<QUserAuthenticationDto> account = _alias.account;
    public static PString<QUserAuthenticationDto> password = _alias.password;
    public static QAssocRoleDo<QUserAuthenticationDto> roles = _alias.roles;
    public static QAssocAuthorityDo<QUserAuthenticationDto> authoritys = _alias.authoritys;
  }
}
