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
/**
 * Reflection utils.
 *
 *
 */

//  提供反射功能的基础包，该包功能强大且与Mybatis的业务代码耦合度底，可以直接复制到其他项目中使用
/**
 * 装饰器模式在编程开发中经常使用。通常的使用场景是在一个核心基本类的基础上，
 * 提供大量的装饰类，从而使核心基本类经过不同的装饰类修饰后获得不同的功能
 *
 * Java反射机制主要提供了以下功能：
 * - 在运行时判断任意一个对象所属的类
 * - 在运行时构造任意一个类的对象
 * - 在运行时修改任意一个对象的成员变量
 * - 在运行时调用任意一个对象的方法
 *
 * 所以如果要判断两个对象是否属于同一个类，那么可以先通过反射获取对象的类，
 * 然后获取对象的成员变量，轮番比较两个对象的成员变量是否一致。
 */

/**
 * 整个包装类中除了原始对象本身外，还包装了对象包装器、
 * 对象工厂、对象包装器工厂、反射工厂等。因此，只要使用MetaObject对
 * 一个对象进行包装，包装类中就具有大量的辅助类，便于进行各种反射操作。
 *
 * SystemMetaObject中限定了一些默认值，其中的forObject方法可以使用默认值
 * 输出一个MetaObect对象。因此，SystemMetaObject是一个只能使用默认值的MetaObject工厂。
 * MetaClass被称为元类，它是针对类的进一步封装，其内部继承了类可能使用的反射器和反射器工厂。
 */

package org.apache.ibatis.reflection;
