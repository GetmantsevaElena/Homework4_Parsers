package com.pvt.getmantseva.parsers.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParserDemo {
    private static final String XML_PATH = "journal.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Document document = DOMParserUtils.parseXMLDocument(XML_PATH);

        NodeList nodeJournalTitle = document.getElementsByTagName("journal_title");
        DOMParser.setTitleWithXMLNodeValues(nodeJournalTitle);
        System.out.println(DOMParser.journals.toString());

        NodeList nodeContacts = document.getElementsByTagName("contacts");
        DOMParser.setContactsWithXMLNodeValues(nodeContacts);
        System.out.println(DOMParser.contacts.toString());

        NodeList nodeArticles = document.getElementsByTagName("articles");
        DOMParser.setArticleWithXMLNodeValues(nodeArticles);
        System.out.println(DOMParser.articles.toString());

        NodeList nodeHotkeys = document.getElementsByTagName("hotkeys");
        DOMParser.setHotkeyWithXMLNodeValues(nodeHotkeys);
        System.out.println(DOMParser.hotkeys.toString());


    }
}

