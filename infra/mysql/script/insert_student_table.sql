USE schooldb;

INSERT INTO student (
  teacher_id, student_name, login_id, class_id, class_name, created_at, updated_at
  )
VALUES
  ( 1, '佐藤', 'foo123', 1, 'クラスA', NOW(), NOW()),
  ( 2, '鈴⽊', 'bar456', 2, 'クラスB', NOW(), NOW()),
  ( 1, '⽥中', 'baz789', 3, 'クラスC', NOW(), NOW()),
  ( 1, '加藤', 'hoge0000', 1, 'クラスA', NOW(), NOW()),
  ( 2, '太⽥', 'fuga1234', 2, 'クラスB', NOW(), NOW()),
  ( 1, '佐々⽊', 'piyo5678', 3, 'クラスC', NOW(), NOW()),
  ( 1, '⼩⽥原', 'fizz9999', 1, 'クラスA', NOW(), NOW()),
  ( 2, 'Smith', 'buzz777', 2, 'クラスB', NOW(), NOW()),
  ( 1, 'Johnson', 'fizzbuzz#123', 3, 'クラスC', NOW(), NOW()),
  ( 1, 'Williams', 'xxx:42', 1, 'クラスA', NOW(), NOW());