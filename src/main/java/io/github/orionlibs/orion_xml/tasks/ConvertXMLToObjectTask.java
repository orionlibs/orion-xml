package io.github.orionlibs.orion_xml.tasks;

import io.github.orionlibs.orion_assert.Assert;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class ConvertXMLToObjectTask
{
    public static Object run(Class<?> classToMapTheXMLData, File XMLFilePath) throws JAXBException
    {
        Assert.notNull(classToMapTheXMLData, "The given classToMapTheXMLData is null.");
        Assert.notNull(XMLFilePath, "The given XMLFilePath is null.");
        JAXBContext JAXBContext1 = JAXBContext.newInstance(classToMapTheXMLData);
        Unmarshaller JAXBUnmarshaller = JAXBContext1.createUnmarshaller();
        return JAXBUnmarshaller.unmarshal(XMLFilePath);
    }
}