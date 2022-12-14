# AndroidTask7

### Разработать приложение, выполняющее следующие функции:

- Прием от сервера метаинформации для построения формы
- Построение динамической формы ввода данных по принятой информации
- Ввод данных пользователя в построенной форме
- Отправка введенных данных на сервер
- Отображение результата, полученного от сервера

### Во время приёма и отправки на экране отображается ProgressBar

### Форма строится в виде таблицы (использовать RecyclerView), состоящей из двух колонок:

- В левой колонке отображается имя поля
- В правой - элемент управления для ввода значения поля.

### Поля могут быть следующих типов:

- Ввод строки (вводится произвольная текстовая строка)
- Ввод числа (вводится целое или дробное число)
- Выбор значения (выбирается одно значение из списка возможных)

- Внизу формы расположить картинку из поля “image” ([использовать Glide](https://github.com/bumptech/glide)). Картинка должна отображаться на экране всегда, независимо от высоты экрана и высоты таблицы (в случае если не вмещается, картинка отображается поверх таблицы, таблица должна скроллиться над ней)

- Под таблицей располагается кнопка отправки значений. Заголовок формы отображается в стандартной панели вверху экрана.

- Числовые значения должны отправляться с точками в качестве десятичных разделителей.

- Результат операции отправки данных на сервер отображается в диалоге.

- Обязательно использовать Dagger2 , MVVM и принципы Clean Architecture.

***Помните, что, несмотря на то, что данные прилетают всегда одни и те же, подразумевается, что список полностью динамический!***


# Спецификация операции получения метаинформации

- Запрос: GET http://test.clevertec.ru/tt/meta/

Ответ: JSON-объект:
```json
{
	"title": "<заголовок формы>",
	"image": "<ссылка на картинку>",
	"fields": [{
			"title": "<отображаемое название поля>",
			"name": "<программное название поля>",
			"type": "<тип поля>",
			"values": < возможные значения поля >
		},
		{
			...
		},
		...
	]
}
```

# Спецификация операции отправки введенных данных

- Запрос: POST http://test.clevertec.ru/tt/data/
```json
{
	"form": {
		"<программное название поля 1>": "<значение поля 1>",
		"<программное название поля 2>": "<значение поля 2>",
		…
	}
}
```
Ответ: JSON-объект:
```json
{
  "result": "<результат операции>"
}
```
