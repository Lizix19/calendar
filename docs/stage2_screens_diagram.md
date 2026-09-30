# Схема экранов — этап 2

```mermaid
flowchart TD
    A[MainActivity<br/>список задач] -->|клик по карточке задачи<br/>Intent + putExtra&#40;TASK_ID, id&#41;| B[TaskDetailActivity<br/>детали задачи]
    A -->|клик по FAB &#40;+&#41;<br/>Intent без данных| C[AddTaskActivity<br/>добавление задачи]
```

## Экраны

| Экран | Назначение | Как открывается |
|---|---|---|
| `MainActivity` | Главный экран: список задач через RecyclerView | Запускается при старте приложения (LAUNCHER) |
| `TaskDetailActivity` | Просмотр деталей одной задачи | Клик по карточке в списке; id задачи передаётся через `Intent.putExtra("TASK_ID", task.id)` |
| `AddTaskActivity` | Добавление новой задачи | Клик по FloatingActionButton на главном экране; данные пока не передаются |
