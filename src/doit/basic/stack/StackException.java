package basic.stack;

// 실행 시 예외: 스택이 비어있음
class EmptyStackException extends RuntimeException {
    public EmptyStackException() {}
}

// 실행 시 예외: 스택이 가득 참
class OverflowStackException extends RuntimeException {
    public OverflowStackException() {}
}
