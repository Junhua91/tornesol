package com.junhua.tornesol.util.ioc.xml_parse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlDemo {

    static public void main(String[] args) {
        new XmlDemo().parseXml();
    }

    public void parseXml() {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(getResourceAsStream("redis.xml"));
            Element rootElement = document.getRootElement();
            List<Element> beans = rootElement.elements("bean");
            for (Element bean : beans) {
                System.out.println(bean.getName());
                printAttrs(bean);
                List<Element> props = bean.elements("property");
                props.forEach(p->printAttrs(p));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void printAttrs(Element element){
        List<Attribute> attrs = element.attributes();
        for (Attribute attr : attrs) {
            System.out.println(attr.getName() + " => " + attr.getData());
        }
    }




    public InputStream getResourceAsStream(String xmlPath) {
        return this.getClass().getClassLoader().getResourceAsStream(xmlPath);
    }

}
