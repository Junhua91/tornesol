package com.junhua.http.exception;

/**
 * 用来包装Exception:
 * left 用来放正确返回值;
 * right 用来存放异常
 */
public class Either<A, B> {

    private A left = null;
    private B right = null;

    public Either(A left, B right) {
        this.left = left;
        this.right = right;
    }

    public static <A, B> Either<A, B> left(A a) {
        return new Either<>(a, null);
    }

    public static <A, B> Either<A, B> right(B b) {
        return new Either<>(null, b);
    }

    public A left() {
        return left;
    }

    public B right() {
        return right;
    }

    public boolean isLeft() {
        return left != null;
    }

    public boolean isRight() {
        return right != null;
    }
}

