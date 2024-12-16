import java.util.*;

// Interface representing an item with basic properties
interface Item {
    int getId();
    String getName();
    int getPriority(); // Lower value indicates higher priority
}

// Class representing an inventory item, implementing the Item interface
class InventoryItem implements Item {
    private int id; // Unique identifier for the item
    private String name; // Name of the item
    private int priority; // Priority value of the item

    // Constructor to initialize an inventory item
    public InventoryItem(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    // Getter for the item ID
    @Override
    public int getId() {
        return id;
    }

    // Getter for the item name
    @Override
    public String getName() {
        return name;
    }

    // Getter for the item priority
    @Override
    public int getPriority() {
        return priority;
    }

    // Returns a string representation of the item
    @Override
    public String toString() {
        return "Item ID: " + id + ", Name: " + name + ", Priority: " + priority;
    }
}