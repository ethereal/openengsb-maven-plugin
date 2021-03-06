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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPathConstants;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.openengsb.openengsbplugin.xml.OpenEngSBMavenPluginNSContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ToolsTest {

    private static final String LICENSECHECK_CONFIG_PATH = "license/licenseConfig.xml";
    private static final NamespaceContext NS_CONTEXT = new OpenEngSBMavenPluginNSContext();
    private static final String POM_NS_URI = NS_CONTEXT.getNamespaceURI("pom");

    @Test
    public void testExpectedInput() {
        assertEquals("Hello world", Tools.capitalizeFirst("hello world"));
        assertEquals("H", Tools.capitalizeFirst("h"));
    }

    @Test
    public void testUnexpectedInput() {
        assertNull(Tools.capitalizeFirst(null));
        assertEquals("", Tools.capitalizeFirst(""));
        assertEquals(" ", Tools.capitalizeFirst(" "));
        assertEquals("  ", Tools.capitalizeFirst("  "));
        assertEquals("?", Tools.capitalizeFirst("?"));
        assertEquals("/&%(#", Tools.capitalizeFirst("/&%(#"));
    }

    @Test
    public void testXPath() throws Exception {
        Document doc = Tools.parseXMLFromString(IOUtils.toString(ClassLoader
                .getSystemResourceAsStream(LICENSECHECK_CONFIG_PATH)));
        Node n = Tools.evaluateXPath("//c:config", doc, NS_CONTEXT, XPathConstants.NODE, Node.class);
        assertEquals("config", n.getLocalName());
    }

    @Test
    public void testTmpFile() throws IOException {
        String fileContent = "BLA\n";
        File generatedFile = Tools.generateTmpFile(fileContent, ".txt");
        File f = new File(generatedFile.getAbsolutePath());
        String readContent = FileUtils.readFileToString(f);
        assertEquals(fileContent, readContent);
        assertTrue(generatedFile.delete());
    }

    @Test
    public void testInsertDomNode() throws Exception {
        Document thePom = Tools.parseXMLFromString(IOUtils.toString(ClassLoader
                .getSystemResourceAsStream("licenseCheck/pass/pom.xml")));

        Document d = Tools.newDOM();
        Node nodeB = d.createElementNS(POM_NS_URI, "b");

        Node importedNode = thePom.importNode(nodeB, true);

        Tools.insertDomNode(thePom, importedNode, "/pom:project/pom:a", NS_CONTEXT);

        String serializedXml = Tools.serializeXML(thePom);
        File generatedFile = Tools.generateTmpFile(serializedXml, ".xml");

        Document generatedPom = Tools.parseXMLFromString(FileUtils.readFileToString(generatedFile));

        Node foundNode = Tools.evaluateXPath("/pom:project/pom:a/pom:b", generatedPom, NS_CONTEXT, XPathConstants.NODE,
                Node.class);

        assertNotNull(foundNode);
        assertTrue(generatedFile.delete());
    }

    @Test
    public void testRemoveNode() throws Exception {
        Document doc = Tools.parseXMLFromString(IOUtils.toString(ClassLoader
                .getSystemResourceAsStream("removeNode/pom.xml")));
        String xpath = "/pom:project/pom:properties";
        assertNotNull(Tools.evaluateXPath(xpath, doc, NS_CONTEXT, XPathConstants.NODE, Node.class));
        Tools.removeNode("/pom:project/pom:properties", doc, NS_CONTEXT, false);
        assertNull(Tools.evaluateXPath(xpath, doc, NS_CONTEXT, XPathConstants.NODE, Node.class));
    }

}
