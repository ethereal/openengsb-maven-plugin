/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.openengsbplugin.tools;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

public interface MavenExecutor {

    /**
     * Builds and executes a {@link org.apache.maven.execution.MavenExecutionRequest MavenExecutionRequest} with given
     * parameters. The request is copied from the wrapper request so all parameters except goals, activeProfiles,
     * deactivateProfiles and userProperties are inherited and have to be changed explicitly.
     */
    void execute(Log log) throws MojoExecutionException;

    /**
     * Changes this inherited parameter explicitely.
     *
     * @param interactiveMode <code>true</code> enables interactive mode for this execution <br/>
     *        <code>false</code> is equivalent to <code>mvn --batch-mode &lt;goal&gt;
     */
    void setInterActiveMode(boolean interactiveMode);

    /**
     * Changes this inherited parameter explicitely.
     *
     * @param recursive <code>true</code> recursive execution of the embedded request
     */
    void setRecursive(boolean recursive);

    void addGoals(List<String> goals);

    void addActivatedProfiles(List<String> activatedProfiles);

    void addDeactivatedProfiles(List<String> deactivatedProfiles);

    void addUserProperties(Properties userproperties);

    void addProperties(List<String> goals, List<String> activatedProfiles, List<String> deactivatedProfiles,
            Properties userproperties);

    void setCustomPomFile(File pomFile);

}
