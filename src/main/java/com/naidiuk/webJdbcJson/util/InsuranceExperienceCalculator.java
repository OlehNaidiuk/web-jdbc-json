package com.naidiuk.webJdbcJson.util;

public class InsuranceExperienceCalculator {
    public static final int REQUIRED_YEARS_UNTIL_RETIREMENT = 30;

    public int calculateRemainingYearsUntilRetirement(int userWorkExperienceYears) {
        return REQUIRED_YEARS_UNTIL_RETIREMENT - userWorkExperienceYears;
    }
}
