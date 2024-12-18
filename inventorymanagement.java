// Class to manage inventory items using a priority queue
public class InventoryManagement {
    private PriorityQueue<InventoryItem> pq = new PriorityQueue<>(); // Priority queue for inventory items

    // Adds a new item to the inventory
    public void addItem(int id, String name, int priority) {
        pq.insert(new InventoryItem(id, name, priority)); // Create and insert a new inventory item
    }

    // Removes the item with the highest priority from the inventory
    public void removeItem() {
        System.out.println("Removed: " + pq.deleteMin()); // Delete and print the removed item
    }

    // Views the next item with the highest priority without removing it
    public void viewNextItem() {
        System.out.println("Next item: " + pq.peekMin()); // Print the item with the highest priority
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();

        // Add items to the inventory
        im.addItem(1, "Apples", 5);
        im.addItem(2, "Bananas", 2);
        im.addItem(3, "Cherries", 8);

        // View and remove items based on priority
        im.viewNextItem(); // Display the item with the highest priority
        im.removeItem();   // Remove the item with the highest priority
        im.viewNextItem(); // Display the next item with the highest priority
    }
}
