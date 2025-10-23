// Custom Annotation: @TestCase
// Used to mark methods that should be executed as test cases

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestCase {
    String description() default "";
    boolean enabled() default true;
}
