package com.example.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.domain.repo.GetRecentCityRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {
    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("recent", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferenceEditor(shared: SharedPreferences): SharedPreferences.Editor {
        return shared.edit()
    }

    @Provides
    @Singleton
    fun provideRecentRepo(shared: SharedPreferences): GetRecentCityRepo {
        return RecentRepoImpl(shared)
    }
}