package com.unittest.unittest.util.redis;

/**
 * 不能获取锁的异常类
 *
 * @author https://www.ixushu.com
 */
public class UnableToAcquireLockException extends RuntimeException {

    public UnableToAcquireLockException() {
    }

    public UnableToAcquireLockException(String message) {
        super(message);
    }

    public UnableToAcquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}