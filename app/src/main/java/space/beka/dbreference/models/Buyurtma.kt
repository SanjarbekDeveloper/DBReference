package space.beka.dbreference.models

class Buyurtma {
    var id = ""
    var name =""
    var price =0
    var sotuvchi:Sotuvchi? = null
    var xaridor:Xaridor? = null

    constructor(id: Int, name: String, price: Int, sotuvchi: Sotuvchi?, xaridor: Xaridor?) {
        this.id = id.toString()
        this.name = name
        this.price = price
        this.sotuvchi = sotuvchi
        this.xaridor = xaridor
    }

    constructor(name: String, price: Int, sotuvchi: Sotuvchi?, xaridor: Xaridor?) {
        this.name = name
        this.price = price
        this.sotuvchi = sotuvchi
        this.xaridor = xaridor
    }

    override fun toString(): String {
        return "Buyurtma(id='$id', name='$name', price=$price, sotuvchi=$sotuvchi, xaridor=$xaridor)"
    }
}