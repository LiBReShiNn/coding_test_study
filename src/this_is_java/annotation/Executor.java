package this_is_java.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Executor {
    public static void main(String[] args) {

        // ServiceClass로 부터 Method정보를 받음. reflection.
        Method[] declaredMethods = Service.class.getDeclaredMethods();

        for (Method method : declaredMethods) {
            //PrintAnnotaion이 적용되었는지 확인
            // isAnnotationPresent(Class<? Extends Annotation> annotationClass)
            if (method.isAnnotationPresent(PrintAnnotaion.class)) {
                //PrintAnnotation 객체 얻기
                //getAnnotation(Class<T> annotationClass)
                PrintAnnotaion pa = method.getAnnotation(PrintAnnotaion.class);

                // 메소드명
                System.out.println(method.getName());
                // annotation value 활용
                for (int i = 0; i < pa.number(); i++) {
                    System.out.print(pa.value());
                }
                System.out.println();

                try {
                    // 메소드 호출
                    method.invoke(new Service());
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
    }
}
