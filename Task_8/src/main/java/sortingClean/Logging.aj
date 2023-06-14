package sortingClean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public aspect Logging {
    private static Long msStart;
    private static Long msFinish;
    private static Long totalTime = 0L;
    private static int counter = 0;

    private static Map<String, Integer> counters = new HashMap<String, Integer>() {{
        put("MergeSort", 0);
        put("QuickSort", 0);
        put("BubbleSort", 0);
        put("InsertionSort", 0);
    }};

    private static Map<String, Long> times = new HashMap<String, Long>() {{
        put("MergeSort", 0L);
        put("QuickSort", 0L);
        put("BubbleSort", 0L);
        put("InsertionSort", 0L);
    }};



    @Pointcut("execution(* *.*.sort*(..))")
    private void selectSort(){}

    @Pointcut("execution(* *.*.runAlgorithms*(..))")
    private void end(){}



    @Before("selectSort()")
    public void beforeSort(){
        msStart = System.currentTimeMillis();
    }


    @After("end()")
    public void afterLogging(){
        System.out.println("Total time of running all sort functions was " +
                totalTime +  " ms");
        for (Map.Entry<String, Integer> entry : counters.entrySet()) {
            if (entry.getValue() >0){
                System.out.println("Function sort in " + entry.getKey() + " ran " + entry.getValue()
                        + " times and took in total " + times.get(entry.getKey()) +  " ms");
            }
        }
    }

    @After("selectSort()")
    public void afterSort(JoinPoint jp){
        msFinish = System.currentTimeMillis();
        long runtime = msFinish - msStart;
        totalTime += runtime;
        String className = jp.getSignature().getDeclaringTypeName();
        String simpleClassName = className.substring(className.lastIndexOf(".") + 1);
        counters.put(simpleClassName, counters.get(simpleClassName) + 1);
        times.put(simpleClassName, times.get(simpleClassName) + runtime);
    }
}

