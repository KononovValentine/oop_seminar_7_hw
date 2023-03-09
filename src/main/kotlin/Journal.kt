public class Journal {
    private var listWorkers = mutableListOf<Worker>()

    // Возвращает список всех работников
    public fun getList(): List<Worker>{
        return listWorkers.toList()
    }

    // Добавляет в список работника
    public fun addWorker(worker: Worker) {
        listWorkers.add(worker)
    }

    // Удаляет из списка работника
    public fun removeWorkerById(id: Int) {
        for (i in listWorkers.indices) {
            if (listWorkers[i].getId() == id) {
                listWorkers.removeAt(i)
            }
        }
    }

    // Возвращает список сотрудников по должности
    public fun getWorkersByPost(post: String): List<Worker> {
        val list = mutableListOf<Worker>()
        for (i in listWorkers) {
            if (i.getPost() == post) {
                list.add(i)
            }
        }
        return list.toList()
    }

    // Возвращает работника по id
    public fun getWorkerById(id: Int): Worker {
        var worker = Worker("", "", 0, "")
        for (i in listWorkers) {
            if (i.getId() == id) {
                worker = i
            }
        }
        return worker
    }

    // Возвращает id всех совпавших по имени и фамилии сотрудников
    public fun getIdWorkerByName(firstName: String, lastName: String) {
        for (i in listWorkers) {
            if (i.getFirstName() == firstName && i.getLastName() == lastName) {
                println("${i.getFirstName()} ${i.getLastName()} id = ${i.getId()}")
            }
        }
    }
}