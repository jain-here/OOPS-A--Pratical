// Custom Annotation: @Version
// Used to track version information of classes

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Version {
    String number();
    String releaseDate() default "Not specified";
    String author() default "Development Team";
}
