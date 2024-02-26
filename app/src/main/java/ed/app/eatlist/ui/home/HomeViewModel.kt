package ed.app.eatlist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Descripcion"
    }

    private val _testText = MutableLiveData<String>().apply {
        value = "Título"
    }

    val text: LiveData<String> = _text
    val textTest: LiveData<String> = _testText
    val listFood: List<String> = listOf();
}