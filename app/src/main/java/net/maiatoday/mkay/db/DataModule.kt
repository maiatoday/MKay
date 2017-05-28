package net.maiatoday.mkay.db

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by maia on 2017/05/26.
 */
@Module
class DataModule {

    @Singleton @Provides fun provideAppDatabase(context: Context) = AppDatabase.createPersistentDatabase(context)
//    @Singleton @Provides fun provideAppDatabase(context: Context) = AppDatabase.createInMemoryDatabase(context) //TODO switch to persistent just for messing around

}