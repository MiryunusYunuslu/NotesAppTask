package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.db.AppDatabase
import com.example.myapplication.db.NoteDao
import com.example.myapplication.repository.LocalRepository
import com.example.myapplication.repository.LocalRepositoryImplementer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesNoteRepository(noteDao: NoteDao): LocalRepository =
        LocalRepositoryImplementer(noteDao)

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: AppDatabase): NoteDao {
        return appDatabase.noteDao()
    }


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "notes"
        ).build()
    }
}



