package space.beka.dbreference.models

class Xaridor {
    var id:Int = 0
    var name:String = ""
    var number:String = ""
    var address:String = ""

    constructor(id: Int, name: String, number: String, address: String) {
        this.id = id
        this.name = name
        this.number = number
        this.address = address
    }

    constructor(name: String, number: Int, address: String) {
        this.name = name
        this.number = number.toString()
        this.address = address
    }

    override fun toString(): String {
        return "Xaridor(id=$id, name='$name', number='$number', address='$address')"
    }
}