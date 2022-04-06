package com.iamgagansuri.spectrum;

import org.apache.commons.pool2.*;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ObjectFactory extends BasePooledObjectFactory<PooledObject<test>>
{

  @Override
  public PooledObject<test> create() throws Exception
  {
    return null;
  }

  @Override
  public PooledObject<PooledObject<test>> wrap(PooledObject<test> testPooledObject)
  {
    return new DefaultPooledObject<>(testPooledObject);
  }

  @Override
  public void destroyObject(PooledObject<PooledObject<test>> p, DestroyMode mode) throws Exception
  {
    super.destroyObject(p, mode);
  }
}
