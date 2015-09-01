package jee.day01.xml.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @version
 */
public class Dom4jDemo
{

  public String find(Element element) {
    if (element == null) return null;
    for (Iterator<Element> i = element.elementIterator();i.hasNext();) {
      Element e = (Element)i.next();
      System.out.println(e.getName() + " : "
      + e.getText());
      if(element.elements().size() !=0) {
        for(int j = 0; j < element.elements().size(); j++) {
          List<Element> es = element.elements();
          find(es.get(j));
        }
      }

    }
    return null;
  }
  public Element getRoot(String fileName) {
    SAXReader reader = new SAXReader();
    Document doc = null;
    try {
      doc = reader.read(fileName);
    } catch (DocumentException e) {
      e.printStackTrace();
    }
    return doc != null ? doc.getRootElement() : null;
  }

  //Save to file
  private void saveFile(Document doc, String path) {
    saveFile(doc, new File(path));
  }

  private void saveFile(Document doc, File f) {
    XMLWriter writer = null;
    try {
      writer = new XMLWriter(new FileWriter(f),
                                OutputFormat.createPrettyPrint());
      writer.write(doc);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (writer != null)
          writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
