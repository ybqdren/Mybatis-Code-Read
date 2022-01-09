/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Clinton Begin
 *
 * 拥有两个抽象方法 invoke getType
 */
public interface Invoker {

  /**
   * 执行方法
   * 该方法负责完成对象方法的调用和对象属性的读写
   * 三个实现中，分别是：
   * 属性读取操作 {@link GetFieldInvoker}
   * 属性赋值操作 {@link SetFieldInvoker}
   * 方法触发操作 {@link MethodInvoker}
   * @param target
   * @param args
   * @return
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

  /**
   * 获取类型，对于{@link GetFieldInvoker}和{@link SetFieldInvoker}的含义也是明确的，即获得目标属性的类型
   * 对于{@link MethodInvoker}来说，getType方法直接返回了MethodInvoker的type属性
   * @return
   */
  Class<?> getType();
}
