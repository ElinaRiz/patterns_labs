# Лабораторные работы по паттернам проектирования.

Материал и лабораторные работы по предмету "Современные языки программирования и паттерны проектирования разработки программного обеспечения".

## Структура

- [**lab1_generative_patterns**](https://github.com/ElinaRiz/patterns_labs/tree/master/lab1_generative_patterns) - Порождающие паттерны ([Singleton](https://github.com/ElinaRiz/patterns_labs/blob/master/lab1_generative_patterns/src/pattern/singleton/ConfigProperties.java), [Factory Method](https://github.com/ElinaRiz/patterns_labs/tree/master/lab1_generative_patterns/src/pattern/factory), [Prototype](https://github.com/ElinaRiz/patterns_labs/blob/master/lab1_generative_patterns/src/Main.java));
- [**lab2_structural_patterns**](https://github.com/ElinaRiz/patterns_labs/tree/master/lab2_structural_patterns) - Структурные паттерны ([Adapter](https://github.com/ElinaRiz/patterns_labs/tree/master/lab2_structural_patterns/pattern_labs/src/pattern/adapter), [Decorator](https://github.com/ElinaRiz/patterns_labs/blob/master/lab2_structural_patterns/pattern_labs/src/transport/SynchronizedTransport.java), [Facade](https://github.com/ElinaRiz/patterns_labs/tree/master/lab2_structural_patterns/traffic_app/Traffic), [Proxy](https://github.com/ElinaRiz/patterns_labs/tree/master/lab2_structural_patterns/proxy));
- [**lab3_behavior_patterns**](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns) - Образцы поведения ([Chain of Responsibility](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/pattern_labs/src/pattern/chain), [Command](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/pattern_labs/src/pattern/command), [Iterator](https://github.com/ElinaRiz/patterns_labs/blob/master/lab3_behavior_patterns/pattern_labs/src/transport/Auto.java), [Memento](https://github.com/ElinaRiz/patterns_labs/blob/master/lab3_behavior_patterns/pattern_labs/src/transport/Auto.java), [Observer](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/observer_pattern5), [State](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/state_pattern6), [Strategy](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/pattern_labs/src/pattern/strategy), [Template Method](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/template_method_pattern8), [Visitor](https://github.com/ElinaRiz/patterns_labs/tree/master/lab3_behavior_patterns/pattern_labs/src/pattern/visitor));
- [**lab4_other_patterns**](https://github.com/ElinaRiz/patterns_labs/tree/master/lab4_other_patterns) - Другие виды паттернов ([MVC](https://github.com/ElinaRiz/patterns_labs/tree/master/lab4_other_patterns/mvc_lab), [DAO](https://github.com/ElinaRiz/patterns_labs/tree/master/lab4_other_patterns/pattern_labs/src/pattern/dao)).

## Стек технологий

- Java
- Java Swing
- Java AWT
- JFreeChart

## Обзор паттернов проектирования

**Порождающие паттерны**

- *Abstract Factory* – Абстрактная фабрика. Предоставляет интерфейс для создания семейств взаимосвязанных или взаимозависимых объектов, не специфицируя их конкретных классов.
- *Builder* – Строитель. Отделяет конструирование сложного объекта от его представления, так что в результате одного и того же процесса конструирования могут получаться разные представления.
- *Factory Method* – Фабричный метод. Определяет интерфейс для создания объекта, но оставляет подклассам решение о том, какой класс инстанцировать. Фабричный метод позволяет классу делегировать инстанцирование подклассам.
- *Prototype* – Прототип. Задает виды создаваемых объектов с помощью экземпляра-прототипа и создает новые объекты путем копирования этого прототипа.
- *Singleton* – Одиночка. Гарантирует, что у класса есть только один экземпляр, и предоставляет к нему глобальную точку доступа.

**Структурные паттерны**

- *Adapter* – Адаптер. Преобразует интерфейс одного класса в интерфейс другого, который ожидают клиенты. Адаптер обеспечивает совместную работу классов с несовместимыми интерфейсами, которая без него была бы невозможна.
- *Bridge* – Мост. Отделяет абстракцию от ее реализации так, чтобы то и другое можно было изменять независимо.
- *Composite* – Компоновщик. Компонует объекты в древовидные структуры для представления иерархий часть-целое. Позволяет клиентам единообразно трактовать индивидуальные и составные объекты.
- *Decorator* – Декоратор. Динамически добавляет объекту новые обязанности. Является гибкой альтернативой порождению подклассов с целью расширения функциональности.
- *Faсade* – Фасад. Предоставляет унифицированный интерфейс вместо набора интерфейсов некоторой подсистемы. Фасад определяет интерфейс более высокого уровня, который упрощает использование подсистемы.
- *Flyweight* – Приспособленец. Использует разделение для эффективной поддержки множества мелких объектов.
- *Proxy* – Заместитель. Является суррогатом другого объекта и контролирует доступ к нему.

**Образцы поведения**

- *Chain of Responsibility* – Цепочка обязанностей. Можно избежать жесткой зависимости отправителя запроса от его получателя, при этом запросом начинает обрабатываться один из нескольких объектов. Объекты-получатели связываются в цепочку, и запрос передается по цепочке, пока какой-то объект его не обработает.
- *Command* – Команда. Инкапсулирует запрос в виде объекта, позволяя тем самым параметризовывать клиентов типом запроса, устанавливать очередность запросов, протоколировать их и поддерживать отмену выполнения операций.
- *Interpreter* – Интерпретатор. Для заданного языка определяет представление его грамматики, а также интерпретатор предложений языка, использующий это представление.
- *Iterator – Итератор*. Дает возможность последовательно обойти все элементы составного объекта, не раскрывая его внутреннего представления.
- *Mediator* – Посредник. Определяет объект, в котором инкапсулировано знание о том, как взаимодействуют объекты из некоторого множества. Способствует уменьшению числа связей между объектами, позволяя им работать без явных ссылок друг на друга. Это, в свою очередь, дает возможность независимо изменять схему взаимодействия.
- *Memento* – Хранитель. Позволяет, не нарушая инкапсуляции, получить и сохранить во внешней памяти внутреннее состояние объекта, чтобы позже объект можно было восстановить точно в таком же состоянии.
- *Observer* – Наблюдатель. Определяет между объектами зависимость типа один-ко-многим, так что при изменении состояния одного объекта все зависящие от него получают извещение и автоматически обновляются.
- *State* – Состояние. Позволяет объекту варьировать свое поведение при изменении внутреннего состояния. При этом создается впечатление, что поменялся класс объекта.
- *Strategy* – Стратегия. Определяет семейство алгоритмов, инкапсулируя их все и позволяя подставлять один вместо другого. Можно менять алгоритм независимо от клиента, который им пользуется.
- *Template Method* – Шаблонный метод. Определяет скелет алгоритма, перекладывая ответственность за некоторые его шаги на подклассы. Позволяет подклассам переопределять шаги алгоритма, не меняя его общей структуры.
- *Visitor* – Посетитель. Представляет операцию, которую надо выполнить над элементами объекта. Позволяет определить новую операцию, не меняя классы элементов, к которым он применяется.

**Другие типы паттернов**

- *MVC* – Model-View-Controller (MVC). **Контроллер** получает данные, вводимые пользователем и определяет их смысл для модели. **Модель** хранит все данные, информацию состояния и логику приложения. Она не знает о существовании представления и контроллера, хотя и предоставляет интерфейс для получения/изменения состояния,а также может отправлять оповещения об изменениях состояния наблюдателям. **Представление** определяет представление модели (пользовательский интерфейс). Как правило, представление получает состояние и данные для отображения непосредственно от модели.

- *DAO* – Data Access Object (DAO). Используется для абстрагирования и инкапсулирования доступа к источнику данных. DAO управляет соединением с источником данных для получения и записи данных.