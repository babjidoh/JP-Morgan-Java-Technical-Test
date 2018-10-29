package com.jpmc.report.model;

import java.time.LocalDate;

public class StandardWeeklyService extends WeeklyService{

    /**
     * The method resolve weekend and return next working day
     *
     * @param date date need to process
     * @return date object
     */
    @Override
    protected LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate setdate ;
         switch (date.getDayOfWeek()) {
             case SATURDAY:
            	 setdate = date.plusDays(2);
                 break;
             case SUNDAY:
            	 setdate = date.plusDays(1);
                 break;
             default:
            	 setdate = date;
                 break;
         }

         return setdate;
    }
}
