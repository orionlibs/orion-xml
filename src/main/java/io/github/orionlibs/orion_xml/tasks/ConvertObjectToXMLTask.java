package io.github.orionlibs.orion_xml.tasks;

import io.github.orionlibs.orion_assert.Assert;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class ConvertObjectToXMLTask
{
    public static void run(Object objectToConvert, File XMLFile) throws JAXBException
    {
        Assert.notNull(objectToConvert, "The given objectToConvert is null.");
        Assert.notNull(XMLFile, "The given XMLFile is null.");
        JAXBContext JAXBContext1 = JAXBContext.newInstance(objectToConvert.getClass());
        Marshaller JAXBMarshaller = JAXBContext1.createMarshaller();
        JAXBMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBMarshaller.marshal(objectToConvert, XMLFile);
    }
}