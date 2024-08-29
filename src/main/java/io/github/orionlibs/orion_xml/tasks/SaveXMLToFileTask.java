package io.github.orionlibs.orion_xml.tasks;

import io.github.orionlibs.orion_assert.Assert;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class SaveXMLToFileTask
{
    public static void run(Document XMLDocument, File XMLFilePath) throws TransformerFactoryConfigurationError, TransformerConfigurationException, IllegalArgumentException, TransformerException, IOException
    {
        Assert.notNull(XMLDocument, "The given XMLDocument is null.");
        Assert.notNull(XMLFilePath, "The given XMLFilePath is null.");
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        tFactory.setAttribute("indent-number", Integer.valueOf(4));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(XMLDocument);
        OutputStream output = Files.newOutputStream(XMLFilePath.toPath());
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
        transformer.reset();
    }
}