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
package org.apache.ibatis.exceptions;

/**
 * @author Clinton Begin
 *
 * 设置了值的 serialVersionUID字段
 *
 * 有四种构造方法
 * · 无参构造方法；
 * · 传入错误信息字符串的构造方法；
 * · 传入上级 Throwable实例的构造方法；
 * · 传入上级 Throwable实例和错误信息字符串的构造方法。
 *
 * 为 Throwable 类及其子类创建上述四种构造方法几乎是惯例。这样一来，无论已知几个输入参数信息，都可以方便地调用合适的构造方法创建实例。
 */
@SuppressWarnings("deprecation")
public class PersistenceException extends IbatisException {

  private static final long serialVersionUID = -7537395265357977271L;

  public PersistenceException() {
    super();
  }

  public PersistenceException(String message) {
    super(message);
  }

  public PersistenceException(String message, Throwable cause) {
    super(message, cause);
  }

  public PersistenceException(Throwable cause) {
    super(cause);
  }
}
