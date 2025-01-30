package hashmap;

class HashMap {
    private Node[] table;
    private int size;

    public HashMap(int size) {
        this.size = size;
        table = new Node[size];
    }

    // Hash function to compute index from key
    private int hash(String key) {
        return key.hashCode() % size;
    }

    // Insert a key-value pair
    public void insert(String key, String value) {
        int index = hash(key);

        Node newNode = new Node(key, value);

        if (table[index] == null) {
            // No collision, insert directly
            table[index] = newNode;
        } else {
            // Collision, use separate chaining (linked list)
            Node current = table[index];

            // Traverse the list to check if the key already exists
            while (current != null) {
                if (current.key.equals(key)) {
                    // If key already exists, update the value
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            // Insert the new node at the end of the linked list
            newNode.next = table[index];
            table[index] = newNode;
        }
    }

    // Get the value associated with a key
    public String get(String key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;  // If key is not found
    }

    // Delete a key-value pair
    public void delete(String key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    // Node to delete is the first node in the chain
                    table[index] = current.next;
                } else {
                    // Node is in the middle or end of the chain
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Key not found!");
    }

    // Method to print the hash map (for debugging purposes)
    public void printMap() {
        for (int i = 0; i < size; i++) {
            Node current = table[i];
            if (current != null) {
                System.out.print("Index " + i + ": ");
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "] ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
}
