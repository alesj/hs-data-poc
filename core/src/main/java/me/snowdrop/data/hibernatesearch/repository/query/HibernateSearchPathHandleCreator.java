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

package me.snowdrop.data.hibernatesearch.repository.query;

import org.hibernate.search.metadata.FieldDescriptor;
import org.hibernate.search.metadata.IndexedTypeDescriptor;
import org.hibernate.search.metadata.PropertyDescriptor;
import org.hibernate.search.spi.IndexedTypeIdentifier;
import org.hibernate.search.spi.SearchIntegrator;
import org.hibernate.search.spi.impl.PojoIndexedTypeIdentifier;
import org.springframework.data.mapping.PathHandle;
import org.springframework.data.mapping.PathHandleCreator;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public class HibernateSearchPathHandleCreator implements PathHandleCreator {
	private final SearchIntegrator searchIntegrator;

	public HibernateSearchPathHandleCreator(SearchIntegrator searchIntegrator) {
		this.searchIntegrator = searchIntegrator;
	}

	@Override
	public PathHandle create(String name, Class<?> type) {
		IndexedTypeIdentifier indexedTypeIdentifier = PojoIndexedTypeIdentifier.convertFromLegacy(type);
		IndexedTypeDescriptor indexedTypeDescriptor = searchIntegrator.getIndexedTypeDescriptor(indexedTypeIdentifier);
		for (PropertyDescriptor pd : indexedTypeDescriptor.getIndexedProperties()) {
			for (FieldDescriptor fd : pd.getIndexedFields()) {
				if (fd.getName().equals(name)) {
					return new PathHandle() {
						@Override
						public String getSegment() {
							return name;
						}

						@Override
						public TypeInformation<?> getTypeInformation() {
							return ClassTypeInformation.from(type);
						}

						@Override
						public String toDotPath() {
							return name;
						}
					};
				}
			}
		}
		return null;
	}
}
