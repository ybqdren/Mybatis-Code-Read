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

/**
 * @author Clinton Begin
 */
@SuppressWarnings("deprecation")
public class PersistenceException extends IbatisException {

  // 无参构造方法
  private static final long serialVersionUID = -7537395265357977271L;

  public PersistenceException() {
    super();
  }

  // 传入错误信息字符串的构造方法
  public PersistenceException(String message) {
    super(message);
  }

  // 传入上级Throwable实例和错误信息字符串的构造方法
  public PersistenceException(String message, Throwable cause) {
    super(message, cause);
  }

  // 传入上级Throwable实例
  public PersistenceException(Throwable cause) {
    super(cause);
  }
}
