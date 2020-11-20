package rw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RwLock{
  ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  Lock readLock = readWriteLock.readLock();
  Lock writeLock = readWriteLock.writeLock();
  
}
