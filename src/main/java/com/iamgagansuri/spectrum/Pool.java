/*
 * GROUP 1 SOFTWARE, INC.
 *
 * (c) GROUP 1 SOFTWARE, INC. 1990-2005, AS TO COMPUTER PROGRAMMING
 * AND GRAPHIC DESIGNS. ALL RIGHTS RESERVED.
 *
 * THE FOLLOWING MATERIAL CONTAINS TRADE SECRETS AND
 * CONFIDENTIAL INFORMATION OF GROUP 1 SOFTWARE, INC. THE
 * FOLLOWING MATERIAL IS THE PROPERTY OF GROUP 1 SOFTWARE, INC..
 * THIS MATERIAL SHOULD BE MAINTAINED IN STRICT CONFIDENCE AND IS
 * SUBJECT TO THE CONDITIONS, LIMITATIONS AND DISCLAIMERS OF
 * WARRANTIES AS DESCRIBED IN THE LICENSE AGREEMENT BETWEEN
 * GROUP 1 SOFTWARE, INC. AND THE CUSTOMER.  PROGRAMS DELIVERED
 * MAY CONTAIN PORTIONS OF THE MICRO FOCUS RUNTIME SYSTEM,
 * REPRODUCED WITH THE PERMISSION OF MICRO FOCUS.
 * CERTAIN ELEMENTS OF THIS SOFTWARE HAVE BEEN OBTAINED FROM
 * 3RD PARTIES WHICH RETAIN ALL COPYRIGHTS TO THOSE ELEMENTS
 */
package com.iamgagansuri.spectrum;

import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Contains persistent pool configuration information
 * @since Jan 26, 2004
 */


public class Pool
{
  private CountDownLatch latch;
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private AtomicLong active = new AtomicLong();
  private String name = null;
  private GenericObjectPool genericObjectPool = new GenericObjectPool(null);

  public Pool()
  {
  }

  /**
   * @return Returns the genericObjectPool.
   */
  public GenericObjectPool getGenericObjectPool()
  {
    return genericObjectPool;
  }

  /**
   * @param genericObjectPool The genericObjectPool to set.
   */
  public void setGenericObjectPool(GenericObjectPool genericObjectPool)
  {
    this.genericObjectPool = genericObjectPool;
  }

  /**
   * @return Returns the name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param poolName The name to set.
   */
  public void setName(String poolName)
  {
    this.name = poolName;
  }

  /**
   * @param maxActive The maxActive Pools to set.
   */
  public void setMaxActive(int maxActive)
  {
    genericObjectPool.setMaxTotal(maxActive);
    genericObjectPool.setMaxIdle(maxActive);
  }

  public int getMaxActive()
  {
    return genericObjectPool.getMaxTotal();
  }

  public Object borrowObject() throws Exception
  {
    lock.readLock().lock();
    try
    {
      Object obj = genericObjectPool.borrowObject();
      active.incrementAndGet();
      return obj;
    }
    finally
    {
      lock.readLock().unlock();
    }
  }

  public void returnObject(Object pooledObject) throws Exception
  {
    genericObjectPool.returnObject(pooledObject);
    active.decrementAndGet();
    synchronized (this)
    {
      if (latch != null)
      {
        latch.countDown();
      }
    }
  }

  public void close() throws Exception
  {
    genericObjectPool.close();
  }

  public void clear()
  {
    synchronized (this)
    {
      latch = new CountDownLatch((int)active.get());
    }
    lock.writeLock().lock();
    try
    {
      latch.await();
      genericObjectPool.clear();
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
    finally
    {
      lock.writeLock().unlock();
      latch = null;
    }
  }
}
