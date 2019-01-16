package com.unittest.unittest.util.redis;

/**
 * 获取锁后需要处理的逻辑
 *
 * @author https://www.ixushu.com
 */
@FunctionalInterface
public interface AcquiredLockWorker<T> {

    T invokeAfterLockAcquire() throws Exception;
}
