import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Project MyKitchen, Package PACKAGE_NAME, Class Main, Created by Milovan 30.8.2021.
 */
public class Main {
    public static void main(String[] args) {
        File fridge1 = new File(".\\Fridge1");
        File fridge2 = new File(".\\Fridge2");
        File fridge3 = new File(".\\Fridge3");
        Scanner sc = new Scanner(System.in);

        // Creating nutriments, and than adding them in listOfAllNutriments
        Food noodles = new Food("Noodles", "Bonito",
                10.6, 18, 36.4, 11, 8.2);
        Drink tomatoJuice = new Drink("Tomato_juice", "Bonito",
                13.8, 12, 23.7, 17, 12.2);
        Food porkMilled = new Food("Pork_milled", "AS",
                14, 38, 11.8, 14.4, 14.8);
        Food eggs = new Food("Eggs",
                6.9, 28, 19.7, 16.6, 72.6);
        Food carrot = new Food("Carrot",
                16.9, 31.5, 22.3, 4.6, 13.4);
        Drink water = new Drink("Water",
                1, 2, 5.1, 0, 1);
        Food paprika = new Food("Paprika",
                14.9, 15.2, 3.7, 4, 2);
        Food calfMeat = new Food("Calf_meat", "AS",
                22, 15.7, 3, 15.6, 34.7);
        Food spinach = new Food("Spinach", "Frikom",
                36.6, 25, 21, 4.9, 5.9);
        Food chips = new Food("Chips", "Frikom",
                18.2, 24.7, 14, 31, 4.7);

        ArrayList<Nutriment> listOfAllNutriments = new ArrayList<>();
        ArrayList<Food> listOfAllFood = new ArrayList<>();
        ArrayList<Drink> listOfAllDrinks = new ArrayList<>();

        // If you create new nutriment, don't forger to add it in list listOfAllNutriments below
        listOfAllNutriments.addAll(Arrays.asList(noodles, tomatoJuice, porkMilled, eggs,
                carrot, water, paprika, calfMeat, spinach, chips));

        // Seperating nutriments by class (Food, Drink), and adding them i their respective lists
        for (Nutriment n : listOfAllNutriments){
            if (n instanceof Food){
                listOfAllFood.add((Food) n);
            }
            else {
                listOfAllDrinks.add((Drink) n);
            }
        }

        // Creating meals and than adding them to menu
        Meal bolognese = new Meal("Bolognese");
        bolognese.add(new Food(noodles), 500);
        bolognese.add(new Food(porkMilled), 400);
        bolognese.add(new Drink(tomatoJuice), 350);
        bolognese.add(new Food(paprika), 100);

        Meal calfSoup = new Meal("Calf_soup");
        calfSoup.add(new Drink(water), 1000);
        calfSoup.add(new Food(carrot), 400);
        calfSoup.add(new Food(calfMeat), 600);

        Meal eggsWithSpinach = new Meal("Eggs_with_Spinach");
        eggsWithSpinach.add(new Food(eggs), 150);
        eggsWithSpinach.add(new Food(paprika), 50);
        eggsWithSpinach.add(new Food(spinach), 100);
        eggsWithSpinach.add(new Food(chips), 100);

        // If you create new meal, don't forget to add it in menu, right below
        Meals menu = new Meals();
        menu.add(bolognese);
        menu.add(calfSoup);
        menu.add(eggsWithSpinach);

        // Creating object fridge
        Fridge fridge = new Fridge();
        // Start: LOADING FRIDGE FILE
        System.out.println("0: [New fridge] 1:[Load fridge]");
        int load = sc.nextInt();
        ArrayList<File> files = new ArrayList<>();
        if (load == 1) {
            int i = 1;
            String message = i + ": [Load fridge 1] ";
            files.add(fridge1);
            if (fridge2.length() != 0) {
                files.add(fridge2);
                i++;
                message += i + ": [Load fridge 2] ";
            }
            if (fridge3.length() != 0) {
                files.add(fridge3);
                i++;
                message += i + ": [Load fridge 3] ";
            }
            System.out.println(message);
            int numOfFile = sc.nextInt();
            File file = files.get(numOfFile - 1);

            ArrayList<String[]> listOfNamesAndWeight = new ArrayList<>();
            BufferedReader bUfferedReader = null;
            try {
                bUfferedReader = new BufferedReader
                        (new FileReader(file));
                String line;
                while ((line = bUfferedReader.readLine()) != null) {
                    String[] arrNamesAndWeight = line.split(" ");
                    listOfNamesAndWeight.add(arrNamesAndWeight);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bUfferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (String[] strArr : listOfNamesAndWeight) {
                boolean flag = false;
                for (Food f : listOfAllFood) {
                    if (strArr[0].equals(f.getName())) {
                        fridge.add(new Food(f), Double.parseDouble(strArr[1]));
                        flag = true;
                        break;
                    }
                }
                for (Drink d : listOfAllDrinks) {
                    if (flag) {
                        break;
                    }
                    if (strArr[0].equals(d.getName())) {
                        fridge.add(new Drink(d), Double.parseDouble(strArr[1]));
                        break;
                    }
                }
            }
        }
        // End: LOADING FRIDGE FILE

        while (true) {
            System.out.println("0: [Quit program] 1: [Enter fridge]" +
                    " 2: [Enter menu] 3: [Enter nutriments] 4: [Help]");
            int x = sc.nextInt();
            if (x == 0)
                break;
            if (x == 4){
                help();
                continue;
            }
            switch (x) {
                case 1: // ENTER FRIDGE
                    while (true) {
                        fridgeNutriments(fridge.getNutriments());
                        System.out.println();
                        System.out.println("0: [Back] 1: [Add nutriment] 2: [Remove nutriment] 3: [Create meal]");
                        int f = sc.nextInt();
                        if (f == 0)
                            break;
                        switch (f) {
                            case 1: // ADD NUTRIMENT
                                while (true) {
                                    System.out.println("0: [Back], 1: [Food], 2: [Drink]");
                                    int add = sc.nextInt();
                                    if (add == 0)
                                        break;
                                    switch (add) {
                                        case 1: // ADD FOOD
                                            while (true) {
                                                System.out.println("0: [Back] ");
                                                allFood(listOfAllFood);
                                                int addFood = sc.nextInt();
                                                if (addFood == 0)
                                                    break;
                                                System.out.println("How much (weight):");
                                                double addFoodWeight = sc.nextDouble();
                                                fridge.add(new Food(listOfAllFood.get(addFood - 1)), addFoodWeight);
                                                fridgeNutriments(fridge.getNutriments());
                                                System.out.println();
                                            }
                                            break;
                                        case 2: // ADD DRINK
                                            while (true) {
                                                System.out.println("0: [Back] ");
                                                allDrinks(listOfAllDrinks);
                                                int addDrink = sc.nextInt();
                                                if (addDrink == 0)
                                                    break;
                                                System.out.println("How much (weight):");
                                                double addDrinkWeight = sc.nextDouble();
                                                fridge.add(new Drink(listOfAllDrinks.get(addDrink - 1)), addDrinkWeight);
                                                fridgeNutriments(fridge.getNutriments());
                                                System.out.println();
                                            }
                                            break;
                                    }
                                }
                                break;
                            case 2: // REMOVE NUTRIMENT
                                while (true) {
                                    if (fridge.getNutriments().size() == 0) {
                                        System.out.println("Your fridge is Empty :(");
                                        System.out.println();
                                        break;
                                    }
                                    System.out.println("0: [Back], ");
                                    fridgeNutriments(fridge.getNutriments());
                                    int remove = sc.nextInt();
                                    if (remove == 0)
                                        break;
                                    fridge.remove(fridge.getNutriments().get(remove - 1));
                                }
                                break;
                            case 3: // CREATE MEAL
                                while (true) {
                                    if (menu.search(fridge.getNutriments()).size() == 0) {
                                        System.out.println("You don't have enough nutriments to create any meal :(");
                                        System.out.println();
                                        break;
                                    }
                                    System.out.println("0: [Back], ");
                                    listOfAvailableMeals(menu.search(fridge.getNutriments()), "Available meals");
                                    int createMeal = sc.nextInt();
                                    if (createMeal == 0)
                                        break;
                                    fridge.createMealFromMenu
                                            (menu.search(fridge.getNutriments()).get(createMeal - 1));
                                    fridgeNutriments(fridge.getNutriments());
                                    System.out.println();
                                }
                                break;
                        }
                    }
                    break;
                case 2: // ENTER MENU
                    while (true) {
                        System.out.println("0: [Back]  1: [Search meal]");
                        System.out.println(menu);
                        int mealFromMenu = sc.nextInt();
                        if (mealFromMenu == 0)
                            break;
                        if (mealFromMenu == 1){
                            String name = null;
                            Double[] searchArray = new Double[]{null, null, null, null, null, null};
                            ArrayList<String> searchOptions = new ArrayList<>();
                            searchOptions.addAll(Arrays.asList("[Name]", "[Weight]", "[Calories]",
                                    "[Proteins]", "[Carbohydrates]", "[Fats]", "[Fiber]"));
                            while (true){
                                System.out.print("0: [Finish search] ");
                                searchItems(searchOptions);
                                int searchChoice = sc.nextInt();
                                if (searchChoice == 0){
                                    List<Meal> searchedMeals = menu.search(name, searchArray[0],
                                            searchArray[1],searchArray[2],searchArray[3],searchArray[4],
                                            searchArray[5]);
                                    if (searchedMeals.size() == 0){
                                        System.out.println("No meals found in menu.");
                                    }
                                    else
                                        listOfAvailableMeals(searchedMeals, "Searched meals");
                                    System.out.println();
                                    break;
                                }

                                String searchOptionMember = searchOptions.get(searchChoice - 1);
                                if (searchOptionMember.equals("[Name]")){
                                    System.out.println("Enter name: ");
                                    name = sc.next();
                                    searchOptions.remove("[Name]");
                                    continue;
                                }

                                System.out.println("Max amount of " + searchOptionMember + " in meal:");
                                double maxAmount = sc.nextDouble();
                                switch (searchOptions.get(searchChoice - 1)) {
                                    case "[Weight]":
                                        searchArray[0] = maxAmount;
                                        searchOptions.remove("[Weight]");
                                        break;
                                    case "[Calories]":
                                        searchArray[1] = maxAmount;
                                        searchOptions.remove("[Calories]");
                                        break;
                                    case "[Proteins]":
                                        searchArray[2] = maxAmount;
                                        searchOptions.remove("[Proteins]");
                                        break;
                                    case "[Carbohydrates]":
                                        searchArray[3] = maxAmount;
                                        searchOptions.remove("[Carbohydrates]");
                                        break;
                                    case "[Fats]":
                                        searchArray[4] = maxAmount;
                                        searchOptions.remove("[Fats]");
                                        break;
                                    case "[Fiber]":
                                        searchArray[5] = maxAmount;
                                        searchOptions.remove("[Fiber]");
                                        break;
                                }
                            }
                            continue;
                        }
                        menu.getMeals().get(mealFromMenu - 2).nutrimentsInformation();
                        System.out.println();
                    }
                    break;
                case 3: // ENTER NUTRUIMENTS
                    while (true) {
                        System.out.println("0 : [Back]");
                        allNutriments(listOfAllNutriments);
                        int nutriant = sc.nextInt();
                        if (nutriant == 0)
                            break;
                        System.out.println(listOfAllNutriments.get(nutriant - 1));
                        System.out.println();

                    }
                    break;
            }
        }

        // Start: SAVING FRIDGE FILE
        System.out.println("Do you want to save content of your fridge?");
        System.out.println("0: [No!] 1: [Yes!]");
        int save = sc.nextInt();
        if (save == 1){
            System.out.println("Where do you want to save it?");
            System.out.println("1: [save in fridge 2] 2: [save in fridge 3]");
            int place = sc.nextInt();
            File savePlace = null;
            if (place == 1){
                savePlace = fridge2;
            }
            if (place == 2){
                savePlace = fridge3;
            }

            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter
                        (new FileWriter(savePlace));
                String line;
                for (Nutriment n :  fridge.getNutriments()){
                    line = n.getName() + " " + n.getWeight();
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // End: SAVING FRIDGE FILE
    }
    // Methods for creating nice messages
    private static void allNutriments(ArrayList<Nutriment> nutriments) {
        StringBuilder message = new StringBuilder();
        message.append("All nutriments => ");
        int id = 1;
        for (Nutriment n : nutriments) {
            message.append(id).append(": [").append(n.getName()).append("] ");
            id++;
            if (id % 6 == 0) {
                message.append("\n");
            }
        }
        if (nutriments.size() == 0)
            message.append("Empty");
        System.out.println(message.toString());
    }

    private static void allFood(ArrayList<Food> nutriments) {
        StringBuilder message = new StringBuilder();
        message.append("All food => ");
        int id = 1;
        for (Nutriment n : nutriments) {
            message.append(id).append(": [").append(n.getName()).append("] ");
            id++;
            if (id % 6 == 0) {
                message.append("\n");
            }
        }
        if (nutriments.size() == 0)
            message.append("Empty");
        System.out.println(message.toString());
    }

    private static void allDrinks(ArrayList<Drink> nutriments) {
        StringBuilder message = new StringBuilder();
        message.append("All drinks => ");
        int id = 1;
        for (Nutriment n : nutriments) {
            message.append(id).append(": [").append(n.getName()).append("] ");
            id++;
            if (id % 6 == 0) {
                message.append("\n");
            }
        }
        if (nutriments.size() == 0)
            message.append("Empty");
        System.out.println(message.toString());
    }

    private static void fridgeNutriments(ArrayList<Nutriment> nutriments) {
        StringBuilder message = new StringBuilder();
        message.append("Fridge nutriments => ");
        int id = 1;
        for (Nutriment n : nutriments) {
            message.append(id).append(": [").append(n.getName()).append(", ").append(n.getWeight()).append("g] ");
            id++;
            if (id % 5 == 0) {
                message.append("\n");
            }
        }
        if (nutriments.size() == 0)
            message.append("Empty");
        System.out.println(message.toString());
    }

    private static void listOfAvailableMeals(List<Meal> availableMeals, String partOfMessage) {
        StringBuilder message = new StringBuilder();
        message.append(partOfMessage).append(" => ");
        int id = 1;
        for (Meal m : availableMeals) {
            message.append(id).append(": [").append(m.getName()).append("] ");
            id++;
            if (id % 6 == 0) {
                message.append("\n");
            }
        }
        if (availableMeals.size() == 0)
            message.append("None");
        System.out.println(message.toString());

    }

    private static void searchItems(ArrayList<String> searchOptions) {
        StringBuilder message = new StringBuilder();
        int id = 1;
        for (String s : searchOptions) {
            message.append(id).append(": ").append(s).append(" ");
            id++;
            if (id % 6 == 0) {
                message.append("\n");
            }
        }
        if (searchOptions.size() == 0)
            message.append("[None]");
        System.out.println(message.toString());

    }

    // Print Help/readMe

    public static void help(){
        File readMe = new File(".\\README");
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(readMe));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

