Задание:
Разработать Spring Boot приложение на Java.
Приложение должно иметь API и работать с реляционной БД.
Для простоты отладки это может быть in-memory БД, например HSQLDB или иная.

Базовые характеристики сущностей.
Повелитель: Имя и Возраст
Планета: Название
Один Повелитель может управлять несколькими Планетами,
но одной Планетой может править только один Повелитель.

Необходимо разработать структуру таблиц для хранения Повелителей и Планет и связь между ними.

Поддержать методы API:
- Добавить нового Повелителя
- Добавить новую Планету
- Назначить Повелителя управлять Планетой
- Уничтожить Планету
- Найти всех Повелителей бездельников, которые прохлаждаются и не управляют никакими Планетами
- Отобразить ТОП 10 самых молодых Повелителей

Написать тесты для этого функционала

Используемая БД: PostgreSql 

[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/17746524-76d30b44-5fe9-4718-a5c4-e2c94a2d626f?action=collection%2Ffork&collection-url=entityId%3D17746524-76d30b44-5fe9-4718-a5c4-e2c94a2d626f%26entityType%3Dcollection%26workspaceId%3D50dd167e-5c15-4358-9b16-94be44af88a1)

