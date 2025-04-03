import java.util.*;

public class Lift {
    public static void main(String[] args) {
        int arr[] = new int[5]; // Unused array - possibly intended for future functionality
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        // Initialize lift positions (values don't match problem statement's initial 0 positions)
        map.put("L1", 5);  // Should be 0 per problem statement
        map.put("L2", 2);  // Should be 0 per problem statement
        map.put("L3", 7);  // Should be 0 per problem statement
        map.put("L4", 9);  // Should be 0 per problem statement
        map.put("L5", 0);  // Only correct initial position

        int n1, n2; // User input values
        String LiftToChange = ""; // Unused variable - possibly intended for tracking
        int i = 0;

        do {  // Loop runs only once (while i < 1)
            n1 = sc.nextInt(); // Source floor input
            n2 = sc.nextInt(); // Destination floor input

            // Floor restriction check (flawed implementation)
            int f = 1; // 1 = restricted, 0 = allowed
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                // Broken condition - logical operators misuse
                if ((key.equals("L1") && (value >= 0 && value <= 5)) ||
                    (key.equals("L2") && (value >= 0 && value <= 5)) &&
                    (key.equals("L3") && (value >= 6 && value <= 10)) ||
                    (key.equals("L4") && (value >= 6 && value <= 10))) {
                    f = 0;
                }
            }

            if (f == 0) {  // If lifts are within allowed ranges (as per flawed check)
                int temp1 = 0; // Sum tracker for L1/L2
                int temp2 = 0; // Sum tracker for L3/L4
                int temp3 = 0; // Sum tracker for L5
                String s1 = ""; // Lift name storage
                String s2 = "";
                String s3 = "";

                // Check for nearby lifts (n1-1, n1, n1+1)
                if (map.containsValue(n1 - 1) || map.containsValue(n1 + 1) || map.containsValue(n1)) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();

                        if (key.equals("L3") || key.equals("L4")) {
                            System.out.println(key + " " + value);
                            if ((value + 1) == n1 || value == n1 || (value - 1) == n1) {
                                if (n1 >= 6 && n1 <= 10) {
                                    s1 = key;
                                    for (int m = 6; m <= n1; m++) {
                                        temp2 += m;
                                    }
                                }
                            }
                        } else if (key.equals("L1") || key.equals("L2")) {
                            if (n1 >= 0 && n1 <= 5) {
                                s2 = key;
                                for (int j = 0; j <= n1; j++) {
                                    temp1 += j;
                                }
                            }
                        } else if (key.equals("L5")) {
                            s3 = key;
                            for (int k = 0; k <= n1; k++) {
                                temp3 += k;
                            }
                        }

                        System.out.println(temp1 + " " + temp2 + " " + temp3);

                        if ((temp2 < temp3) || temp2 < temp1) {
                            map.put(s1, n2);
                        } else if ((temp1 < temp3) || (temp1 < temp2) && (temp1 != 0)) {
                            if (!s2.isEmpty()) {
                                System.out.println("L1 L2");
                                map.put(s2, n2);
                            }
                        } else if ((temp3 < temp1) || (temp3 < temp2) && (temp3 != 0)) {
                            System.out.println("L5");
                            if (!s3.isEmpty()) {
                                map.put(s3, n2);
                            }
                        } else {
                            if (value == n2) {
                                map.put(key, 0);
                            }
                            if (n1 == (value - 1) || n1 == (value + 1) || n1 == value) {
                                map.put(key, n2);
                            }
                        }
                    }
                } else if (map.containsValue(n1 - 1) && map.containsValue(n1 + 1)) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        if (value == (n1 + 1)) {
                            if (value >= n1 && n2 <= value) {
                                map.put(key, n2);
                            }
                        }
                    }
                } else {
                    if (f == 0) {
                        map.put("L1", n2);
                    }
                }
            } else {
                System.out.println("Lifts are being restricted to specific floors!");
            }
            i++;
        } while (i < 1); // Single iteration loop

        System.out.println(map); // Final lift positions
    }
}