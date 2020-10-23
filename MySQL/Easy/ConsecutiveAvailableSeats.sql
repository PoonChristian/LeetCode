# LeetCode 603: Consecutive Available Seats
# https://leetcode.com/problems/consecutive-available-seats/

/*

Several friends at a cinema ticket office would like to reserve consecutive available seats.
Can you help to query all the consecutive available seats order by the seat_id using the following cinema table?

| seat_id | free |
|---------|------|
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |

Your query should return the following result for the sample case above.

| seat_id |
|---------|
| 3       |
| 4       |
| 5       |

Note:
The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).
Consecutive available seats are more than 2(inclusive) seats consecutively available.
*/

Create table If Not Exists cinema (seat_id int primary key auto_increment, free bool)
Truncate table cinema
insert into cinema (seat_id, free) values ('1', '1')
insert into cinema (seat_id, free) values ('2', '0')
insert into cinema (seat_id, free) values ('3', '1')
insert into cinema (seat_id, free) values ('4', '1')
insert into cinema (seat_id, free) values ('5', '1')

# Write your MySQL query statement below
SELECT DISTINCT a.seat_id
FROM cinema a
INNER JOIN cinema b ON ABS(a.seat_id - b.seat_id) = 1
WHERE a.free = TRUE AND b.free = TRUE
ORDER BY a.seat_id