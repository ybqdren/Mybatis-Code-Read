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
package org.apache.ibatis.exceptions;

import org.apache.ibatis.executor.ErrorContext;

/**
 * @author Clinton Begin
 *
 * 负责生产Exception的工厂
 */
public class ExceptionFactory {

  /**
   * 构造方法由private修饰，确保该方法无法再类的外部被调用，也就永远无法生成该类的实例
   * 通常，会对一些工具类、工厂类等仅提供静态方法的类进行这样的设置，因为这些类不需要实话就可以使用
   */
  private ExceptionFactory() {
    // Prevent Instantiation
  }

  /**
   * 用来生成并返回一个RuntimeException对象
   * @param message
   * @param e
   * @return
   */
  public static RuntimeException wrapException(String message, Exception e) {
    return new PersistenceException(ErrorContext.instance().message(message).cause(e).toString(), e);
  }

}
