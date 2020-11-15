package com.epam.university.java.core.task006;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {

        double amperSum = 0;
        double voltSum = 0;
        double ampVoltSum = 0;
        double ampPowSum = 0;
        try {
            if (measurements.size() < 1) {
                return 0;
            }
            for (Measurement measurement : measurements) {
                amperSum = amperSum + measurement.getAmperage();
                voltSum = voltSum + measurement.getVoltage();
                ampVoltSum = ampVoltSum + measurement.getVoltage() * measurement.getAmperage();
                ampPowSum = ampPowSum + Math.pow(measurement.getAmperage(), 2);
            }
            if (amperSum == 0) {
                return 0;
            }
            double res = (ampVoltSum * measurements.size() - amperSum * voltSum)
                    / (ampPowSum * measurements.size() - amperSum * amperSum);
            BigDecimal resistance = new BigDecimal(res);
            resistance = resistance.setScale(3, RoundingMode.HALF_UP);
            return resistance.doubleValue();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
