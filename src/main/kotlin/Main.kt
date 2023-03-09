fun main() {
    val journal = start()
    println("Добро пожаловать, выберите необходимое действие:")
    while (true) {
        println("Для вывода всех сотрудников введите 1")
        println("Для добавления нового сотрудника введите 2")
        println("Для изменения данных сотрудника введите 3")
        println("Для вывода сотрудников по должности введите 4")
        println("Для удаления сотрудника введите 5")
        println("Для вывода id сотрудника введите 6")
        println("Для выхода введите Q")

        when (readln()) {
            "1" -> {
                getAll(journal)
            }
            "2" -> {
                println("Введите имя сотрудника: ")
                val firstName = readln()
                println("Введите фамилию сотрудника: ")
                val lastName = readln()
                println("Введите возраст сотрудника: ")
                val age = readln().toInt()
                println("Введите должность сотрудника: ")
                var post = readln()
                val  worker = Worker(firstName, lastName, age, post)
                addWorker(journal, worker)
            }
            "3" -> {
                println("Введите id сотрудника: ")
                val id = readln().toInt()
                val worker = getById(journal, id)
                println("Для изменения возраста нажмите 1, для изменения должности нажмите 2")
                when (readln()) {
                    "1" -> {
                        println("Введите возраст: ")
                        val age = readln().toInt()
                        worker.setAge(age)
                    }
                    "2" -> {
                        println("Введите должность: ")
                        val post = readln()
                        worker.setPost(post)
                    }
                }
            }
            "4" -> {
                println("Введите название должности")
                val post = readln()
                getByPost(journal, post)
            }
            "5" -> {
                println("Введите id сотрудника")
                val id = readln().toInt()
                removeWorker(journal, id)
            }
            "6" -> {
                println("Введите имя сотрудника: ")
                val firstName = readln()
                println("Введите фамилию сотрудника: ")
                val lastName = readln()
                getWorkerId(journal, firstName, lastName)
            }
            "Q" -> {
                break
            }
            "q" -> {
                break
            }
        }
        println()
    }
}

private fun getById(journal: Journal, id: Int): Worker {
    return journal.getWorkerById(id)
}

private fun getAll(journal: Journal) {
    val listWorkers = journal.getList()
    for (i in listWorkers) {
        println(i)
    }
}

private fun addWorker(journal: Journal, worker: Worker) {
    journal.addWorker(worker)
}

private fun getByPost(journal: Journal, post: String) {
    val listMajors = journal.getWorkersByPost(post)
    if (listMajors.isNotEmpty()) {
        for (i in listMajors) {
            println(i)
        }
    } else {
        println("Работников с такой должностью не найдено")
    }
}

private fun removeWorker(journal: Journal, id: Int) {
    journal.removeWorkerById(id)
}

private fun getWorkerId(journal: Journal, firstName:String, lastName: String) {
    journal.getIdWorkerByName(firstName, lastName)
}