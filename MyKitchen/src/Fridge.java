import java.util.ArrayList;
import java.util.List;

/**
 * Project MyKitchen, Package PACKAGE_NAME, Class Fridge, Created by Milovan 30.8.2021.
 */
public class Fridge {
    private ArrayList<Nutriment> nutriments;

    public Fridge(ArrayList<Nutriment> nutriments) {
        this.nutriments = nutriments;
    }

    public Fridge() {
        this.nutriments = new ArrayList<>();
    }

    public void add(Nutriment n, double weght){
        n.setWeight(weght);
        for (Nutriment nutriment : nutriments) {
            if (nutriment.equals(n)) {
                double newWeight = nutriment.getWeight() + n.getWeight();
                nutriment.setWeight(newWeight);
                return;
            }
        }
        nutriments.add(n);
    }

    public void remove(Nutriment n){
        n.setWeight(0);
        nutriments.remove(n);
    }

    public void createMealFromMenu(Meal meal){
            for (Nutriment n : meal.getNutriments()){
                Nutriment nutriment = nutriments.get(nutriments.indexOf(n));
                double newWeight = nutriment.getWeight() - n.getWeight();
                if (newWeight <= 0){
                    remove(nutriment);
                    continue;
                }
                nutriment.setWeight(newWeight);
            }
            System.out.println("Congatulations, you succsesfully made " + meal.getName() + "!!!!");
        }

    public void remove(Nutriment n, double weight){
        for (Nutriment nutriment : nutriments) {
            if (nutriment.equals(n)) {
                double newWeight = nutriment.getWeight() - weight;
                if (newWeight <= 0){
                    remove(nutriment);
                    return;
                }
                nutriment.setWeight(newWeight);
                return;
            }
        }
    }

    public ArrayList<Nutriment> getNutriments() {
        return nutriments;
    }
}

