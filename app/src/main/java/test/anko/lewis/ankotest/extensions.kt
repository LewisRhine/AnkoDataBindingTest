package test.anko.lewis.ankotest

import android.view.View

fun <T> View.bind(binder: Binder<T>, binding: (item: T) -> Unit) = binder.bind(this.id, binding)

fun <T> View.unBind(binder: Binder<T>) = binder.unBind(this.id)