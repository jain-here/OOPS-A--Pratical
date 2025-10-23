// Custom Annotation: @APIInfo
// Used to document API endpoints with HTTP methods

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface APIInfo {
    String endpoint();
    String method();
}
