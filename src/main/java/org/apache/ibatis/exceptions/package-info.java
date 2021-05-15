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
 * Base package for exceptions.
 *
 * Mybatis的众多异常并没有放在exception包中，而是散落在其他各个包中
 * 而这个涉及到项目规划时的分包问题：
 * 1. 按照类型方式划分
 * 例如将所有的接口类接入一个包，将所有的Controller类放入一个包。
 * 这种分类方法从类型上看更为清晰，但是会将完成同一功能的多个类分散在不同的包中，不便于模块化开发
 *
 *
 * 2. 按照功能方式划分
 * 例如将所有与加/解谜有关的类放入一个包，将所有与HTTP请求有关的类放入一个包。
 * 这种方法会让同一功能的类内聚性高，便于模块化开发，但会导致同一包内类的类型混乱
 *
 * 此处的exception包就是按照类型划分出来的，但也有许多异常类按照功能划分了其他包中
 *
 * 在项目设计和挨罚总，推荐有限将功能耦合度高的类放入按照功能划分的包，而将功能耦合度低或供多个功能使用的类放入按照类型划分的包中
 * 这种划分思想不仅可以用在包的划分上，类、方法、代码片段的组合与拆分等都可以参照这种思想
 *
 */
package org.apache.ibatis.exceptions;
