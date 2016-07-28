package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by aditya.dalal on 01/05/16.
 */
public class RunTests {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        int count = 0, passed = 0, failed = 0, ignored = 0;
        Class c = CustomAnnotationTests.class;
        Annotation[] annotations = c.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            if(annotation instanceof TesterInfo){
                TesterInfo testerInfo = (TesterInfo) annotation;
                System.out.println(testerInfo.name());
                System.out.println(testerInfo.created_at());
            }
        }

        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(CustomTest.class)) {
                CustomTest customTest = method.getDeclaredAnnotation(CustomTest.class);
                if(customTest.enabled()) {
                    try {
                        method.invoke(c.newInstance());
                        System.out.println(method.getName() + ": Passed, TestCount = " + ++count);
                        passed++;
                    } catch (Throwable e) {
                        System.out.println(method.getName() + ": Failed, TestCount = " + ++count + ", Exception: " + e.getCause());
                        failed++;
                    }
                }
                else {
                    System.out.println(method.getName() + ": Ignored, TestCount = " + ++count);
                    ignored++;
                }
            }
        }
        System.out.printf("Total %d, Passed %d, Failed %d, Ignored %d", count, passed, failed, ignored);
    }
}
