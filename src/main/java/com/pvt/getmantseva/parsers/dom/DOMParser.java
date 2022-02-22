package com.pvt.getmantseva.parsers.dom;


import com.pvt.getmantseva.entity.Article;
import com.pvt.getmantseva.entity.Contacts;
import com.pvt.getmantseva.entity.Hotkeys;
import com.pvt.getmantseva.entity.Journal;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    public static List<Article> articles = new ArrayList<>();
    public static List<Contacts> contacts = new ArrayList<>();
    public static List<Hotkeys> hotkeys = new ArrayList<>();
    public static List<Journal> journals = new ArrayList<>();

    public static Article setArticlesWithXMLChildNodeValue(Article article, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {

            case "title" -> article.setTitle(content);
            case "author" -> article.setAuthor(content);
            case "url" -> article.setUrl(content);
            case "hotkeys" -> article.setHotkeys(article.getHotkeys());
        }
        return article;
    }

    public static void setArticleWithXMLNodeValues(NodeList nodeList) {

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                Article article = new Article();
                article.setId(node.getAttributes().
                        getNamedItem("id").getNodeValue());


                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setArticlesWithXMLChildNodeValue(article, childNode);
                    }
                });
                articles.add(article);
            }
        });
    }

    public static Contacts setContactsWithXMLChildNodeValues(Contacts contact, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "address" -> contact.setAddress(content);
            case "tel" -> contact.setTel(content);
            case "email" -> contact.setEmail(content);
            case "journal_url" -> contact.setJournal_url(content);
        }
        return contact;
    }


    public static void setContactsWithXMLNodeValues(NodeList nodeList) {

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            Contacts contact = new Contacts();
            if (node instanceof Element) {
                setContactsWithXMLChildNodeValues(contact, node);
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setContactsWithXMLChildNodeValues(contact, childNode);
                    }
                });
                contacts.add(contact);
            }
        });
    }

    public static Hotkeys setHotkeyWithXMLChildNodeValues(Hotkeys hotkey, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {

            case "hotkey" -> hotkey.setHotkey(content);
        }
        return hotkey;
    }

    public static void setHotkeyWithXMLNodeValues(NodeList nodeList) {

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            Hotkeys hotkey = new Hotkeys();
            if (node instanceof Element) {
                setHotkeyWithXMLChildNodeValues(hotkey, node);
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setHotkeyWithXMLChildNodeValues(hotkey, childNode);
                    }
                });
                hotkeys.add(hotkey);
            }
        });
    }

    public static Journal setTitleWithXMLChildNodeValues(Journal journal, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {

            case "journal_title" -> journal.setJournal_title(content);
        }
        return journal;
    }

    public static void setTitleWithXMLNodeValues(NodeList nodeList) {

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            Journal journal = new Journal();
            if (node instanceof Element) {
                setTitleWithXMLChildNodeValues(journal, node);
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        setTitleWithXMLChildNodeValues(journal, childNode);
                    }
                });
                journals.add(journal);
            }
        });
    }
}
