package ru.tms.retrofittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.tms.retrofittest.domain.NewsInteractor
import ru.tms.retrofittest.network.dto.NewsResponse

class MainViewModel(private val interactor: NewsInteractor): ViewModel() {

    val news : LiveData<NewsResponse> get() = _news
    private val _news = MutableLiveData<NewsResponse>()

    init {
        loadNews()
    }

    private fun loadNews() {
        viewModelScope.launch {
            _news.value = interactor.getNews()
        }
    }
}