package me.robifoxx.jfunction.annotations;

import me.robifoxx.jfunction.enums.FunctionType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation that will tell the
 * compiler this is a Function.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Function {
    /**
     * @return Name of the function.
     */
    String name();

    /**
     * @return If the function should be a loop function.
     */
    FunctionType type() default FunctionType.SINGLE;

    String namespace() default "";
}
