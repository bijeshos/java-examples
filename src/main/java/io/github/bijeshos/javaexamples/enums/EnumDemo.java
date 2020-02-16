package io.github.bijeshos.javaexamples.enums;

/*
Enum implicitly implements Serializable and Comparable
 */
public class EnumDemo {
    public static void main(String[] args) {
        EnumDemo enumTest = new EnumDemo();
        enumTest.fruitTest();
        enumTest.fruitSwitchTest(Fruit.MANGO);
        enumTest.fruitSwitchTest(Fruit.APPLE);
        enumTest.coinTest();
        enumTest.acronymTest();
        enumTest.singletonTest();
    }

    public void fruitTest() {
        System.out.println("--------------------");
        System.out.println("Inside fruitTest");
        //option 1
        System.out.println(Fruit.APPLE);
        System.out.println(Fruit.MANGO);
        System.out.println(Fruit.ORANGE);
        System.out.println("--------------------");
        //Option 2
        Fruit[] fruits = Fruit.values();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.name());
        }
    }

    public void fruitSwitchTest(Fruit fruit) {
        System.out.println("--------------------");
        System.out.println("Inside fruitSwitchTest");
        switch (fruit) {
            case APPLE:
                System.out.println("Apple");
                break;
            case MANGO:
                System.out.println("Mango");
                break;
            case ORANGE:
                System.out.println("Orange");
                break;
            default:
                System.out.println("Invalid entry");
        }
    }

    public void coinTest() {
        System.out.println("--------------------");
        System.out.println("Inside coinTest");
        System.out.println("Name: " + Coin.PENNY.name() + ", Value: " + Coin.PENNY.getValue());
        System.out.println("Name: " + Coin.QUARTER.name() + ", Value: " + Coin.QUARTER.getValue());
    }

    public void acronymTest() {
        System.out.println("--------------------");
        System.out.println("Inside coinTest");
        System.out.println("Name: " + Acronym.DTO.name() + ", Value: " + Acronym.DTO.toString());
        System.out.println("Name: " + Acronym.VO.name() + ", Value: " + Acronym.VO.toString());
    }

    private void singletonTest() {
        System.out.println("--------------------");
        SampleSingleton.INSTANCE.performAction();
    }

}
