/**
 * Project MojaKuhinja, Package PACKAGE_NAME, Class Food, Created by Milovan 30.8.2021.
 */
public class Food extends Nutriment  {

    public Food(String name, String company, double kcal, double proteins,
                double carbohydrates, double fats, double fiber) {
        super(name, company, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Food(String name, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(name, kcal, proteins, carbohydrates, fats, fiber);
    }

    public Food(Food food){
        this(food.getName(), food.getKcal(), food.getProteins(), food.getCarbohydrates(),
                food.getFats(), food.getFiber());
    }


}

