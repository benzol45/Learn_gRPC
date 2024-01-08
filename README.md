## Минимальная реализация

* В сообщении одно поле, на одно сообщение один ответ
* Классы генерируются плагином гредла
* На сервере наследуемся от сгенеренного сервиса, получаем DTO-запрос, формируем DTO-ответ
* На клиенте собираем DTO-запрос, выполняем через стаб запрос и получаем ответ

## Реализация со стримингом

* На одно сообщение сервер будет выдавать бесконечный поток ответов
* Классы генерируются плагином гредла, у ответа "stream"
* На сервере наследуемся от сгенеренного сервиса, получаем DTO-запрос, формируем поток DTO-ответов
* На клиенте собираем DTO-запрос, выполняем через стаб запрос и получаем поток ответов

## Реализация  обработки ошибок

* На одно сообщение сервер отвечает одним ответом
* Классы генерируются плагином гредла
* На сервере наследуемся от сгенеренного сервиса, получаем DTO-запрос, если там запрос с пустой строкой - отправит ошибку
* На клиенте собираем DTO-запрос, выполняем через стаб запрос ловим/обрабатываем ошибку


## Ресурсы  

* Видео по работе в джаве от Алишева https://youtu.be/SMy4CaxizbA?si=3FsPQ0PKpFT97RSs

* Мануал от гугла специально по котлину + проект  
Генерация классов - в проекте по ссылке Maven / Gradle Plugin instructions  
Описание сервиса на сервере через корутины  
https://cloud.google.com/blog/products/application-development/use-grpc-with-kotlin
https://github.com/grpc/grpc-kotlin?tab=readme-ov-file

* Настройка сервера и клиента https://medium.com/swlh/using-grpc-with-kotlin-for-building-microservices-2a79d95a236a

* Как поменять путь до файлов .proto https://stackoverflow.com/questions/66794075/how-to-specify-the-protobuf-path-using-protobuf-gradle-plugin

* Подключение в спринг https://piotrminkowski.com/2023/08/29/introduction-to-grpc-with-spring-boot/

* Настройка шифрования https://itnext.io/how-to-setup-and-test-tls-in-grpc-grpc-web-1b67cc4413e6

* Правильная обработка ошибок в Java (в Котлине не реализовано пока https://github.com/grpc/grpc-kotlin/issues/402) https://www.baeldung.com/grpcs-error-handling
тут пока только кидание исключений, описание в сгенеренном из proto файле сервиса

* Cтриминг https://codingwithmohit.com/grpc/grpc-kotlin-coroutines/ и в https://cloud.google.com/blog/products/application-development/use-grpc-with-kotlin
