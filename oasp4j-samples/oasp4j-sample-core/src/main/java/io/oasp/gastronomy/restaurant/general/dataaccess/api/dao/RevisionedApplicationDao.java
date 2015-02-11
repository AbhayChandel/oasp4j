package io.oasp.gastronomy.restaurant.general.dataaccess.api.dao;

import io.oasp.module.jpa.dataaccess.api.Dao;
import io.oasp.module.jpa.dataaccess.api.RevisionedPersistenceEntity;

/**
 * Interface for all {@link Dao DAOs} (Data Access Object) of this application.
 *
 * @author etomety
 *
 * @param <ENTITY> is the type of the managed entity.
 */
public interface RevisionedApplicationDao<ENTITY extends RevisionedPersistenceEntity<Long>> extends Dao<ENTITY> {

}
