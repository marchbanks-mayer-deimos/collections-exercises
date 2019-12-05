import java.util.*;

public class Grocery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Input input = new Input();
        ArrayList<String> meat = new ArrayList<>();
        ArrayList<String> diary = new ArrayList<>();

        HashMap<String, ArrayList> stock = new HashMap<>();

        HashMap<String, Integer> meatCart = new HashMap<>();
        HashMap<String, Integer> diaryCart = new HashMap<>();
        HashMap<String, Integer> totalCart = new HashMap<>();


        meat.add("beef");
        meat.add("chicken");
        meat.add("sausage");
        diary.add("milk");
        diary.add("cheese");
        diary.add("yogurt");

        stock.put("Meat", meat);
        stock.put("Diary", diary);

        System.out.println("Would you like to create a grocery list?");
        boolean flag = input.yesNo();
        while (flag) {
            if (totalCart.isEmpty()) {
                System.out.println("Would you like to enter a new item?");
            } else {
                System.out.println("Would you like to finalize the list or would you like to continue shopping? Type add for another item");
            }
            String userInput1 = scanner.nextLine();
            boolean userInputItem = (userInput1.equalsIgnoreCase("yes") || userInput1.equalsIgnoreCase("add"));
            scanner.reset();
            if (!totalCart.isEmpty() && !userInputItem) {
                if (!meatCart.isEmpty()) {
                    System.out.println("Meats:" + finalize(meatCart));
                }
                if (!diaryCart.isEmpty()) {
                    System.out.println("Diary: " + finalize(diaryCart));
                }
                flag = false;
            }
            if (userInputItem) {
                System.out.println("Here are the categories to choose from.");
                for (HashMap.Entry<String, ArrayList> entry : stock.entrySet()) {
                    System.out.println(entry.getKey());
                }
                System.out.println("Select the category.");
                String userCategory = scanner.nextLine();
                System.out.printf("Here are the %s options the grocery store has.%n", userCategory);
                if (userCategory.equalsIgnoreCase("meat")) {
                    for (String item : meat) {
                        System.out.println(item);
                    }
                    System.out.println("Please enter the item you would like.");
                    String userItem = scanner.nextLine();
                    System.out.println("How many would you like?");
                    int userNum = scannerInt.nextInt();
                    meatCart.put(userItem, userNum);
                    totalCart.put(userItem, userNum);
                }
                if (userCategory.equalsIgnoreCase("diary")) {
                    for (String item : diary) {
                        System.out.println(item);
                    }
                    System.out.println("Please enter the item you would like.");
                    String userItem = scanner.nextLine();
                    System.out.println("How many would you like?");
                    int userNum = scannerInt.nextInt();
                    diaryCart.put(userItem, userNum);
                    totalCart.put(userItem, userNum);
                }
                System.out.println("Currently in the cart is:");
                for (HashMap.Entry<String, Integer> entry : totalCart.entrySet()) {
                    System.out.println(entry.getValue() + " " + entry.getKey() + "s");
                }

            }
        }
    }

    public static Map finalize(HashMap cart) {
        Map<String, Float> map = new TreeMap<>(cart);
        return map;

    }
}
