import java.util.*;

public class program {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "8123456789");
        addContact(phoneBook, "Петров", "8987654321");
        addContact(phoneBook, "Сидоров", "8111223344");
        addContact(phoneBook, "Иванов", "8555666777");
        addContact(phoneBook, "Васечкин", "8888999000");
        addContact(phoneBook, "Петушков", "8127466789");
        addContact(phoneBook, "Петушков", "8987754620");
        addContact(phoneBook, "Сидоров", "8555423344");
        addContact(phoneBook, "Петров", "8555720787");
        addContact(phoneBook, "Петров", "8928792100");

        printSortedContacts(phoneBook);
    }

    private static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    private static void printSortedContacts(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
