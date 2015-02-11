package io.oasp.gastronomy.restaurant.general.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.module.jpa.dataaccess.api.AbstractRevisionedPersistenceEntity;

import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;

/**
 * Abstract Entity for all Entities with an id and a version field.
 *
 * @author hohwille
 * @author rjoeris
 */
@MappedSuperclass
@Audited
public abstract class RevisionedApplicationPersistenceEntity extends AbstractRevisionedPersistenceEntity implements
    ApplicationEntity {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public RevisionedApplicationPersistenceEntity() {

    super();
  }

}
