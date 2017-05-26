package net.maiatoday.mkay

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by maia on 2017/05/26.
 */
@Module
class AndroidModule(private val context: Context) {

    @Singleton @Provides fun provideContext(): Context = context

}