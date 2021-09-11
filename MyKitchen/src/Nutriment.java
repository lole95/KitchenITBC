/**
 * Project MyKitchen, Package PACKAGE_NAME, Class Nutriment, Created by Milovan 30.8.2021.
 */
public abstract class Nutriment extends Grocery {
    private double weight;
    private double kcal;
    private double proteins;
    private double carbohydrates;
    private double fats;
    private double fiber;

    public Nutriment(String name, String company,
                     double kcal, double proteins, double carbohydrates,
                     double fats, double fiber) {
        super(name, company);
        this.weight = weight;
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fiber = fiber;
    }

    public Nutriment(String name, double kcal, double proteins,
                     double carbohydrates, double fats, double fiber) {
        super(name);
        this.weight = weight;
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fiber = fiber;
    }

    public void update(Double weight, Double kcal, Double proteins,
                       Double carbohydrates, Double fats, Double fiber) {
        if (weight != null) {
            this.weight = weight;
        }
        if (kcal != null) {
            this.kcal = kcal;
        }
        if (proteins != null) {
            this.proteins = proteins;
        }
        if (carbohydrates != null) {
            this.carbohydrates = carbohydrates;
        }
        if (fats != null) {
            this.fats = fats;
        }
        if (fiber != null) {
            this.fiber = fiber;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getKcal() {
        return kcal;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public double getFiber() {
        return fiber;
    }

    public double getTotalKcal() {
        return weight * kcal / 100;
    }

    public double getTotalProteins() {
        return weight * proteins / 100;
    }

    public double getTotalCarbohydrates() {
        return weight * carbohydrates / 100;
    }

    public double getTotalFats() {
        return weight * fats / 100;
    }

    public double getTotalFiber() {
        return weight * fiber / 100;
    }


    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Kcal: " + kcal + "\n"
                + "Proteins: " + proteins + "%\n"
                + "Carbohydrates: " + carbohydrates + "%\n"
                + "Fats: " + fats + "%\n"
                + "Fiber: " + fiber + "%";
    }

    public String totalNutrientTable(){
            return super.toString() + "\n"
                    + "Weight: " + weight + "\n"
                    + "Kcal: " + getTotalKcal() + "\n"
                    + "Proteins: " + getTotalProteins() + "\n"
                    + "Carbohydrates: " + getTotalCarbohydrates() + "\n"
                    + "Fats: " + getTotalFats() + "\n"
                    + "Fiber: " + getTotalFiber();
    }
}

