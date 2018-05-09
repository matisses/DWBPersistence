package co.matisses.persistence.dwb.annotation;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;

/**
 *
 * @author ygil
 */
@SupportedAnnotationTypes("co.matisses.persistence.dwb.annotation.FieldDescription")
public class FieldDescriptionProcessor extends AbstractProcessor {

    public FieldDescriptionProcessor() {
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return true;
    }
}
