package domain;

import java.time.LocalTime;

final class Result {

    final LocalTime start;
    final LocalTime end;
    final Integer guests;

    Result(LocalTime start, LocalTime end, Integer guests) {
        this.start = start;
        this.end = end;
        this.guests = guests;
    }
}
