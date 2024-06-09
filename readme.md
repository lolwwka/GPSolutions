## Имя проекта
### GPSolutions
***
### Суть проекта
#### Проект предоставляет собой API для работы с Отелями. Добавлена документация для всех эндпоинтов и сущностей.
#### Добавлен liquibase и changelog файл для возможности лёгкой миграции таблиц в другую бд
#### Также была добавлена валидация некоторых полей в сущностях для правильной работы приложения
***
## Системные требования
* h2
* tomcat
* java 17
***
## Используемые зависимости
* Hibernate
* h2
* jpa
* Junit
* Liquibase
* Validation
## Сборка проекта
#### Чтобы запустить проект надо выполнить команду в консоли из корня проекта
* mvn spring-boot:run
#### После этого можно отправлять запросы по url: http://localhost:8080/property-view
***
## Остановка проекта
#### В консоли выполнить сочетание клавиш ctrl + c, ввести Y