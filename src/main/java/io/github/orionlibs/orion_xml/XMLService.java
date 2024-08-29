package io.github.orionlibs.orion_xml;

import io.github.orionlibs.orion_xml.tasks.ConvertObjectToXMLTask;
import io.github.orionlibs.orion_xml.tasks.ConvertXMLToObjectTask;
import io.github.orionlibs.orion_xml.tasks.OpenXMLFileTask;
import io.github.orionlibs.orion_xml.tasks.SaveXMLToFileTask;
import jakarta.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLService
{
    public static Document openXMLFile(String XMLFilePath) throws JAXBException, ParserConfigurationException, SAXException, IOException
    {
        return openXMLFile(new File(XMLFilePath));
    }


    public static Document openXMLFile(File XMLFilePath) throws JAXBException, ParserConfigurationException, SAXException, IOException
    {
        return OpenXMLFileTask.run(XMLFilePath);
    }


    public static void saveXMLToFile(Document XMLDocument, String XMLFilePath) throws TransformerFactoryConfigurationError, TransformerConfigurationException, IllegalArgumentException, TransformerException, IOException
    {
        saveXMLToFile(XMLDocument, new File(XMLFilePath));
    }


    public static void saveXMLToFile(Document XMLDocument, File XMLFile) throws TransformerFactoryConfigurationError, TransformerConfigurationException, IllegalArgumentException, TransformerException, IOException
    {
        SaveXMLToFileTask.run(XMLDocument, XMLFile);
    }


    public static void convertObjectToXML(Object objectToConvert, String XMLFilePath) throws JAXBException
    {
        convertObjectToXML(objectToConvert, new File(XMLFilePath));
    }


    public static void convertObjectToXML(Object objectToConvert, File XMLFile) throws JAXBException
    {
        ConvertObjectToXMLTask.run(objectToConvert, XMLFile);
    }


    public static Object convertXMLToObject(Class<?> classToMapTheXMLData, String XMLFilePath) throws JAXBException
    {
        return convertXMLToObject(classToMapTheXMLData, new File(XMLFilePath));
    }


    public static Object convertXMLToObject(Class<?> classToMapTheXMLData, File XMLFile) throws JAXBException
    {
        return ConvertXMLToObjectTask.run(classToMapTheXMLData, XMLFile);
    }
}