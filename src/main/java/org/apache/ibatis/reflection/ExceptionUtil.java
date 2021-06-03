/**
 *    Copyright 2009-2015 the original author or authors.
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
package org.apache.ibatis.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author Clinton Begin
 * ExceptionUtil是一个异常工具类，它提供一个拆包异常的工具方法unwrapThrowable。
 * 该方法将InvocationTargetException和UndeclaredThrowableException这两类异常进行拆包，得到其中包含的真正的异常。
 */
public class ExceptionUtil {

  private ExceptionUtil() {
    // Prevent Instantiation
  }

  /**
   * unwrapThrowable方法带注释的源码
   * 拆解InvocationTargetException和UndeclaredThrowableException异常的包装，
   * 从而得到被包装的真正异常
   * @param wrapped 包装后的异常
   * @return
   */
  public static Throwable unwrapThrowable(Throwable wrapped) {
    // 从变量用以存放拆包得到的异常
    Throwable unwrapped = wrapped;
    while (true) {
      if (unwrapped instanceof InvocationTargetException) {
        // 拆包获得内部异常
        unwrapped = ((InvocationTargetException) unwrapped).getTargetException();
      } else if (unwrapped instanceof UndeclaredThrowableException) {
        // 拆包获得内部异常
        unwrapped = ((UndeclaredThrowableException) unwrapped).getUndeclaredThrowable();
      } else {
        // 该异常无须拆包
        return unwrapped;
      }
    }

    /**
     * unwrapThrowable方法的结构非常简单，但是我们需要思考它存在的意义：
     * 为什么需要给InvocationTargetException和
     * UndeclaredThrowableException这两个类拆包？
     * 这两个类为什么要把其他异常包装起来？
     *
     * InvocationTargetException：为必检异常
     * UndeclaredThrowableException：为免检的运行时异常
     *
     * 上述两个异常读不属于Mybatis。而时来自java.lang.reflect包
     *
     * 反射操作中，代理类通过反射调用目标类的方法时，
     * 目标类的方法可能抛出异常。反射可以调用各种目标方法，因此目标方法抛出的异常
     * 是多种多样无法确定的。这意味着反射操作可能抛出一个任意类型的异常。
     *
     * 可以使用Throwable去接收这个异常，但这无疑太过宽泛。
     */
  }

}
