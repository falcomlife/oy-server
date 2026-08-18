package com.cotte.estate.bean.pojo.dto.query.assoc;

import com.cotte.estate.bean.pojo.doo.storage.query.assoc.QAssocAuthorityDo;
import com.cotte.estate.bean.pojo.doo.storage.query.assoc.QAssocRoleDo;
import com.cotte.estate.bean.pojo.dto.UserAuthenticationDto;
import com.cotte.estate.bean.pojo.dto.query.QUserAuthenticationDto;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;

/**
 * Association query bean for AssocUserAuthenticationDto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocUserAuthenticationDto<R> extends TQAssocBean<UserAuthenticationDto,R> {

  public PString<R> id;
  public PString<R> companyName;
  public PString<R> companyCode;
  public PString<R> username;
  public PString<R> account;
  public PString<R> password;
  public QAssocRoleDo<R> roles;
  public QAssocAuthorityDo<R> authoritys;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QUserAuthenticationDto>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QUserAuthenticationDto>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QUserAuthenticationDto>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocUserAuthenticationDto(String name, R root) {
    super(name, root);
  }
}
