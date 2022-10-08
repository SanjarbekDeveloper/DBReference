package space.beka.dbreference.models

class Sotuvchi {
    constructor(id: Int, name: String, number: String) {
        this.id = id
        this.name = name
        this.number = number
    }

    constructor(name: String, number: String) {
        this.name = name
        this.number = number
    }

    var id :Int = 0
    var name: String = ""
    var number: String = ""
}