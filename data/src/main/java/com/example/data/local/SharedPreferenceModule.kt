package com.example.data.local

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.domain.repo.cityrepo.GetRecentCityRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("StaticFieldLeak")
@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {


    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideRecentRepo(shared: SharedPreferences): GetRecentCityRepo {
        return RecentRepoImpl(shared)
    }
}