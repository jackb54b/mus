package domain;

import java.io.InputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

final class MaxVisitorsAdapter implements MaxVisitorsPort {

    private final InputParser inputParser;
    private final ResultPresenter resultPresenter;
    private int visitorsInMinute[] = new int[24*60];
    private int maxMinuteStart = 0;
    private int maxMinuteEnd = 0;
    private int maxVisitors = 0;

    /**
     * It finds time period when max number on visitors in museum.
     * It presents the result using resultPresenter object.
     * @param stream Input stream with time when one visitor comes and lives
     * */
    public void execute(InputStream stream) {
        Result result = this.process(stream);
        resultPresenter.execute(result);
    }

    MaxVisitorsAdapter(InputParser inputParser, ResultPresenter resultPresenter){
        this.inputParser = inputParser;
        this.resultPresenter = resultPresenter;
    }

    private Result process (InputStream stream) {
        try( Scanner sc = new Scanner(stream, "UTF-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Visit visit = inputParser.execute(line);
                int startMinute = convertToMinuteFromMidnight(visit.start);
                int endMinute = convertToMinuteFromMidnight(visit.end);
                boolean isMax = false;
                for (int i = startMinute; i <= endMinute; i++) {
                    this.visitorsInMinute[i] += 1;
                    if (this.visitorsInMinute[i] > maxVisitors) {
                        maxVisitors = this.visitorsInMinute[i];
                        maxMinuteStart = i;
                        maxMinuteEnd = i;
                        isMax = true;
                    }
                    if(isMax && this.visitorsInMinute[i] < maxVisitors) {
                        maxMinuteEnd = i-1;
                        isMax = false;
                    }
                }
            }
        }
        return new Result(convertToLocalTime(maxMinuteStart), convertToLocalTime(maxMinuteEnd), maxVisitors);
    }

    private int convertToMinuteFromMidnight(LocalTime localTime) {
        return (int)Duration.between(LocalTime.parse("00:00"), localTime).toMinutes();
    }

    private LocalTime convertToLocalTime(int minutesFromMidnight) {
        LocalTime localTime = LocalTime.parse("00:00");
        return localTime.plusMinutes(minutesFromMidnight);
    }
}
