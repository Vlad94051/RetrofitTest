package ru.tms.retrofittest

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.tms.retrofittest.domain.NewsInteractor
import ru.tms.retrofittest.domain.NewsInteractorImpl
import ru.tms.retrofittest.network.NewsApi
import ru.tms.retrofittest.network.RetrofitClient

val mainModule = module {
    viewModel {
        MainViewModel(
            interactor = get()
        )
    }

    single<NewsInteractor> {
        NewsInteractorImpl(
            newsApi = get()
        )
    }

    single<NewsApi> {
        RetrofitClient.getNewsApi()
    }
}