# Создание таблицы users:

## Регистрируемся на Supabase, создаем проект и жмем следующую кнопку

![image](https://github.com/user-attachments/assets/4b87dc26-c72f-4072-bcf7-fcc2daeb8b8e)

## Вставляем туда следующий код:
```sql
create table users (
    id uuid primary key default gen_random_uuid(),
    email text unique not null,
    password text not null,
    created_at timestamp default now()
);
```
# Получение URL и API KEY

## Нажмите кнопку Connect

![image](https://github.com/user-attachments/assets/2197eb05-db0a-485f-8def-fcbfc8843807)

## Нажмите следующую кнопку и вы получите нужные нам данные

![image](https://github.com/user-attachments/assets/dffccaf0-f593-4c61-a367-bd0b1a09649b)

# Редактирование URL и API KEY в проекте

## В ApiSerive.kt вставляем API KEY, взаместо моего (МЕНЯЕМ ТОЛЬКО РАНДОБНЫЙ НАБОР СИМВОЛОВ, ВСЕ ОСТАЛЬНОЕ ОСТАВЛЯЕМ)

![image](https://github.com/user-attachments/assets/42491f79-f3bf-4fac-be12-5cdcc83fae46)

## В RetrofitClient.kt меняем URL

![image](https://github.com/user-attachments/assets/730ad4c3-d768-431d-9f3d-7721b373083f)

## Теперь проект можно запускать 



