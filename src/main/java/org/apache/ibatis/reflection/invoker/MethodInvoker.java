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
import java.lang.reflect.Method;

import org.apache.ibatis.reflection.Reflector;

/**
 * @author Clinton Begin
 */
public class MethodInvoker implements Invoker {

  private final Class<?> type;
  private final Method method;

  /**
   * MethodInvoker构造方法
   * @param method 方法
   */
  public MethodInvoker(Method method) {
    this.method = method;

    if (method.getParameterTypes().length == 1) {
      // 有且只有一个输入参数时，type为输入参数类型
      type = method.getParameterTypes()[0];
    } else {
      // 否则type为输出参数类型
      type = method.getReturnType();
    }
  }

  /**
   * 代理方法
    * @param target 被代理的目标对象
   * @param args 方法的参数
   * @return 方法执行结果
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  @Override
  public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
    try {
      // 直接通过反射获取目标属性的值
      return method.invoke(target, args);
    } catch (IllegalAccessException e) { // 如果无法访问
      if (Reflector.canControlMemberAccessible()) { // 如果属性的访问性亏修改
        // 将属性的可访问性修改为可访问
        method.setAccessible(true);
        return method.invoke(target, args);
      } else {
        throw e;
      }
    }
  }

  /**
   * 直接返回type属性
   * @return
   */
  @Override
  public Class<?> getType() {
    return type;
  }
}
