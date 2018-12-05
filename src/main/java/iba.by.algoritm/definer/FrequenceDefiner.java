package iba.by.algoritm.definer;

import iba.by.algoritm.wrappers.FrequenceWrapper;

import java.util.List;
import java.util.Optional;

public class FrequenceDefiner {

    public FrequenceWrapper defineFrequence(List<FrequenceWrapper> frequenceWrappers, int realAmountOfDurations) {
        Optional<FrequenceWrapper> neededFrequenceWrapper = frequenceWrappers.stream()
                .filter(x -> x.getAmountOfDurationMultipleToFreq() == realAmountOfDurations).findFirst();
        return neededFrequenceWrapper.get();
    }
}
