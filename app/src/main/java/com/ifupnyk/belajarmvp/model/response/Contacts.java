package com.ifupnyk.belajarmvp.model.response;

import java.util.List;

public class Contacts {

    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public class Contact {
        private String id;
        private String name;
        private String email;
        private String address;
        private String gender;
        private Phone phone;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getAddress() {
            return address;
        }

        public String getGender() {
            return gender;
        }

        public Phone getPhone() {
            return phone;
        }
    }

    public class Phone {
        private String mobile;
        private String home;
        private String office;

        public String getMobile() {
            return mobile;
        }

        public String getHome() {
            return home;
        }

        public String getOffice() {
            return office;
        }
    }
}
