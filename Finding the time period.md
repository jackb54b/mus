<b>class MaxVisitorsAdapter</b> has a method:
<b>private Result process (InputStream stream)</b>
which finds the period when max number of visitors are in the Museum.
It takes inputStream to allow working with a huge data sets. It iterates through the stream, which 
in every line has visitor's entrance exit hours for instance: '09:52,10:16'. 

In <b>private int visitorsInMinute[]</b> stores number of people in the museum per 
each minute from midnight to end of the day.
<b>private int maxMinuteStart </b> - max period start
<b>private int maxMinuteEnd </b> - max period end
<b>private int maxVisitors </b> - max number of guests
It adds one to visitorsInMinute[i] where i is between entrance and exit visitor(in minutes).
It updates (if necessary) maxVisitors, maxMinuteEnd, maxMinuteStart.

It prints on console result.

    
