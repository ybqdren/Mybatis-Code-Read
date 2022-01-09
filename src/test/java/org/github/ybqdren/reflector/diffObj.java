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
package org.github.ybqdren.reflector;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhao Wen
 * @version 1.0.0
 * @description
 **/

public class diffObj {

  /**
   * 比较两个User对象的属性不同
   * @param oldUser
   * @param newUser
   * @return
   */
  public static Map<String,String> diffUser(User oldUser,User newUser){
    Map<String,String> diffMap = new HashMap<>();
    if((oldUser.getId() == null && newUser.getId() != null) ||
      (oldUser.getId()!= null && !oldUser.getId().equals(newUser.getId()))){
      diffMap.put("id","from"+oldUser.getId()+"to"+newUser.getId());
    }

    if((oldUser.getName() == null && newUser.getName() != null) ||
      (oldUser.getName()!=null && !oldUser.getName().equals(newUser.getName()))){
      diffMap.put("name","from"+oldUser.getName()+"to"+newUser.getName());
    }
    return diffMap;
  }

  /**
   * 比较两个任意对象的属性不同
   * 比较任意类型对象的属性不同
   * @param oldObj
   * @param newObj
   * @return
   */
  public static Map<String,String> diffObj(Object oldObj,Object newObj) throws IllegalAccessException {
    Map<String,String> diffMap = new HashMap<>();
    // 获取对象的类
    Class oldObjClazz = oldObj.getClass();
    Class  newObjClazz = newObj.getClass();

    // 判断两个对象是否属于同一个类
    if(oldObjClazz.equals(newObjClazz)){
      // 获取对象所有属性
      Field[] fields = oldObjClazz.getDeclaredFields();
      // 对每个属性逐一判断
      for(Field field:fields){
        // 使属性可以被反射访问
        field.setAccessible(true);
        // 获取当前属性的值
        Object oldValue = field.get(oldObj);
        Object newValue = field.get(newObj);
        // 如果某个属性的值在两个对象中不同，则进行记录
        if((oldValue == null && newValue != null) || oldValue !=null &&
        !oldValue.equals(newValue)){
            diffMap.put(field.getName(),"from"+oldValue+"to"+newValue);
        }
      }
    }
    return diffMap;
  }


}
