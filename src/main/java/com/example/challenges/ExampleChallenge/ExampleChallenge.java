package com.example.challenges.ExampleChallenge;

import java.util.ArrayList;
import java.util.List;

public class ExampleChallenge{
    public static void main(){
        Food food1 = new Food(1, "Burger", 5.0);
        Resturant resturant1 = new Resturant(1, 4.5, 2.3, new ArrayList<>());

        System.out.println("Hello World");
    }

    public static class Food {
        Integer resturantId;
        String name;

        Double price;

        Food(Integer resturantId, String name, Double price){
            resturantId = resturantId;
            name = name;
            price = price;
        }
    }

    public static class Resturant {
        Integer id;
        Double positionX;
        Double positionY;
        List<Food> foodList;

        Resturant(Integer id, Double positionX, Double positionY, List<Food> foodList){
            id = id;
            positionX = positionX;
            positionY = positionY;
            foodList = foodList;
        }
    }


}
