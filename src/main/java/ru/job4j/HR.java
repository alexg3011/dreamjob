package ru.job4j;

import java.util.Objects;

public class HR {
    private int id;
    private String name;
    private String company;

    public HR(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HR hr = (HR) o;
        return id == hr.id && Objects.equals(name, hr.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
