package io.oasp.example.component.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.oasp.example.component.common.api.Bar;
import io.oasp.example.component.common.api.Foo;
import io.oasp.example.general.dataaccess.api.TestApplicationPersistenceEntity;
import io.oasp.module.basic.common.api.reference.IdRef;
import io.oasp.module.jpa.dataaccess.api.JpaHelper;

/**
 * Implementation of {@link Foo} as {@link TestApplicationPersistenceEntity persistence entity}.
 */
@Entity
@Table(name = "Foo")
public class FooEntity extends TestApplicationPersistenceEntity implements Foo {
  private static final long serialVersionUID = 1L;

  private String name;

  private BarEntity bar;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return the {@link BarEntity}.
   */
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "bar")
  public BarEntity getBar() {

    return this.bar;
  }

  /**
   * @param bar new value of {@link #getBar()}.
   */
  public void setBar(BarEntity bar) {

    this.bar = bar;
  }

  @Override
  @Transient
  public IdRef<Bar> getBarId() {

    // you actually need Java8 type-inference to use this feature in a comfortable way as otherwise you need to qualify
    // the generic on every use

    // return IdRef.of(this.bar); // Java 8+
    return IdRef.<Bar> of(this.bar); // Java 5/6/7
  }

  @Override
  public void setBarId(IdRef<Bar> barId) {

    this.bar = JpaHelper.asEntity(barId, BarEntity.class);
  }

}
