import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Project MojaKuhinja, Package PACKAGE_NAME, Class Meal, Created by Milovan 30.8.2021.
 */
public class Meal {
    private UUID id = UUID.randomUUID();
    private List<Nutriment> nutriments;
    private String name;

    public Meal(List<Nutriment> nutriments, String name) {
        this.nutriments = nutriments;
        this.name = name;
    }
    public Meal(String name) {
        this.nutriments = new ArrayList<>();
        this.name = name;
    }

    public void add(Nutriment n, double weight){
        n.setWeight(weight);
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
        nutriments.remove(n);
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

    public List<Nutriment> getNutriments() {
        return nutriments;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public double getWeight(){
        double sum = 0;
        for (Nutriment n : nutriments){
            sum += n.getWeight();
        }
        return sum;
    }

    public double getKcal(){
        double sum = 0;
        for (Nutriment n : nutriments){
            sum += n.getTotalKcal();
        }
        return sum;
    }

    public double getProteins(){
        double sum = 0;
        for (Nutriment n : nutriments){
            sum += n.getTotalProteins();
        }
        return sum;
    }

    public double getCarbohydrates(){
        double sum = 0;
        for (Nutriment n : nutriments){
            sum += n.getTotalCarbohydrates();
        }
        return sum;
    }

    public double getFats(){
        double sum = 0;
        for (Nutriment n : nutriments){
            sum += n.getTotalFats();
        }
        return sum;
    }

    public double getFiber(){
        double sum = 0;
        for (Nutriment n : nutriments){
            sum += n.getTotalFiber();
        }
        return sum;
    }

    public void nutrimentsInformation(){
        String message = name + " => [weight : " + getWeight() + "] [calories : " + getKcal()
                + "] [proteins : " + getProteins() + "] [carbohydrates : " + getCarbohydrates()
                + "] [fats : " + getFats() + "] [fiber : " + getFiber() + "]";

        System.out.println(message);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("Meal: ").append(name).append(" => ");
        for (Nutriment n : nutriments){
            message.append("[").append(n.getName()).append(", ").append(n.getWeight()).append("g] ");
        }
        message.append("\n");
        return message.toString();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id);
    }

}

