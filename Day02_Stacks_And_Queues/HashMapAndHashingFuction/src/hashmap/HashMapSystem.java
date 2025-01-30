package hashmap;

public class HashMapSystem{
    public static void main(String[] args) {
        HashMap hashMap = new HashMap(10);  // Create a hash map with size 10

        // Insert key-value pairs
        hashMap.insert("name", "Alice");
        hashMap.insert("age", "25");
        hashMap.insert("city", "New York");

        // Get values by keys
        System.out.println("Name: " + hashMap.get("name"));  // Output: Alice
        System.out.println("Age: " + hashMap.get("age"));    // Output: 25

        // Delete a key-value pair
        hashMap.delete("city");
        System.out.println("City: " + hashMap.get("city"));  // Output: null

        // Insert a new key-value pair after deletion
        hashMap.insert("city", "Los Angeles");

        // Print the map to visualize the contents
        hashMap.printMap();
    }
}


