Lift System
There are 8 modules:

Display the position of lifts

Example:

Lifts: L1, L2, L3, L4, L5

Floors: 0, 0, 0, 0

Assign a lift to the user

Input: 2 5

Output: L1 is assigned

Updated positions:

Lifts: L1, L2, L3, L4, L5

Floors: 5, 0, 0, 0

Assign the nearest lift by comparing current positions

Example:

Lifts: L1, L2, L3, L4, L5

Floors: 5, 2, 7, 9, 0

Input: 4 10

Output: L1 is assigned

Updated positions:

Lifts: L1, L2, L3, L4, L5

Floors: 10, 2, 7, 9, 0

Explanation: L1 is closest to floor 4.

Prioritize lifts moving in the same direction if equally near

Example:

User request: 4 → 2 (downward).

L3 is at 5th floor, L5 at 3rd floor.

Assign L3 (moving down).

Floor restrictions:

L1 & L2: 0–5th floor.

L3 & L4: 6–10th floor.

L5: 0–10th floor.

All lifts start at 0th floor.

Assign the lift with the least number of stops

Example:

L3 at 9th floor, L5 at 8th floor.

User request: 8 → 0.

Assign L3 (stops: 8, 7, 6 → 0, total 3 stops).

L5 would stop at every floor (8 stops).

Assign lifts based on capacity

Each lift has a capacity (number of people it can carry).

Maintenance mode

Lifts under maintenance are marked as -1 and cannot be assigned.
