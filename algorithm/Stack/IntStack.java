package algorithm.Stack;

import java.util.Arrays;

/**
 * 24년 6월 29일 알고리즘 공부
 * <p>
 * Stack 직접 구현을 위해 만든 Class
 * IntStack 클래스는 정수형 스택을 구현한 클래스입니다.
 */
public class IntStack {

    private int[] stk; // 스택용 배열
    private int capacity; // 스택의 최대 용량
    private int ptr; // 스택 포인터

    /**
     * 스택이 비어 있는 경우 발생할 예외 클래스
     */
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
            super("Stack is empty");
        }
    }

    /**
     * 스택이 가득 찬 경우 발생할 예외 클래스
     */
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
            super("Stack overflow");
        }
    }

    /**
     * 생성자: 주어진 최대 용량(maxlen)으로 스택을 초기화합니다.
     *
     * @param maxlen 스택의 최대 용량
     */
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 스택 배열 초기화
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    /**
     * 스택에 데이터를 푸시합니다.
     *
     * @param x 스택에 추가할 데이터
     * @return 푸시된 데이터
     * @throws OverflowIntStackException 스택이 가득 찬 경우 발생
     */
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x; // 데이터를 스택에 저장하고 포인터 증가
    }

    /**
     * 스택에서 데이터를 팝합니다. (스택의 꼭대기에서 데이터를 꺼냅니다)
     *
     * @return 팝된 데이터
     * @throws EmptyIntStackException 스택이 비어 있는 경우 발생
     */
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr]; // 포인터를 하나 줄이고 해당 위치의 데이터 반환
    }

    /**
     * 스택의 꼭대기 데이터를 들여다봅니다. (팝하지 않고 꼭대기의 데이터를 확인합니다)
     *
     * @return 꼭대기 데이터
     * @throws EmptyIntStackException 스택이 비어 있는 경우 발생
     */
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1]; // 포인터의 바로 아래 위치의 데이터 반환
    }

    /**
     * 스택을 비웁니다. (스택의 모든 데이터를 삭제합니다)
     */
    public void clear() {
        ptr = 0; // 스택 포인터를 초기화하여 모든 데이터가 삭제됨
        Arrays.fill(stk, 0); // 배열의 요소를 0으로 초기화 (선택적)
    }

    /**
     * 스택에서 주어진 데이터의 인덱스를 찾습니다. (스택의 꼭대기부터 찾아나갑니다)
     *
     * @param x 찾을 데이터
     * @return 데이터의 인덱스 (찾지 못한 경우 -1 반환)
     */
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x) {
                return i; // 데이터를 찾은 경우 해당 인덱스 반환
            }
        }
        return -1; // 데이터를 찾지 못한 경우
    }

    /**
     * 현재 스택의 최대 용량을 반환합니다.
     *
     * @return 스택의 최대 용량
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 스택이 비어 있는지 확인합니다.
     *
     * @return 스택이 비어있으면 true 반환
     */
    public boolean isEmpty() {
        return ptr == 0; // ptr이 0이면 스택이 비어있는 것이다.
    }

    /**
     * 스택이 가득 찼는지 확인합니다.
     *
     * @return 스택이 가득 찼으면 true 반환
     */
    public boolean isFull() {
        return ptr >= capacity;
    }

    /**
     * 스택 안의 모든 데이터를 바닥에서 꼭대기 순서로 출력합니다.
     */
    public void printStack() {
        if (ptr <= 0) {
            System.out.println("Stack is Empty"); // 스택이 비어 있는 경우 메시지 출력
        } else {
            System.out.println("Stack의 요소를 출력합니다:");
            for (int i = 0; i < ptr; i++) {
                System.out.println("인덱스 " + i + ": " + stk[i]); // 각 요소 출력
            }
        }
    }
}
