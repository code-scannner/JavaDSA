package heap;

import java.util.*;

public class MeetingRooms {
    static class Meeting {
        int endTime;
        int roomno;

        Meeting(int _etime, int _roomno) {
            endTime = _etime;
            roomno = _roomno;
        }
    }

    public static int mostBooked(int n, int[][] meetings) {
        int freq[] = new int[n];
        PriorityQueue<Meeting> meets = new PriorityQueue<Meeting>(new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                if (m1.endTime == m2.endTime)
                    return m1.roomno - m2.roomno;
                return m1.endTime - m2.endTime;
            }
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++)
            rooms.offer(i);
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] meet : meetings) {
            while (!meets.isEmpty() && meets.peek().endTime <= meet[0]) {
                rooms.offer(meets.poll().roomno);
            }
            if (rooms.isEmpty()) {
                Meeting endingMeet = meets.poll();

                meets.offer(new Meeting(
                        endingMeet.endTime - meet[0] + meet[1],
                        endingMeet.roomno));
                freq[endingMeet.roomno]++;
            } else {
                int emptyroom = rooms.poll();
                meets.offer(new Meeting(meet[1], emptyroom));
                freq[emptyroom]++;
            }
        }
        int max = 0, room = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > max) {
                max = freq[i];
                room = i;
            }
        }

        return room;
    }

    public static void main(String[] args) {
        int meetings[][] = {
                { 1, 20 }, { 2, 10 }, { 3, 5 }, { 4, 9 }, { 6, 8 }
        };
        // int meetings [] [] = {
        // {0,1},{1,5},{2,7},{3,4}
        // };
        System.out.println(mostBooked(2, meetings));
    }
}
