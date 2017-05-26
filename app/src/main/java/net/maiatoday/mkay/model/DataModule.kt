package net.maiatoday.mkay.model

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by maia on 2017/05/26.
 */
@Module
class DataModule {

    @Singleton @Provides fun provideAppDatabase(context: Context) = ApplicationDatabase.createPersistentDatabase(context)

}