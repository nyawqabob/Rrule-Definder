package iba.by.algoritm.definder;

import iba.by.algoritm.wrappers.FrequenceWrapper;

import java.util.List;
import java.util.Optional;

public class FrequenceDefinder {

    public FrequenceWrapper defineFrequence(List<FrequenceWrapper> frequenceWrappers, int realAmountOfDurations) {
        Optional<FrequenceWrapper> neededFrequenceWrapper = frequenceWrappers.stream()
                .filter(x -> x.getAmountOfDurationMultipleToFreq() == realAmountOfDurations).findFirst();
        return neededFrequenceWrapper.get();
    }
}
