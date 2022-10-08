package space.beka.dbreference.db

import android.widget.Button
import space.beka.dbreference.models.Buyurtma
import space.beka.dbreference.models.Sotuvchi
import space.beka.dbreference.models.Xaridor
import java.util.*

interface MyDbInterface {
    fun addSalesman(sotuvchi: Sotuvchi)
    fun addCustomer(xaridor: Xaridor)
    fun addOrder(buyurtma: Buyurtma)
    fun getAllSalesman():List<Sotuvchi>
    fun getAllCustomer(): List<Xaridor>
    fun  getAllOrders():List<Buyurtma>
fun getSalesmanById(id:Int):Sotuvchi
fun getCustomerById(id: Int):Xaridor
}