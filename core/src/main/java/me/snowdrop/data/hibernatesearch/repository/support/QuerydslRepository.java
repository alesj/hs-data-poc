/*
 * Copyright 2018 Red Hat, Inc, and individual contributors.
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

package me.snowdrop.data.hibernatesearch.repository.support;

import java.util.Optional;

import me.snowdrop.data.hibernatesearch.core.HibernateSearchOperations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public class QuerydslRepository<T, ID> extends AbstractHibernateSearchCrudRepository<T, ID> implements QuerydslPredicateExecutor<T> {
    public QuerydslRepository(HibernateSearchOperations hibernateSearchOperations, HibernateSearchEntityInformation<T, ID> entityInformation) {
        super(hibernateSearchOperations, entityInformation);
    }

    @Override
    public Optional<T> findOne(com.querydsl.core.types.Predicate predicate) {
        return Optional.empty();
    }

    @Override
    public Iterable<T> findAll(com.querydsl.core.types.Predicate predicate) {
        return null;
    }

    @Override
    public Iterable<T> findAll(com.querydsl.core.types.Predicate predicate, Sort sort) {
        return null;
    }

    @Override
    public Iterable<T> findAll(com.querydsl.core.types.Predicate predicate, com.querydsl.core.types.OrderSpecifier<?>... orders) {
        return null;
    }

    @Override
    public Iterable<T> findAll(com.querydsl.core.types.OrderSpecifier<?>... orders) {
        return null;
    }

    @Override
    public Page<T> findAll(com.querydsl.core.types.Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public long count(com.querydsl.core.types.Predicate predicate) {
        return 0;
    }

    @Override
    public boolean exists(com.querydsl.core.types.Predicate predicate) {
        return false;
    }
}
