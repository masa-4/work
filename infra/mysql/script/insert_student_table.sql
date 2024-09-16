USE schooldb;

INSERT INTO student (
  teacher_id, student_name, login_id, class_id, class_name
  )
VALUES
  ( 1, '佐藤', 'foo123', 1, 'クラスA'),
  ( 2, '鈴⽊', 'bar456', 2, 'クラスB'),
  ( 1, '⽥中', 'baz789', 3, 'クラスC'),
  ( 1, '加藤', 'hoge0000', 1, 'クラスA'),
  ( 2, '太⽥', 'fuga1234', 2, 'クラスB'),
  ( 1, '佐々⽊', 'piyo5678', 3, 'クラスC'),
  ( 1, '⼩⽥原', 'fizz9999', 1, 'クラスA'),
  ( 2, 'Smith', 'buzz777', 2, 'クラスB'),
  ( 1, 'Johnson', 'fizzbuzz#123', 3, 'クラスC'),
  ( 1, 'Williams', 'xxx:42', 1, 'クラスA');