package com.swyrazik.monstersanctuary.companion.testing.endtoend.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Test
@Tag(EndToEndTest.TAG)
public @interface EndToEndTest {
    
    String TAG = "e2e";
}
