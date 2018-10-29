
package com.jpmc.report.model;

import java.time.LocalDate;

/**
 *
 */
public abstract class WeeklyService {
    /**
     * The interface resolve weekend and return next working day
     * @return date object
     */
    protected abstract LocalDate getNextWorkingDay(LocalDate date);

}
