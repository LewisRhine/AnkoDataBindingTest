package test.anko.lewis.ankotest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    private val model = Model(Binder("Oh, Hi Mark."), Binder(true))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI(model).setContentView(this)
    }

    fun changeData(text: String) {
        model.bindText.item = text
    }
}
