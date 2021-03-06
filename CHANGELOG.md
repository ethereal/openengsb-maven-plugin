openengsb-maven-plugin-1.4.0 2011-04-18
--------------------------------------------

The remainging things done via configurations (such as docs) are now moved from the OpenEngSB into the openengsb-maven-plugin.
In addition varous bugs and minor problems had been fixed.

### Highlights
  * upgrade entire structure to m3 (OPENENGSB-1296 and OPENENGSB-1297)
  * docs entirely like the OpenEngSB could be build without really configuring docs if the structure is exactly the same
  * a client archetype can be build directly using the plugin

### Details
** Bug
    * [OPENENGSB-1073] - openengsb:provision deletes data
    * [OPENENGSB-1109] - eclipse checkstyle-plugin gets really slow when offline
    * [OPENENGSB-1161] - openengsb:provision broken (on unix)
    * [OPENENGSB-1299] - Plugin cannot run prePush goal because of DOM not-found exception

** Improvement
    * [OPENENGSB-1121] - change exception handling in checkstyle
    * [OPENENGSB-1294] - Remove cross dependencies back to openengsb

** Library Upgrade
    * [OPENENGSB-1295] - Upgrade to openengsb-root 13
    * [OPENENGSB-1296] - Upgrade maven-plugin-api to 3.0.3
    * [OPENENGSB-1297] - Upgrade maven-core to 3.0.3
    * [OPENENGSB-1298] - Upgrade log4j to 1.2.16

** New Feature
    * [OPENENGSB-504] - use convention over configuration for docs in openengsb maven plugin
    * [OPENENGSB-1054] - Overwrite license-plugin ignore settings during configuring openengsb-mavenplugin
    * [OPENENGSB-1280] - Add client archetype to openengsb tool suite plugin

** Task
    * [OPENENGSB-1058] - release openengsb-maven-plugin-1.4.0
    * [OPENENGSB-1066] - Add openengsb-maven-plugin to openengsb-root
    * [OPENENGSB-1067] - errors in the license
    * [OPENENGSB-1300] - Cleanup code to openengsb formatting rules

