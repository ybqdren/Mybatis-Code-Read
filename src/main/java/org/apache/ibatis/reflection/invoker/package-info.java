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
/**
 * Unused.
 *
 * 执行器子包，该子包中的类能够基于反射实现对象方法的调动和对象属性的读写
 * 包含一个Invoker接口和三个实现
 *
 * Invoker接口的三个实现分别用来处理三种不同情况：
 * {@link GetFieldInvoker}：负责对象属性的读操作
 * {@link SetGieldInvoker}：负责对象属性的写操作
 * {@link MethodInvoker}： 负责对象其他方法的操作
 *
 */
package org.apache.ibatis.reflection.invoker;