package com.pvt.getmantseva.entity;

import java.util.List;

public class Journal {
    public String journal_title;
    public Contacts contact;
    List<Article> articles;

    public String getJournal_title() {
        return journal_title;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        Journal journal = (Journal) o;
        return getJournal_title().equals(journal.getJournal_title()) && getContact().equals(journal.getContact()) && getArticles().equals(journal.getArticles());
    }

    @Override
    public String toString() {
        return "Journal{" +
                "journal_title='" + journal_title + '\'' +
                ", contact=" + contact +
                ", articles=" + articles +
                '}';
    }
}


