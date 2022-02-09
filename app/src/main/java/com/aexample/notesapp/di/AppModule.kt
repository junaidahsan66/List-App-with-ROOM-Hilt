package com.aexample.notesapp.di

import android.content.Context
import androidx.room.Room
import com.aexample.notesapp.roomComponents.UserDatabase
import com.aexample.notesapp.repository.UserRepo
import com.aexample.notesapp.roomComponents.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java,"userDataBase").build()

    @Provides
    fun provideDao(userDatabase: UserDatabase) : UserDao =
        userDatabase.userDao()

    @Provides
    fun providesUserRepo(userDao: UserDao) : UserRepo =
        UserRepo(userDao)
}