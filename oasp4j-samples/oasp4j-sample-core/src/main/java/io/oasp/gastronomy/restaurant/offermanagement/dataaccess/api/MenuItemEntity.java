package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.RevisionedApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.MenuItem;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;

/**
 * The {@link io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * {@link MenuItem}.
 *
 * @author loverbec
 */
@MappedSuperclass
@Audited
public abstract class MenuItemEntity extends RevisionedApplicationPersistenceEntity implements MenuItem {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  /**
   * The constructor.
   */
  public MenuItemEntity() {

    super();
  }

  /**
   * {@inheritDoc}
   */
  @Column(name = "name", unique = true)
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Column(name = "description")
  @Override
  public String getDescription() {

    return this.description;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

}
