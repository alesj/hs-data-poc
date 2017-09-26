/*
 * Copyright 2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.snowdrop.data.hibernatesearch.core;

import java.util.stream.Stream;

import me.snowdrop.data.hibernatesearch.core.mapping.HibernateSearchPersistentProperty;
import me.snowdrop.data.hibernatesearch.spi.Query;
import org.hibernate.search.spi.SearchIntegrator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.mapping.context.MappingContext;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public interface HibernateSearchOperations {

	/**
	 * Get search integrator for entity class.
	 *
	 * @param entityClass the entity class
	 * @return the search integrator
	 */
	SearchIntegrator getSearchIntegrator(Class<?> entityClass);

	/**
	 * Get mapping context.
	 *
	 * @return the mapping context
	 */
	MappingContext<?, HibernateSearchPersistentProperty> getMappingContext();

  /**
   * Returns the number of entities available.
   *
   * @param query the query
   * @return the number of entities
   */
  <T> long count(Query<T> query);

  /**
   * Returns optinal single instance of the type.
   *
   * @param query the query
   * @return matching optional entity
   */
  <T> T findSingle(Query<T> query);

  /**
   * Returns all instances of the type.
   *
   * @param query the query
   * @return all entities
   */
  <T> Iterable<T> findAll(Query<T> query);

  /**
   * Returns a {@link Slice} of entities meeting the paging restriction provided in the {@code Pageable} object.
   *
   * @param query the query
   * @return a slice of entities
   */
  <T> Slice<T> findSlice(Query<T> query);

  /**
   * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
   *
   * @param query the query
   * @return a page of entities
   */
  <T> Page<T> findPageable(Query<T> query);

  /**
   * Returns a stream of entities meeting the paging restriction provided in the {@code Pageable} object.
   *
   * @param query the query
   * @return a stream of entities
   */
  <T> Stream<T> stream(Query<T> query);
}
