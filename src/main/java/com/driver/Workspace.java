package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        Collections.sort(calendar,
                (x, y) -> (x.getStartTime().equals(y.getStartTime())) ? (y.getEndTime().compareTo(x.getEndTime())) : (x.getStartTime().compareTo(y.getStartTime()))
        );

        LocalTime lastStart = LocalTime.parse("00:00");
        LocalTime lastEnd = LocalTime.parse("00:00");

        int count = 0;

        for(Meeting m: calendar){
            LocalTime start = m.getStartTime();
            LocalTime end = m.getEndTime();

            if(start.compareTo(lastEnd) > 0){
                lastEnd = end;
                lastStart = start;
                count++;
            }
        }

        return count;

    }
}
