package com.example.androidtestmakkode.repository

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MainRepository @Inject constructor(
    remoteDataSource: RemoteDataSource
) {

    val remote = remoteDataSource
}