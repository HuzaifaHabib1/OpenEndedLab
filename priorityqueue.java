// Generic priority queue class to manage items based on their priority
class PriorityQueue<T extends Item> {
    private List<T> heap = new ArrayList<>(); // Internal heap structure to store items

    // Inserts an item into the priority queue
    public void insert(T item) {
        heap.add(item); // Add the item to the end of the heap
        int current = heap.size() - 1;

        // Reheapify upwards to maintain the heap property
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap.get(current).getPriority() >= heap.get(parent).getPriority()) {
                break; // Stop if the current item's priority is not higher than its parent's
            }
            Collections.swap(heap, current, parent); // Swap the current item with its parent
            current = parent; // Move up the heap
        }
    }

    // Removes and returns the item with the highest priority (lowest priority value)
    public T deleteMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T min = heap.get(0); // Get the item with the highest priority
        heap.set(0, heap.remove(heap.size() - 1)); // Move the last item to the root and remove it
        heapify(0); // Reheapify downwards to restore the heap property
        return min;
    }

    // Returns the item with the highest priority without removing it
    public T peekMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0); // Return the root of the heap
    }

    // Reheapify downwards from the given index to restore the heap property
    private void heapify(int index) {
        int smallest = index; // Assume the current index is the smallest
        int left = 2 * index + 1; // Left child index
        int right = 2 * index + 2; // Right child index

        // Check if the left child has a higher priority (lower value)
        if (left < heap.size() && heap.get(left).getPriority() < heap.get(smallest).getPriority()) {
            smallest = left;
        }

        // Check if the right child has a higher priority (lower value)
        if (right < heap.size() && heap.get(right).getPriority() < heap.get(smallest).getPriority()) {
            smallest = right;
        }

        // If the smallest item is not the current index, swap and recurse
        if (smallest != index) {
            Collections.swap(heap, index, smallest);
            heapify(smallest);
        }
    }
}