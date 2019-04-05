package domain;

import java.time.LocalTime;

class InputParserFile implements InputParser {

    private static final String SEPARATOR = ",";
    /**
     * It parses guest's entrance and exit.
     * @param line
     * */
    @Override
    public Visit execute(String line) {
        String[] times = line.split(SEPARATOR);
        LocalTime start = LocalTime.parse(times[0]);
        LocalTime end = LocalTime.parse(times[1]);
        return new Visit(start, end);
    }
}
