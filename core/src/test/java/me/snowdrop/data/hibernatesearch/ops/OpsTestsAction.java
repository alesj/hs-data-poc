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

package me.snowdrop.data.hibernatesearch.ops;

import java.util.ArrayList;
import java.util.List;

import me.snowdrop.data.hibernatesearch.DatasourceMapperForTest;
import me.snowdrop.data.hibernatesearch.TestUtils;
import me.snowdrop.data.hibernatesearch.TestsAction;
import org.hibernate.search.spi.SearchIntegrator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public class OpsTestsAction implements TestsAction {

  @Autowired
  DatasourceMapperForTest<SimpleEntity> datasourceMapper;

  public void setUp() {
    List<SimpleEntity> entities = new ArrayList<>();

    SimpleEntity entity = new SimpleEntity(1L, "ann", "Does Ann like good red apples?", -20, true, "Superman", "red");
    entities.add(entity);
    entity = new SimpleEntity(2L, "barb", "Why is Barb dancing twist?", -10, true, "Spiderman", "red");
    entities.add(entity);
    entity = new SimpleEntity(3L, "carl", "Carl is good at running and jumping.", 0, true, "Flash", "red");
    entities.add(entity);
    entity = new SimpleEntity(4L, "doug", "Doug likes to sleeps.", 10, false, "Batman", "black");
    entities.add(entity);
    entity = new SimpleEntity(5L, "eva", "Eva is running in circles.", 20, false, "Ironman", "gold");
    entities.add(entity);
    entity = new SimpleEntity(6L, "fanny", "Fanny is reading a good book.", 30, false, "Aquaman", "blue");
    entities.add(entity);

    TestUtils.preindexEntities(datasourceMapper, entities.toArray(new SimpleEntity[0]));
  }

  public void tearDown() {
    TestUtils.purgeAll(datasourceMapper, SimpleEntity.class);
  }
}
