package classes;

import java.util.Arrays;

public final class HashLookup {

    private Employee[] hashTable;
    private int size;

    public HashLookup(int size) {
        this.size = size;
        hashTable = new Employee[size];
        Arrays.fill(hashTable, null); // Fill the array with -1. (-1 is equivalent to an empty cell).
    }

    /**
     * Converts a String (social security number) into a key to store the employee associated with it
     * <
     * Collision handling:
     * In the event of a collision in an index in the table, this index is incremented (+1)
     * and the next position is checked. If the new position is occupied, the process is repeated.
     * />
     *
     * @param EEarray
     */
    public void hashFunction(Employee[] EEarray) {
        int i;

        for (i = 0; i < size; i++) {
            Employee data = EEarray[i];
            int dataIndex = Integer.parseInt(data.getSSN()) % (size - 1);

            System.out.print("Next item -> Index: " + dataIndex + ". Data: " + data.getSSN());

            if (hashTable[dataIndex] == null) {
                System.out.print(" (successfully added).\n");
            } else {
                System.out.print(" (unsuccessfully).\n");
            }

            // Collision handling 
            while (hashTable[dataIndex] != null) {
                dataIndex++;

                System.out.println("A collision ocurred at index " + (dataIndex - 1)
                        + ". Therefore, data " + data.getSSN() + " is moved to the next index.");

                dataIndex %= size;
            }

            hashTable[dataIndex] = data;
        }
    }

    /**
     * Prints the keys and associated data from the hash table
     */
    public void displayTable() {
        final int NUMBER_OF_DASHES = 100;
        int increase = 0, i, j;

        for (i = 0; i < 1; i++) {
            increase += size;
            for (j = 0; j < NUMBER_OF_DASHES; j++) {
                System.out.print("-");
            }

            System.out.println();

            for (j = increase - size; j < increase; j++) {
                System.out.format(" |%4s " + "", j);
            }

            System.out.println("|\n");

            for (j = increase - size; j < increase; j++) {
                if (hashTable[j] == null) {
                    System.out.print("|");
                } else {
                    System.out.print(String.format(" | %4s " + "", hashTable[j].getSSN()));
                }

            }

            System.out.println("|");

            for (j = 0; j < NUMBER_OF_DASHES; j++) {
                System.out.print("-");
            }

            System.out.println();
        }
    }

    /**
     * Given a key, the employee associated with it in the table is returned
     *
     * @param key
     * @return Employee associated with the key or Null if the key does not exist
     */
    public Employee findKey(String key) {
        int dataIndex = Integer.parseInt(key) % (size - 1);
        int count = 0;

        while (hashTable[dataIndex] != null) {
            if (hashTable[dataIndex].getSSN().equalsIgnoreCase(key)) {
                System.out.println("Key " + key + " was found at index " + dataIndex + " in the table.");
                System.out.println("Employee's info who holds the key sought:\n" + hashTable[dataIndex].toString());
                return hashTable[dataIndex];
            }

            dataIndex++;
            dataIndex %= size;
            count++;

            if (count > size) {
                System.out.println("Key " + key + " was not found in the table.");
                break;
            }
        }

        return null;
    }

}
