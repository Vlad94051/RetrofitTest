package ru.tms.retrofittest.domain

import ru.tms.retrofittest.network.NewsApi
import ru.tms.retrofittest.network.dto.NewsResponse

class NewsInteractorImpl(private val newsApi: NewsApi) : NewsInteractor {

    override suspend fun getNews(): NewsResponse {
        return newsApi.getEverything(
            query = "Политика",
            fromDate = null,
            toDate = null,
            language = "ru",
            sortBy = ""
        )
    }
}