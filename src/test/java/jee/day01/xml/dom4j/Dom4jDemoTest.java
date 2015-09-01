package jee.day01.xml.dom4j;

import junit.framework.TestCase;

import org.junit.Test;

/**
 */
public class Dom4jDemoTest
{

  @Test
  public void testFind() throws Exception {
    Dom4jDemo d = new Dom4jDemo();
    d.find(d.getRoot("book.xml"));
  }
}