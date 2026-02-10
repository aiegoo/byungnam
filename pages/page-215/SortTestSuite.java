import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SortTestSuite {
    private static int passCount = 0;
    private static int failCount = 0;
    
    public static void main(String[] args) {
        System.out.println("===== Sort Test Suite =====\n");
        
        testBubbleSortImplementation();
        testHeapSortImplementation();
        testQuickSortImplementation();
        testDefaultDescription();
        testSortInterface();
        
        System.out.println("\n===== Test Results =====");
        System.out.println("Pass: " + passCount);
        System.out.println("Fail: " + failCount);
        System.out.println("Total: " + (passCount + failCount));
    }
    
    // 테스트 1: BubbleSort 구현 검증
    // given: BubbleSort 인스턴스가 주어졌을 때
    // when: ascending과 descending을 호출하면
    // then: "BubbleSort ascending"과 "BubbleSort descending"이 출력되어야 함
    private static void testBubbleSortImplementation() {
        System.out.println("Test 1: BubbleSort prints correct messages");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: BubbleSort 인스턴스
        Sort sort = new BubbleSort();
        int[] arr = {5, 2, 8, 1, 9};
        
        // when: ascending과 descending 호출
        sort.ascending(arr);
        sort.descending(arr);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 올바른 메시지 출력
        boolean hasAscending = output.contains("BubbleSort ascending");
        boolean hasDescending = output.contains("BubbleSort descending");
        
        if (hasAscending && hasDescending) {
            System.out.println("✅ PASS: BubbleSort messages correct\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: BubbleSort messages incorrect\n");
            failCount++;
        }
    }
    
    // 테스트 2: HeapSort 구현 검증
    // given: HeapSort 인스턴스가 주어졌을 때
    // when: ascending과 descending을 호출하면
    // then: "HeapSort ascending"과 "HeapSort descending"이 출력되어야 함
    private static void testHeapSortImplementation() {
        System.out.println("Test 2: HeapSort prints correct messages");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: HeapSort 인스턴스
        Sort sort = new HeapSort();
        int[] arr = {5, 2, 8, 1, 9};
        
        // when: ascending과 descending 호출
        sort.ascending(arr);
        sort.descending(arr);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 올바른 메시지 출력
        boolean hasAscending = output.contains("HeapSort ascending");
        boolean hasDescending = output.contains("HeapSort descending");
        
        if (hasAscending && hasDescending) {
            System.out.println("✅ PASS: HeapSort messages correct\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: HeapSort messages incorrect\n");
            failCount++;
        }
    }
    
    // 테스트 3: QuickSort 구현 검증
    // given: QuickSort 인스턴스가 주어졌을 때
    // when: ascending과 descending을 호출하면
    // then: "QuickSort ascending"과 "QuickSort descending"이 출력되어야 함
    private static void testQuickSortImplementation() {
        System.out.println("Test 3: QuickSort prints correct messages");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: QuickSort 인스턴스
        Sort sort = new QuickSort();
        int[] arr = {5, 2, 8, 1, 9};
        
        // when: ascending과 descending 호출
        sort.ascending(arr);
        sort.descending(arr);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 올바른 메시지 출력
        boolean hasAscending = output.contains("QuickSort ascending");
        boolean hasDescending = output.contains("QuickSort descending");
        
        if (hasAscending && hasDescending) {
            System.out.println("✅ PASS: QuickSort messages correct\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: QuickSort messages incorrect\n");
            failCount++;
        }
    }
    
    // 테스트 4: 디폴트 메서드 description 검증
    // given: Sort 구현체들이 주어졌을 때
    // when: description()을 호출하면
    // then: 각 알고리즘의 설명이 출력되어야 함
    private static void testDefaultDescription() {
        System.out.println("Test 4: Default description method works");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: 세 가지 Sort 구현체
        Sort bubble = new BubbleSort();
        Sort heap = new HeapSort();
        Sort quick = new QuickSort();
        
        // when: description() 호출
        bubble.description();
        heap.description();
        quick.description();
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 설명 메시지 출력
        boolean hasBubbleDesc = output.contains("버블 정렬");
        boolean hasHeapDesc = output.contains("힙 정렬");
        boolean hasQuickDesc = output.contains("퀵 정렬");
        
        if (hasBubbleDesc && hasHeapDesc && hasQuickDesc) {
            System.out.println("✅ PASS: Description methods work correctly\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: Description methods don't work correctly\n");
            failCount++;
        }
    }
    
    // 테스트 5: Sort 인터페이스 구현 검증
    // given: 세 가지 정렬 구현체가 주어졌을 때
    // when: instanceof로 타입을 확인하면
    // then: 모두 Sort 인터페이스를 구현해야 함
    private static void testSortInterface() {
        System.out.println("Test 5: All sort classes implement Sort interface");
        
        // given: 세 가지 정렬 구현체
        Sort bubble = new BubbleSort();
        Sort heap = new HeapSort();
        Sort quick = new QuickSort();
        
        // when: instanceof로 타입 확인
        boolean bubbleImplements = bubble instanceof Sort;
        boolean heapImplements = heap instanceof Sort;
        boolean quickImplements = quick instanceof Sort;
        
        // then: 모두 Sort 인터페이스 구현
        if (bubbleImplements && heapImplements && quickImplements) {
            System.out.println("✅ PASS: All classes implement Sort interface\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: Not all classes implement Sort interface\n");
            failCount++;
        }
    }
}
