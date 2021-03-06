
#Новые особенности в языке Java 8
* default_methods
* optional
* [Лямбда-выражение](src/com/news/lambda/README.md)
* [Stream API](src/com/news/stream_api/README.md)
* **(** [Java 8](https://github.com/Home-Java8/Java8/tree/master/src/com) **|** [lambda](https://github.com/Home-Java8/Java8/tree/master/src/com/lambda) **|** [lambda0](https://github.com/Home-Java8/Java8/tree/master/src/com/lambda0) **)**

[часть 1](http://info.javarush.ru/translation/2014/10/09/Особенности-Java-8-максимальное-руководство-часть-1-.html) **|** [часть 2](http://info.javarush.ru/translation/2014/10/09/Особенности-Java-8-максимальное-руководство-часть-2-.html)  **(** Ответы: [часть 1](https://jsehelper.blogspot.com/2016/05/java-8-1.html) **|** [часть 2](https://jsehelper.blogspot.com/2016/05/java-8-2.html) **)**
> Главным улучшением в Java 8 является добавление поддержки функциональных программных конструкций к его объектно-ориентированной основе.

###Методы по умолчанию
1.1 default-методы (виртуальные методы расширения)
1.2 Ромбовидное наследование
1.3 Наследование интерфейсов с методами по умолчанию
* [Презентация java 8 (biplane).pdf](https://github.com/Home-Java8/Java8/blob/master/Презентация%20java%208%20(biplane).pdf)
---
    Default методы определяются в интерфейсе и могут иметь реализацию;
    Если в супер классе существует переопределение default-метода - тогда компилятор выбирает эту реализацию;
    Если один из интерфейсов наследуется от второго интерфейса и переопределяет default-метод - тогда компилятор выбирает наиболее спецефическую реализацию;
    Если существует несколько реализаций для default-метода и невозможно определить наиболее спецефическую из них - тогда необходимо явно переопределить этот default-метод;

###Optional
2.0 Класс Optional
* [Java 8: Овладейте новым уровнем абстракции](https://habrahabr.ru/post/256057/)
> — (это контейнер объекта, который имеет некоторые функции высшего порядка) избавляет от лишних null-проверок:
`isPresent()` — метод возвращает ***true*** если экземпляр-Optional *не null*, в противном случае ***false***.
`orElseGet()` — метод содержит запасной механизм результата если Optional содержит *null*.
`orElse()` — метод похож на *orElseGet()*, но вместо функции он принимает значение по умолчанию.
`map()` — метод преобразует текущее значение Optional и возвращает новый экземпляр Optional.
---
    Проблелмы которые могут быть при работе с условными въетвлениями:
    ****************************************************************
    1. Отсутствует проверка на NULL
    2. Отсутствует проверка на 0 (минимум / максимум для размера массива)
    3. Порядок проверки условных значений
    4. Порядок проверки условных значений внутри массива (в случае NULL / 0)

###Лямбда выражения
3.1 Лямбды и Функциональные интерфейсы
3.2 Интерфейсы по умолчанию и статические методы.
3.3 Ссылочные методы
* [Лямбда-выражения в Java 8](https://habrahabr.ru/post/224593/)
---
    Лямбда-выражение представляет собой блок кода, который можно передать в другое место, поэтому он может быть выполнен позже, один или несколько раз:
    - Лямбда-выражение является блоком кода с параметрами.
    - Используйте лямбда-выражение, когда хотите выполнить блок кода в более поздний момент времени.
    - Лямбда-выражения могут быть преобразованы в функциональные интерфейсы.
    - Лямбда-выражения имеют доступ к final переменным из охватывающей области видимости.
    - Ссылки на метод и конструктор ссылаются на методы или конструкторы без их вызова.
    - Теперь вы можете добавить методы по умолчанию и статические методы к интерфейсам, которые обеспечивают конкретные реализации.
    - Вы должны разрешать любые конфликты между методами по умолчанию из нескольких интерфейсов.

###Stream API
4.0 Потоки: Stream API (java.util.stream)
---
    Проблелмы которые могут быть при работе с цыклами:
    *************************************************
    1. Безопасное использование, в случае ошибки есть вероятность зацыкливания
    2. Неоптимальное использование: лишние прохождения в цыкле там где этого НЕнужно
    3. Если присутствует конкретное условие (получить только первый / последний элемент из массива)

```java
int[] arr2 = {8,9,0,1,2,5,6,7,3,4};

/**
 * Оптимизированная сортировка проходит меньшее количество цыклов (только при необходимости)
 */
for (int a1=0; a1<arr2.length; ++a1){
    for (int a2=arr2.length-1; 0<a2; --a2){
        if(arr2[a1]<arr2[a2]){
            int t = arr2[a1];
            arr2[a1] = arr2[a2];
            arr2[a2] = t;
        }
    }
}
```

###Параллелизм
5.1 Параллельные массивы.
5.2 Параллелизм (java.util.concurrent)

###API даты/времени
6.0 API для даты/времени (JSR 310)

###Base64
7.0 Base64

###Aннотации
( 8.1 Повторяющиеся аннотации )
( 8.2 Улучшенное выведение типов )
( 8.3 Расширенная поддержка аннотаций )

###Nashorn
( 9.0 Движок Nashorn JavaScript )

#Top 10 фич Java 8

[bazhenov.me/blog/2014/07/20/java-8-top10.html](http://bazhenov.me/blog/2014/07/20/java-8-top10.html)

![TLAB-1](TLAB-1.png)
![TLAB-2](TLAB-2.png)
![hot-threads](hot-threads.png)
