package com.pvt.getmantseva.entity;

import java.util.Objects;

public class Contacts {
    public String address;
    public String tel;
    public String email;
    public String journal_url;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJournal_url() {
        return journal_url;
    }

    public void setJournal_url(String journal_url) {
        this.journal_url = journal_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacts)) return false;
        Contacts contacts = (Contacts) o;
        return getAddress().equals(contacts.getAddress()) && getTel().equals(contacts.getTel()) && getEmail().equals(contacts.getEmail()) && getJournal_url().equals(contacts.getJournal_url());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getTel(), getEmail(), getJournal_url());
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", journal_url='" + journal_url + '\'' +
                '}';
    }
}
