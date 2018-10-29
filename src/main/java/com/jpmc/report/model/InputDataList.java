package com.jpmc.report.model;


import java.util.List;

import com.jpmc.report.model.Instruction;

public interface InputDataList {
    /**
     * This interface provides way to retrieve instructions data from desired input channel
     * @return instructions input data
     */
    List<Instruction> retrieveInstructions();
}
