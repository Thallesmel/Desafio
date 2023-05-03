import java.util.ArrayList;
import java.util.List;

public class AverageCostCalculator {
    public static void main(String[] args) {
        List<InventoryCost> inventory = new ArrayList<>();
        inventory.add(new InventoryCost("Memory 64Gb", 10, 10.00));
        inventory.add(new InventoryCost("Chipset RX2321", 20, 20.00));
        inventory.add(new InventoryCost("Memory 64Gb", 50, 15.00));
        inventory.add(new InventoryCost("Display DS21344", 100, 12.00));
        inventory.add(new InventoryCost("Chipset RX2321", 80, 25.00));

        // As proximas linhas mostram o resultado das operacoes para os respectivos itens
        System.out.println(calculateAverageCost("Memory 64Gb", inventory));
        System.out.println(calculateAverageCost("Chipset RX2321", inventory));
        System.out.println(calculateAverageCost("Display DS21344", inventory));

        // Os proximos itens tem o nome duplicado, por isso o valor resultará o mesmo
        // independente da quantidade e custo, para calcular o seg
        // System.out.println(calculateAverageCost("Memory 64Gb", inventory));
        // System.out.println(calculateAverageCost("Chipset RX2321", inventory));
    }

    public static double calculateAverageCost(String item, List<InventoryCost> inventory) {
        double totalAmount = 0;
        double totalCost = 0;
        for (InventoryCost icost : inventory) {
            if (icost.item.equals(item)) {
                double amount = icost.quantity;
                double cost = icost.cost;
                totalAmount += amount;
                totalCost += amount * cost;
            }
        }
        if (totalAmount == 0) {
            return 0;
        }
        return totalCost / totalAmount;
    }
}

class InventoryCost {
    public String item;
    public int quantity;
    public double cost;

    public InventoryCost(String item, int quantity, double cost) {
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
    }
}