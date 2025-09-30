package execution.core.annotations;

import execution.core.enums.CategoryType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom annotation to provide additional metadata for test methods.
 * This annotation allows adding information about authors, categories,
 * user stories, and test IDs to framework methods.
 *
 * @retention RUNTIME - Annotation will be available at runtime
 * @target METHOD - Can only be applied to methods
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {
    
    /**
     * Defines the authors responsible for the test.
     * @return An array of Strings containing the authors' names
     */
    public String[] authors();
    
    /**
     * Specifies the categories to which the test belongs.
     * @return An array of CategoryType defining the test categories
     */
    public CategoryType[] testCategory();
    
    /**
     * Associates the test with a specific user story.
     * @return String representing the user story ID or description
     */
    public String userStory() default "";
    
    /**
     * Uniquely identifies the test in the system.
     * @return String representing the unique test identifier
     */
    public String testID() default "";
}