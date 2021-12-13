package ru.tms.retrofittest.domain

import ru.tms.retrofittest.network.dto.NewsResponse

interface NewsInteractor {
   suspend fun getNews(): NewsResponse
}