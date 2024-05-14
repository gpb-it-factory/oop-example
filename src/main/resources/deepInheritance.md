## Глубокое наследование

```java
1 javax.swing.JTable$DoubleRenderer
    extends
            2 javax.swing.JTable$NumberRenderer
    extends
            3 javax.swing.table.DefaultTableCellRenderer$UIResource
    extends
            4 javax.swing.table.DefaultTableCellRenderer
    extends
            5 javax.swing.JLabel
    extends
            6 javax.swing.JComponent
    extends
            7 java.awt.Container
    extends
            8 java.awt.Component
    extends
            9 java.lang.Object
```

Пример из Swing - глубина наследования 9. И это далеко не предел. 

В реальной практики рекомендуется использовать композицию вместо наследования, но если вдруг приходится наследоваться, то придерживайтесь
практики наследования глубиной не больше 2-3 уровней. 