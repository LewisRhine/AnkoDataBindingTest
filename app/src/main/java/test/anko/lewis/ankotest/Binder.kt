package test.anko.lewis.ankotest

import java.util.*
import kotlin.properties.Delegates

class Binder<T>(initValue: T) {
    private val bound: MutableMap<Int, (item: T) -> Unit> = HashMap()

    var item: T by Delegates.observable(initValue) { prop, old, new -> if (old != new) bound.values.forEach { it(new) } }

    fun bind(id: Int, binding: (item: T) -> Unit) {
        bound.put(id, binding)
        binding(item)
    }

    fun unBind(id: Int) = bound.remove(id)
}
