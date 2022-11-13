package com.laborator_IS.resurse.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ComponentType {
    CAROSERIE,
    ROATA,
    VOLAN,
    CLAXON;

    private static final List<ComponentType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ComponentType randomType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
