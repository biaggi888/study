package jee.day01.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by èÕ◊â§Œ•È•§•¿©` on 28/08/15.
 */
public class SaxDemo1
{

  public static void main(String[] args) {
    SAXParser parser = null;
    try {
      parser = SAXParserFactory.newInstance().newSAXParser();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
    XMLReader reader = null;
    try {
      reader = parser.getXMLReader();
    } catch (SAXException e) {
      e.printStackTrace();
    }

    reader.setContentHandler(new MyContentHandler());
    try {
      reader.parse("resources/books.xml");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }
}


class MyContentHandler implements ContentHandler
{
  @Override
  public void startDocument() throws SAXException {
    System.out.println("1.StartDocument");
  }
  @Override
  public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    System.out.println("2"+uri + " , " + localName +","+qName);

  }
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    System.out.println("3"+new String(ch,start,length));

  }
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    System.out.println("4."+uri + " , " + localName +","+qName);

  }
  @Override
  public void endDocument() throws SAXException {
    System.out.println("5. End document");

  }





  @Override
  public void setDocumentLocator(Locator locator) {

  }



  @Override
  public void startPrefixMapping(String prefix, String uri) throws SAXException {

  }

  @Override
  public void endPrefixMapping(String prefix) throws SAXException {

  }




  @Override
  public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

  }

  @Override
  public void processingInstruction(String target, String data) throws SAXException {

  }

  @Override
  public void skippedEntity(String name) throws SAXException {

  }
}
