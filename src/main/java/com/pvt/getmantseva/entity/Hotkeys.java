package com.pvt.getmantseva.entity;


public class Hotkeys {
    public String hotkey;

    public String getHotkey() {
        return hotkey;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotkeys)) return false;
        Hotkeys hotkeys = (Hotkeys) o;
        return getHotkey().equals(hotkeys.getHotkey());
    }

    @Override
    public String toString() {
        return "Hotkeys{" +
                "hotkey='" + hotkey + '\'' +
                '}';
    }
}

