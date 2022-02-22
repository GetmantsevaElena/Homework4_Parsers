package com.pvt.getmantseva.parsers.stax;

import com.pvt.getmantseva.entity.Article;
import com.pvt.getmantseva.entity.Contacts;
import com.pvt.getmantseva.entity.Hotkeys;
import com.pvt.getmantseva.entity.Journal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class STAXParser {
    public static void main(String[] args) throws XMLStreamException {
        List<Journal> journalTitleList = null;
        List<Contacts> contactsList = null;
        List<Article> articleList = null;
        List<Hotkeys> hotkeysList = null;
        Journal currJournalTitle = null;
        Contacts currContacts = null;
        Article currArticle = null;
        Hotkeys currHotkeys = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream("journal.xml"));

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:

                    if ("journal_title".equals(reader.getLocalName())) {
                        currJournalTitle = new Journal();
                        currJournalTitle.setJournal_title(reader.getAttributeValue(0));
                    }
                    if ("journal".equals(reader.getLocalName())) {
                        journalTitleList = new ArrayList<>();
                    }
                    if ("address".equals(reader.getLocalName())) {
                        currContacts = new Contacts();
                        currContacts.setAddress(reader.getAttributeValue(0));
                    }
                    if ("contacts".equals(reader.getLocalName())) {
                        contactsList = new ArrayList<>();
                    }
                    if ("article".equals(reader.getLocalName())) {
                        currArticle = new Article();
                        currArticle.setId(reader.getAttributeValue(0));
                    }
                    if ("articles".equals(reader.getLocalName())) {
                        articleList = new ArrayList<>();
                    }
                    if ("hotkeys".equals(reader.getLocalName())) {
                    }
                    if ("hotkey".equals(reader.getLocalName())) {
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {

                        case "journal" -> journalTitleList.add(currJournalTitle);
                        case "journal_title" -> currJournalTitle.setJournal_title(tagContent);

                        case "contacts" -> contactsList.add(currContacts);
                        case "address" -> currContacts.setAddress(tagContent);
                        case "tel" -> currContacts.setTel(tagContent);
                        case "email" -> currContacts.setEmail(tagContent);
                        case "journal_url" -> currContacts.setJournal_url(tagContent);

                        case "articles" -> articleList.add(currArticle);
                        case "ID" -> currArticle.setId(tagContent);
                        case "title" -> currArticle.setTitle(tagContent);
                        case "author" -> currArticle.setAuthor(tagContent);
                        case "url" -> currArticle.setUrl(tagContent);
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    journalTitleList = new ArrayList<>();
                    contactsList = new ArrayList<>();
                    articleList = new ArrayList<>();
                    break;
            }
        }
        for (
                Journal journal : journalTitleList) {
            System.out.println(journal);
        }
        for (
                Contacts contact : contactsList) {
            System.out.println(contact);
        }
        for (
                Article article : articleList) {
            System.out.println(article);
        }
    }
}
