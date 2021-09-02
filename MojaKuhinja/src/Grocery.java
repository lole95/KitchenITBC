import java.util.Objects;

/**
 * Project MojaKuhinja, Package PACKAGE_NAME, Class Grocery, Created by Milovan 30.8.2021.
 */
public abstract class Grocery implements Energy {
    private String company;
    private String name;

    public Grocery(String name, String company) {
        this.company = company;
        this.name = name;
    }

    public Grocery(String name) {
        this.name = name;
        this.company = "Domestic product";
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grocery grocery = (Grocery) o;
        return Objects.equals(company, grocery.company) &&
                Objects.equals(name, grocery.name);
    }

    @Override
    public String toString() {
        return "Company: "  + company + "\n"
                + "Name: " + name;
    }
}

