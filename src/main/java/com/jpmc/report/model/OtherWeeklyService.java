
package com.jpmc.report.model;

import java.time.LocalDate;

/**
 *
 */
public class OtherWeeklyService extends WeeklyService {


    /**
     * The method resolve weekend and return next working day
     *
     * @param date need to work on
     * @return date object
     */
    @Override
    protected LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate setdate;
        switch (date.getDayOfWeek()) {
            case FRIDAY:
            	setdate = date.plusDays(2);
                break;
            case SATURDAY:
            	setdate = date.plusDays(1);
                break;
            default:
            	setdate = date;
                break;
        }

        return setdate;
    }
}
