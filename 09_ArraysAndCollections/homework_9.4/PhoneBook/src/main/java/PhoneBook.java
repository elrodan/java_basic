package main.java;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    Map<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (checkContact(name, phone)) {
            phoneBook.put(phone, name);
        }
    }

    public String getNameByPhone(String phone) {
        String contact = "";
        if (phoneBook.get(phone) != null) {
            contact = phoneBook.get(phone) + " - " + phone;
        }
        return contact;
    }

    public Set<String> getPhonesByName(String name) {
        Set<String> phonesByName = new TreeSet<>();
        StringBuilder phones = new StringBuilder();
        String nameContact = "";
        for (String item : phoneBook.keySet()) {
            if (phoneBook.get(item).equalsIgnoreCase(name)) {
                nameContact = phoneBook.get(item);
                phones.append(item).append(", ");
            }
        }
        if (!nameContact.isEmpty()) {
            phonesByName.add(nameContact + " - " + phones.toString().trim().replaceFirst(".$", ""));
        }
        return phonesByName;
    }

    public boolean checkContact(String name, String phone) {
        String clearPhone = phone.replaceAll("[\\D]", "");
        Pattern patternPhone = Pattern.compile("^[78][\\d+]{5,}$");
        Matcher matcherPhone = patternPhone.matcher(clearPhone);
        Pattern patternName = Pattern.compile("[А-Я][а-я]+");
        Matcher matcherName = patternName.matcher(name);
        return matcherPhone.find() && matcherName.find();
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();
        String name = "";
        for (String item : phoneBook.keySet()) {
            if (!phoneBook.get(item).equals(name)) {
                name = phoneBook.get(item);
                allContacts.add(getPhonesByName(name).toString().replaceAll("\\[|\\]", ""));
            }
        }
        return allContacts;
    }

}