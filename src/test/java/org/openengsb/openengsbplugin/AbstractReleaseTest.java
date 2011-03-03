/**
 * Licensed to the Austrian Association for
 * Software Tool Integration (AASTI) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.openengsb.openengsbplugin;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractReleaseTest extends MojoPreparation {

    protected File releaseRepo = null;
    protected File snapshotRepo = null;

    @Before
    public void initRepos() {
        releaseRepo = new File("src/test/resources/release/dummyReleaseRepo");
        assertTrue(releaseRepo.mkdir());
        snapshotRepo = new File("src/test/resources/release/dummySnapshotRepo");
        assertTrue(snapshotRepo.mkdir());
    }

    @After
    public void destroyRepos() {
        FileUtils.deleteQuietly(releaseRepo);
        FileUtils.deleteQuietly(snapshotRepo);
    }

}
