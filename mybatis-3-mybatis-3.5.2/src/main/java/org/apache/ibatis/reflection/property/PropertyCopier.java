/**
 *    Copyright 2009-2019 the original author or authors.
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
package org.apache.ibatis.reflection.property;

import java.lang.reflect.Field;

import org.apache.ibatis.reflection.Reflector;

/**
 * @author Clinton Begin
 *
 * 将一个对象的属性复制到另一个对象中
 *
 */
public final class PropertyCopier {

  private PropertyCopier() {
    // Prevent Instantiation of Static Class
  }

  /**
   * PropertyCopier 的属性复制工作在 copuBeanProperties 方法中完成
   *
   * 完成对象的输出复制
   *
   * 工作原理：
   * copyBeanProperties方法的工作原理非常简单：通过反射获取类的所有属性，
   * 然后依次将这些属性值从源对象复制出来并赋给目标对象
   * 但是要注意一点，该属性复制器无法完成继承得来的属性的复制，
   * 因为 getDeclaredFields方法返回的属性中不包含继承属性。
   *
   * @param type 对象的类型
   * @param sourceBean 提供属性值的对象
   * @param destinationBean 要被写入新属性值的对象
   */
  public static void copyBeanProperties(Class<?> type, Object sourceBean, Object destinationBean) {
    // 这两个对象同属的类
    Class<?> parent = type;
    while (parent != null) {
      // 获取该类的所有属性
      final Field[] fields = parent.getDeclaredFields();
      // 循环遍历属性进行复制
      for (Field field : fields) {
        try {
          try {
            field.set(destinationBean, field.get(sourceBean));
          } catch (IllegalAccessException e) {
            if (Reflector.canControlMemberAccessible()) {
              field.setAccessible(true);
              field.set(destinationBean, field.get(sourceBean));
            } else {
              throw e;
            }
          }
        } catch (Exception e) {
          // Nothing useful to do, will only fail on final fields, which will be ignored.
        }
      }
      parent = parent.getSuperclass();
    }
  }

}
