/**
 * Copyright 2010 OpenEngSB Division, Vienna University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.openengsbplugin;

import org.openengsb.openengsbplugin.base.LicenseMojo;

/**
 * Adds/updates license headers where necessary.
 * 
 * @goal licenseFormat
 * 
 * @inheritedByDefault false
 * 
 * @requiresProject true
 * 
 * @aggregator true
 * 
 */
public class LicenseFormat extends LicenseMojo {

    public LicenseFormat() {
        wrappedGoal = "validate";
        headerPath = "license/header.txt";
        configs.add("license/licenseConfig.xml");
    }

}
