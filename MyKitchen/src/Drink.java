/**
 * Project MyKitchen, Package PACKAGE_NAME, Class Drink, Created by Milovan 30.8.2021.
 */
public class Drink extends Nutriment{

    public Drink(String name, String company, double kcal, double proteins,
                 double carbohydrates, double fats, double fiber) {
        super(name, company, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Drink(String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(name, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Drink(Drink drink){
        this(drink.getName(), drink.getKcal(), drink.getProteins(), drink.getCarbohydrates(),
                drink.getFats(), drink.getFiber());
    }
}

