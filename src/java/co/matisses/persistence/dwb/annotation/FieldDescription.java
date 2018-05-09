package co.matisses.persistence.dwb.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author ygil
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldDescription {

    String description();
}
