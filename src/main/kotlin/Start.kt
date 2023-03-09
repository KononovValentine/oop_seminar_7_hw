// Заполняет стартовыми данными журнал работников
public fun start(): Journal {
    val listFirstNames = arrayOf("Зинаида", "Сергей", "Виктор", "Харитон", "Дмитрий", "Андрей", "Владимир", "Аркадий")
    val listLastNames = arrayOf(
        "Муравьева", "Нечаев", "Петров", "Захаров", "Сеченов",
        "Сидоров", "Помидоров", "Капустин"
    )
    val listAges = arrayOf(66, 30, 28, 55, 57, 28, 25, 32)
    val listPosts = arrayOf(
        "Подполковник",
        "Майор",
        "Программист",
        "Начальни отдела нейро-биологии",
        "Министр промышленности СССР",
        "Майор",
        "Майор",
        "Майор"
    )
    val journal = Journal()

    for (i in listFirstNames.indices) {
        val worker = Worker(
            listFirstNames[i],
            listLastNames[i],
            listAges[i],
            listPosts[i]
        )
        journal.addWorker(worker)
    }
    return journal
}