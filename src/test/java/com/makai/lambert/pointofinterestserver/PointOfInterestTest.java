package com.makai.lambert.pointofinterestserver;

import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.models.PointOfInterest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointOfInterestTest {

    @Test
    public void constructorTest01() {
        PointOfInterest pointOfInterest = new PointOfInterest("Underground Arts", "Philly", "PA", "Former factory turned into vibrant music venue", 5);
        pointOfInterest.setId(1L);
        String actual = pointOfInterest.toString();


        String expected = "1 Underground Arts Philly PA Former factory turned into vibrant music venue 5";

        Assertions.assertEquals(actual, expected);
    }
}
