package test.anko.lewis.ankotest

import org.jetbrains.anko.*

class MainActivityUI(private val model: Model) : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            textView {
                id = 1
                bind(model.bindOn) {
                    when (it) {
                        true -> bind(model.bindText) { text = it }
                        false -> unBind(model.bindText)
                    }
                }
            }
            editText {
                textChangedListener { onTextChanged { charSequence, p1, p2, p3 -> model.bindText.item = "$charSequence" } }
            }
            button("Say Hello") {
                onClick { (ctx as MainActivity).changeData("Hello Doggy") }
            }
            button {
                id = 2
                bind(model.bindOn) { bindOn ->
                    when (bindOn) {
                        true -> text = "Binding On"
                        false -> text = "Binding Off"
                    }
                    onClick { model.bindOn.item = (bindOn == false) }
                }
            }
        }
    }
}
