import java.util.ArrayList;
import java.util.List;

/**
 * Project MojaKuhinja, Package PACKAGE_NAME, Class Meals, Created by Milovan 30.8.2021.
 */
public class Meals {
    private List<Meal> meals;

    public Meals(List<Meal> meals) {
        this.meals = meals;
    }
    public Meals() {
        this.meals = new ArrayList<>();
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public boolean add(Meal m){
        if (meals.contains(m))
            return false;

        meals.add(m);
        return true;
    }

    public boolean remove(Meal m){
       return meals.remove(m);
    }

    public List<Meal> search(String mealName){
        List<Meal> searchResult = new ArrayList<>();
        for (Meal m : meals){
            if (m.getName().contains(mealName)){
                searchResult.add(m);
            }
        }
        return searchResult;
    }

    public List<Meal> search(List<Nutriment> fridgeList){
        List<Meal> searchResult = new ArrayList<>();
        for (Meal m : meals){
            boolean flag = true;
            for (int i = 0; i < m.getNutriments().size(); i++) {
                if (!(fridgeList.contains(m.getNutriments().get(i))
                    && fridgeList.get(fridgeList.indexOf(m.getNutriments().get(i))).getWeight()
                        >= m.getNutriments().get(i).getWeight())){
                    flag = false;
                }
            }
            if (flag){
                searchResult.add(m);
            }
        }
        return searchResult;
    }

    public List<Meal> search(double calories){
        List<Meal> searchResult = new ArrayList<>();
        for (Meal m : meals){
            if (m.getKcal() <= calories){
                searchResult.add(m);
            }
        }
        return searchResult;
    }

    public List<Meal> search(String mealName, Double weight,
                             Double calories, Double proteins, Double carbohydrates,
                             Double fats, Double fiber){
        List<Meal> searchResult = new ArrayList<>();
        if (mealName == null && weight == null && calories == null
                && proteins == null && carbohydrates == null && fats == null && fiber == null){
            return searchResult;
        }
        for (Meal m : meals){
            if ((mealName == null || m.getName().contains(mealName))
                    && (weight == null || m.getWeight() <= weight )
                    && (calories == null ||m.getKcal() <= calories)
                    && (proteins == null || m.getProteins() <= proteins)
                    && (carbohydrates == null || m.getCarbohydrates() <= carbohydrates)
                    && (fats == null || m.getFats() <= fats)
                    && (fiber == null || m.getFiber() <= fiber)){
                searchResult.add(m);
            }
        }
        return searchResult;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("<Jelovnik>\n");
        int id = 2;
        for (Meal m : meals){
            String name = id + ": " + m.getName();
            id++;
            String dot = ".";
            message.append(name).append(dot.repeat(40 - name.length())).append(m.getWeight()).append("g\n");
            for (Nutriment n : m.getNutriments()){
                message.append("[").append(n.getName()).append(", ").append(n.getWeight()).append("g] ");
            }
            message.append("\n");
        }

        return message.toString();
    }
}

